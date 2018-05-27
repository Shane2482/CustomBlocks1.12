package shane.mod.objects.blocks.blocksenum;

import java.util.Random;

import net.minecraft.block.Block;

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

public class BlockTestEnum extends Block implements IMetaBlockName
{
    public static final PropertyEnum<BlockTestEnum.EnumType> TYPE = PropertyEnum.<BlockTestEnum.EnumType>create("type", BlockTestEnum.EnumType.class);

    public BlockTestEnum(String name, Material material, CreativeTabs tab)
    {
        super(material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockTestEnum.EnumType.texture0));
        setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
    }

    
    
    @Override
	public String getSpecialName(ItemStack stack) {
		return EnumType.values()[stack.getItemDamage()].getName();
	}
    
    
    
    
   @Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockTestEnum.EnumType)state.getValue(TYPE)).getMetadata();
    }

   @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (BlockTestEnum.EnumType blocksandstone$enumtype : BlockTestEnum.EnumType.values())
        {
            items.add(new ItemStack(this, 1, blocksandstone$enumtype.getMetadata()));
        }
    }

    
   @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, BlockTestEnum.EnumType.byMetadata(meta));
    }

   @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockTestEnum.EnumType)state.getValue(TYPE)).getMetadata();
    }

   @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE});
    }

    public static enum EnumType implements IStringSerializable
    {
        texture0(0, "texture0"),
        texture1(1, "texture1"),
        texture2(2, "texture2"),
        texture3(3, "texture3"),
    	texture4(4, "texture4"),
    	texture5(5, "texture5"),
    	texture6(6, "texture6"),
    	texture7(7, "texture7"),
    	texture8(8, "texture8"),
    	texture9(9, "texture9"),
    	texture10(10, "texture10"),
    	texture11(11, "texture11"),
    	texture12(12, "texture12");

        private static final BlockTestEnum.EnumType[] META_LOOKUP = new BlockTestEnum.EnumType[values().length];
        private final int metadata;
        private final String name;
		private String unlocalizedName;
        

        private EnumType(int meta, String name)
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

        /**
         * Returns the matching EnumType for the given metadata.
         */
        public static BlockTestEnum.EnumType byMetadata(int meta)
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
            for (BlockTestEnum.EnumType blocksandstone$enumtype : values())
            {
                META_LOOKUP[blocksandstone$enumtype.getMetadata()] = blocksandstone$enumtype;
            }
        }
    }

	
}