package shane.mod.objects.blocks.blockscustom;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLever;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import shane.mod.CustomBlocks;
import shane.mod.init.BlocksInit;
import shane.mod.library.IHasModel;
import shane.mod.objects.items.ItemInit;

public class BlockLampsC extends Block implements IHasModel 
{
	public static final PropertyEnum<BlockLampsC.EnumOrientation> FACING = PropertyEnum.<BlockLampsC.EnumOrientation>create("facing", BlockLampsC.EnumOrientation.class);

	public static final PropertyBool POWERED = PropertyBool.create("powered");

	protected static final AxisAlignedBB LIGHT_SOUTH_AABB = new AxisAlignedBB(0D, 0D, 0.0D, 1D, 1D, 0.26);
	protected static final AxisAlignedBB LIGHT_NORTH_AABB = new AxisAlignedBB(0D, 0D, .74D, 1D, 1D, 1.0D);

	protected static final AxisAlignedBB LIGHT_EAST_AABB = new AxisAlignedBB(0.0D, 0, 0D, 0.26D, 1D, 1);
	protected static final AxisAlignedBB LIGHT_WEST_AABB = new AxisAlignedBB(.74D, 0D, 0D, 1.0D, 1D, 1);

	protected static final AxisAlignedBB LIGHT_UP_AABB = new AxisAlignedBB(0D, 0.0D, 0D, 1D, 0.26D, 1D);
	protected static final AxisAlignedBB LIGHT_DOWN_AABB = new AxisAlignedBB(0D, .70D, 0D, 1D, 1D, 1D);

