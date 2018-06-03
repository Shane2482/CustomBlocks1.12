package shane.mod.objects.blocks.blocksbase;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import shane.mod.CustomBlocks;
import shane.mod.init.BlocksInit;
import shane.mod.library.IHasModel;
import shane.mod.objects.items.ItemInit;

public class BlockBaseBrick extends Block implements IHasModel
{
	
	public BlockBaseBrick(String name) 
	{
		super(Material.ROCK);		
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(1.5f);
		setResistance(30f);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setSoundType(SoundType.STONE);
		
        
		BlocksInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}

	@Override
	public void registerModels() {
		CustomBlocks.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	

	
}


