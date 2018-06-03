package shane.mod.objects.blocks.blocksbase;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shane.mod.CustomBlocks;
import shane.mod.init.BlocksInit;
import shane.mod.library.IHasModel;
import shane.mod.library.Reference;
import shane.mod.objects.items.ItemInit;


public class BlockBaseMetal extends Block implements IHasModel
{
	
	public BlockBaseMetal(String name) 
	{
		super(Material.IRON);		
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(5f);
		setResistance(30f);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setSoundType(SoundType.METAL);
		setLightLevel(0f);
        
		BlocksInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}

	@Override
	public void registerModels() {
		CustomBlocks.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	

	
}


