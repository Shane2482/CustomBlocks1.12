package shane.mod.objects.blocks.blocksenum;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import shane.mod.library.IMetaBlockName;

public class BlockIronEnum extends Block implements IMetaBlockName 
{
	public static final PropertyEnum<BlockIronEnum.IronType> TYPE = PropertyEnum.<BlockIronEnum.IronType>create("type", BlockIronEnum.IronType.class);

	public BlockIronEnum(String name, Material material, float hardness, float resistance, String tool, int level, CreativeTabs tab, SoundType sound, float value) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, level);
		setCreativeTab(tab);
		setSoundType(sound);
		setLightLevel(value);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockIronEnum.IronType.iron));
	}

	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return IronType.values()[stack.getItemDamage()].getName();
	}

	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((BlockIronEnum.IronType) state.getValue(TYPE)).getMetadata();
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for (BlockIronEnum.IronType blockiron$enumtype : BlockIronEnum.IronType.values()) 
		{
			items.add(new ItemStack(this, 1, blockiron$enumtype.getMetadata()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(TYPE, BlockIronEnum.IronType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((BlockIronEnum.IronType) state.getValue(TYPE)).getMetadata();
	}

	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}

	public static enum IronType implements IStringSerializable 
	{
		iron(0, "iron");

		private static final BlockIronEnum.IronType[] META_LOOKUP = new BlockIronEnum.IronType[values().length];
		private final int metadata;
		private final String name;
		private String unlocalizedName;

		private IronType(int meta, String name) 
		{
			this.metadata = meta;
			this.name = name;
			this.unlocalizedName = name;
		}

		public int getMetadata() 
		{
			return this.metadata;
		}

		public String toString() 
		{
			return this.name;
		}
		
		public static BlockIronEnum.IronType byMetadata(int meta) 
		{
			if (meta < 0 || meta >= META_LOOKUP.length) 
			{
				meta = 0;
			}
			return META_LOOKUP[meta];
		}

		public String getName() 
		{
			return this.name;
		}

		public String getUnlocalizedName() 
		{
			return this.unlocalizedName;
		}

		static {
			for (BlockIronEnum.IronType blockiron$enumtype : values()) 
			{
				META_LOOKUP[blockiron$enumtype.getMetadata()] = blockiron$enumtype;
			}
		}
	}

}