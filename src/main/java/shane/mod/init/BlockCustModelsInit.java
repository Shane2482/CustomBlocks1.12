package shane.mod.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shane.mod.library.Reference;
import shane.mod.objects.blocks.blocksbase.BlockFullRotBase;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)

public class BlockCustModelsInit 
{
//	static BlockFaceRotBase console;
	static BlockFullRotBase i_beam_base;
     static BlockFullRotBase i_beam;
	
	

	public static void init() 
	{
		// Blocks: name, material, hardness, resistance, harvest level(tool, level), Creative Tab, Sound, Light
		//console = new BlockConsole("console");
		i_beam = new BlockFullRotBase("i_beam", Material.IRON);
		i_beam_base = new BlockFullRotBase("i_beam_base", Material.IRON);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{
		//event.getRegistry().registerAll(console);
		event.getRegistry().registerAll(i_beam);
		event.getRegistry().registerAll(i_beam_base);
	}

	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) 
	{
		//event.getRegistry().registerAll(new ItemBlock(console).setRegistryName(console.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(i_beam).setRegistryName(i_beam.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(i_beam_base).setRegistryName(i_beam_base.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) 
	{
		//registerRender(Item.getItemFromBlock(console));
		registerRender(Item.getItemFromBlock(i_beam));
		registerRender(Item.getItemFromBlock(i_beam_base));
	}

	public static void registerRender(Item item) 
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}