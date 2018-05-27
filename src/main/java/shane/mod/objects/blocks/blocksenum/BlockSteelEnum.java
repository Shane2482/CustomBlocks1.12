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
import shane.mod.objects.blocks.blocksenum.BlockSteelEnum.SteelType;

public class BlockSteelEnum extends Block implements IMetaBlockName 
{
	public static final PropertyEnum<BlockSteelEnum.SteelType> TYPE = PropertyEnum.<BlockSteelEnum.SteelType>create("type", BlockSteelEnum.SteelType.class);

	public BlockSteelEnum(String name, Material material, float hardness, float resistance, String tool, int level, CreativeTabs tab, SoundType sound, float value) 
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
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockSteelEnum.SteelType.steel));

	}

	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return SteelType.values()[stack.getItemDamage()].getName();
	}

	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((BlockSteelEnum.SteelType) state.getValue(TYPE)).getMetadata();
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for (BlockSteelEnum.SteelType blocksteel$enumtype : BlockSteelEnum.SteelType.values()) 
		{
			items.add(new ItemStack(this, 1, blocksteel$enumtype.getMetadata()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(TYPE, BlockSteelEnum.SteelType.byMetadata(meta));
	}

	
	
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((BlockSteelEnum.SteelType) state.getValue(TYPE)).getMetadata();
	}
	
	

	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}

	public static enum SteelType implements IStringSerializable 
	{
		steel(0, "steel"), 
		steel_plating(1, "steel_plating"), 
		steel_dent(2,"steel_dent"),
		steel_dent_rivets(3, "steel_dent_rivets");

		private static final BlockSteelEnum.SteelType[] META_LOOKUP = new BlockSteelEnum.SteelType[values().length];
		private final int metadata;
		private final String name;
		private String unlocalizedName;

		private SteelType(int meta, String name) 
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
		
		public static BlockSteelEnum.SteelType byMetadata(int meta) 
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

		static 
		{
			for (BlockSteelEnum.SteelType blocksteel$enumtype : values()) 
			{
				META_LOOKUP[blocksteel$enumtype.getMetadata()] = blocksteel$enumtype;
			}
		}
	}
}