	public BlockLampsC(String name) 
	{
		super(Material.CIRCUITS);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(0.5f);
		setResistance(30f);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setSoundType(SoundType.STONE);

		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, BlockLampsC.EnumOrientation.NORTH).withProperty(POWERED, Boolean.valueOf(false)));

		BlocksInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public void registerModels() 
	{
		CustomBlocks.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

	// Function
		@Override
		public int getLightValue(IBlockState state) 
		{
			return state.getValue(POWERED) ? 15 : 0;
		}

		public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
		{
			if (worldIn.isRemote) 
			{
				return true;
			} else 
			{
				state = state.cycleProperty(POWERED);
				worldIn.setBlockState(pos, state, 3);
				worldIn.playSound((EntityPlayer) null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3F, 1f);
				worldIn.notifyNeighborsOfStateChange(pos, this, false);
				EnumFacing enumfacing = ((BlockLampsC.EnumOrientation) state.getValue(FACING)).getFacing();
				worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing.getOpposite()), this, false);
				return true;
			}
		}

		public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) 
		{
			if (this.checkCanSurvive(worldIn, pos, state) && !canAttachTo(worldIn, pos, ((BlockLampsC.EnumOrientation) state.getValue(FACING)).getFacing())) 
			{
				this.dropBlockAsItem(worldIn, pos, state, 0);
				worldIn.setBlockToAir(pos);
			}
		}

		public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
		{
			if (((Boolean) state.getValue(POWERED)).booleanValue()) 
			{
				worldIn.notifyNeighborsOfStateChange(pos, this, false);

			}

			super.breakBlock(worldIn, pos, state);
		}

		private boolean checkCanSurvive(World worldIn, BlockPos pos, IBlockState state) 
		{
			if (this.canPlaceBlockAt(worldIn, pos)) 
			{
				return true;
			} else 
			{
				this.dropBlockAsItem(worldIn, pos, state, 0);
				worldIn.setBlockToAir(pos);
				return false;
			}
		}

		// BlockStates
		public IBlockState getStateFromMeta(int meta) 
		{
			return this.getDefaultState().withProperty(FACING, BlockLampsC.EnumOrientation.byMetadata(meta & 7)).withProperty(POWERED, Boolean.valueOf((meta & 8) > 0));
		}

		public int getMetaFromState(IBlockState state) 
		{
			int i = 0;
			i = i | ((BlockLampsC.EnumOrientation) state.getValue(FACING)).getMetadata();

			if (((Boolean) state.getValue(POWERED)).booleanValue()) 
			{
				i |= 8;
			}

			return i;
		}

		protected BlockStateContainer createBlockState() 
		{
			return new BlockStateContainer(this, new IProperty[] { FACING, POWERED });
		}

		// Render
		@Override
		public BlockRenderLayer getBlockLayer() 
		{
			return BlockRenderLayer.CUTOUT;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) 
		{
			return false;
		}

		@Override
		public boolean isFullBlock(IBlockState state) 
		{
			return false;
		}

		@Nullable
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) 
		{
			return NULL_AABB;
		}

		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
		{
			switch ((BlockLampsC.EnumOrientation) state.getValue(FACING)) 
			{
			case EAST:
			default:
				return LIGHT_EAST_AABB;
			case WEST:
				return LIGHT_WEST_AABB;
			case SOUTH:
				return LIGHT_SOUTH_AABB;
			case NORTH:
				return LIGHT_NORTH_AABB;
			case UP_Z:
			case UP_X:
				return LIGHT_UP_AABB;
			case DOWN_X:
			case DOWN_Z:
				return LIGHT_DOWN_AABB;
			}
		}

		// Placement
		public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) 
		{
			return canAttachTo(worldIn, pos, side);
		}

		public boolean canPlaceBlockAt(World worldIn, BlockPos pos) 
		{
			for (EnumFacing enumfacing : EnumFacing.values()) 
			{
				if (canAttachTo(worldIn, pos, enumfacing)) 
				{
					return true;
				}
			}

			return false;
		}

		protected static boolean canAttachTo(World worldIn, BlockPos pos, EnumFacing direction) 
		{
			return BlockLampsC.canPlaceBlock(worldIn, pos, direction);
		}

		public static boolean canPlaceBlock(World worldIn, BlockPos pos, EnumFacing direction) 
		{
			BlockPos blockpos = pos.offset(direction.getOpposite());
			IBlockState iblockstate = worldIn.getBlockState(blockpos);
			boolean flag = iblockstate.getBlockFaceShape(worldIn, blockpos, direction) == BlockFaceShape.SOLID;
			Block block = iblockstate.getBlock();

			if (direction == EnumFacing.UP) {
				return iblockstate.isTopSolid() || !isExceptionBlockForAttaching(block) && flag;
			} else {
				return !isExceptBlockForAttachWithPiston(block) && flag;
			}
		}

		public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
		{
			IBlockState iblockstate = this.getDefaultState().withProperty(POWERED, Boolean.valueOf(false));

			if (canAttachTo(worldIn, pos, facing)) 
			{
				return iblockstate.withProperty(FACING,
						BlockLampsC.EnumOrientation.forFacings(facing, placer.getHorizontalFacing()));
			} else 
			{
				for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) 
				{
					if (enumfacing != facing && canAttachTo(worldIn, pos, enumfacing)) 
					{
						return iblockstate.withProperty(FACING,
								BlockLampsC.EnumOrientation.forFacings(enumfacing, placer.getHorizontalFacing()));
					}
				}

				if (worldIn.getBlockState(pos.down()).isTopSolid()) 
				{
					return iblockstate.withProperty(FACING,
							BlockLampsC.EnumOrientation.forFacings(EnumFacing.UP, placer.getHorizontalFacing()));
				} else 
				{
					return iblockstate;
				}
			}
		}

		// Facing
		public IBlockState withMirror(IBlockState state, Mirror mirrorIn) 
		{
			return state .withRotation(mirrorIn.toRotation(((BlockLampsC.EnumOrientation) state.getValue(FACING)).getFacing()));
		}

		public IBlockState withRotation(IBlockState state, Rotation rot) 
		{
			switch (rot) 
			{
			case CLOCKWISE_180:

				switch ((BlockLampsC.EnumOrientation) state.getValue(FACING)) 
				{
				case EAST:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.WEST);
				case WEST:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.EAST);
				case SOUTH:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.NORTH);
				case NORTH:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.SOUTH);
				default:
					return state;
				}

			case COUNTERCLOCKWISE_90:

				switch ((BlockLampsC.EnumOrientation) state.getValue(FACING)) 
				{
				case EAST:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.NORTH);
				case WEST:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.SOUTH);
				case SOUTH:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.EAST);
				case NORTH:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.WEST);
				case UP_Z:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.UP_X);
				case UP_X:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.UP_Z);
				case DOWN_X:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.DOWN_Z);
				case DOWN_Z:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.DOWN_X);
				}

			case CLOCKWISE_90:

				switch ((BlockLampsC.EnumOrientation) state.getValue(FACING)) 
				{
				case EAST:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.SOUTH);
				case WEST:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.NORTH);
				case SOUTH:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.WEST);
				case NORTH:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.EAST);
				case UP_Z:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.UP_X);
				case UP_X:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.UP_Z);
				case DOWN_X:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.DOWN_Z);
				case DOWN_Z:
					return state.withProperty(FACING, BlockLampsC.EnumOrientation.DOWN_X);
				}

			default:
				return state;
			}
		}

		public static enum EnumOrientation implements IStringSerializable
		{
			DOWN_X(0, "down_x", EnumFacing.DOWN), 
			EAST(1, "east", EnumFacing.EAST), 
			WEST(2, "west", EnumFacing.WEST), 
			SOUTH(3, "south", EnumFacing.SOUTH), 
			NORTH(4, "north", EnumFacing.NORTH), 
			UP_Z(5, "up_z",	EnumFacing.UP), 
			UP_X(6, "up_x", EnumFacing.UP), 
			DOWN_Z(7, "down_z", EnumFacing.DOWN);

			private static final BlockLampsC.EnumOrientation[] META_LOOKUP = new BlockLampsC.EnumOrientation[values().length];
			private final int meta;
			private final String name;
			private final EnumFacing facing;

			private EnumOrientation(int meta, String name, EnumFacing facing) 
			{
				this.meta = meta;
				this.name = name;
				this.facing = facing;
			}

			public int getMetadata() 
			{
				return this.meta;
			}

			public EnumFacing getFacing() 
			{
				return this.facing;
			}

			public String toString() 
			{
				return this.name;
			}

			public static BlockLampsC.EnumOrientation byMetadata(int meta) 
			{
				if (meta < 0 || meta >= META_LOOKUP.length) 
				{
					meta = 0;
				}

				return META_LOOKUP[meta];
			}

			public static BlockLampsC.EnumOrientation forFacings(EnumFacing clickedSide, EnumFacing entityFacing) 
			{
				switch (clickedSide) 
				{
				case DOWN:

					switch (entityFacing.getAxis()) 
					{
					case X:
						return DOWN_X;
					case Z:
						return DOWN_Z;
					default:
						throw new IllegalArgumentException("Invalid entityFacing " + entityFacing + " for facing " + clickedSide);
					}

				case UP:

					switch (entityFacing.getAxis()) 
					{
					case X:
						return UP_X;
					case Z:
						return UP_Z;
					default:
						throw new IllegalArgumentException("Invalid entityFacing " + entityFacing + " for facing " + clickedSide);
					}

				case NORTH:
					return NORTH;
				case SOUTH:
					return SOUTH;
				case WEST:
					return WEST;
				case EAST:
					return EAST;
				default:
					throw new IllegalArgumentException("Invalid facing: " + clickedSide);
				}
			}

			public String getName() 
			{
				return this.name;
			}

			static 
			{
				for (BlockLampsC.EnumOrientation blocklight$enumorientation : values()) 
				{
					META_LOOKUP[blocklight$enumorientation.getMetadata()] = blocklight$enumorientation;
				}
			}
		}
	}