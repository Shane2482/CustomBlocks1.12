package shane.mod.objects.blocks.blockscustommodels;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import shane.mod.CustomBlocks;
import shane.mod.init.BlocksCustModelInit;
import shane.mod.library.IHasModel;
import shane.mod.objects.items.ItemInit;

public class BlockTrash extends Block implements IHasModel
{
	protected static final AxisAlignedBB BOUNDINGBOX = new AxisAlignedBB(0D, 0.001D, 0D, 1D, 0.002D, 1.0D);

	
	public BlockTrash(String name) 
	{
		super(Material.ROCK);		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setSoundType(SoundType.GROUND);
		 this.setLightOpacity(0);
	
		BlocksCustModelInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}

	@Override
	public void registerModels() 
	{
		CustomBlocks.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return BOUNDINGBOX;
	}

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
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
	
	 
	public boolean isTopSolid(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) 
	{
		return true;
	}
	
	
	
}


