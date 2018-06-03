package shane.mod.objects.blocks.blocksrotbase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import shane.mod.CustomBlocks;
import shane.mod.init.BlocksBrickInit;
import shane.mod.library.IHasModel;
import shane.mod.objects.items.ItemInit;

public class BlockBrickFullRot extends BlockMetalFullRotBase 
{

	public BlockBrickFullRot(String name) 
	{
		super(name, Material.ROCK);		
		setHardness(1.5f);
		setResistance(30f);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setSoundType(SoundType.STONE);
		
	}

	
}
