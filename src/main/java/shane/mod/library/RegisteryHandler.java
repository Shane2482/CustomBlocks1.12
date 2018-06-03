package shane.mod.library;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shane.mod.init.BlockMetalInit;
import shane.mod.init.BlocksBrickInit;
import shane.mod.init.BlocksCustModelInit;
import shane.mod.objects.items.ItemInit;
@EventBusSubscriber
public class RegisteryHandler 
{
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(BlocksBrickInit.BLOCKS.toArray(new Block[0]));
		event.getRegistry().registerAll(BlockMetalInit.BLOCKS.toArray(new Block[0]));
		event.getRegistry().registerAll(BlocksCustModelInit.BLOCKS.toArray(new Block[0]));
	}
		
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ItemInit.ITEMS)
	{
		if(item instanceof IHasModel)
		{
			((IHasModel)item).registerModels();
		}
	}
				
		for(Block block : BlocksBrickInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
		for(Block block : BlockMetalInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
		for(Block block : BlocksCustModelInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	
	
	
	
}