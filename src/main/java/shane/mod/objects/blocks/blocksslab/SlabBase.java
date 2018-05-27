package shane.mod.objects.blocks.blocksslab;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public abstract class SlabBase extends BlockSlab {
	 
    public SlabBase(String name, Material material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.MISC);
       
        this.useNeighborBrightness = true;
        
        IBlockState state = this.blockState.getBaseState();
		
		if(!this.isDouble())
		{
			state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}
		
		setDefaultState(state);
		this.useNeighborBrightness = true;
        
       
    }
 
   
    @Override
    public String getUnlocalizedName(int meta) {
        return this.getUnlocalizedName();
    }
 
   
    @Override
    public IProperty<?> getVariantProperty() {
        return HALF;
    }
 
   
    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return EnumBlockHalf.BOTTOM;
    }
 
   
    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }
 
   
    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (!this.isDouble())
            return this.getDefaultState().withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
        return this.getDefaultState();
    }
 
   
    @Override
    public int getMetaFromState(IBlockState state) {
        if (!this.isDouble())
            return 0;
        return ((EnumBlockHalf) state.getValue(HALF)).ordinal() + 1;
    }
 
   
//  @Override
//  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
//       return Item.getItemFromBlock(BlockInit.slab_half_test);
//    }
 
   
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { HALF});
    }
 
 
 
}
