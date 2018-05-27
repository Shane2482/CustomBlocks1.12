package shane.mod.init;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shane.mod.library.ItemBlockEnum;
import shane.mod.library.Reference;
import shane.mod.objects.blocks.blocksbase.BlockBase;
import shane.mod.objects.blocks.blocksenum.BlockSteelEnum;
import shane.mod.objects.blocks.blocksenum.BlockSteelEnum.SteelType;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)

public class BlockInit 
{
	//static Block block_iron;
	static Block block_steel;
	//static Block block_rust_steel;
	
	static Block block_test;
	static Block block_test_enum;

	public static void init() 
	{
		// Blocks: name, material, hardness, resistance, harvest level(tool, level), Creative Tab, Sound, Light
		//block_iron = new BlockIronEnum("block_iron", Material.IRON, 5f, 30f, "pickaxe", 1, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
		block_steel = new BlockSteelEnum("block_steel", Material.IRON, 5f, 30f, "pickaxe", 1, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
		//block_rust_steel = new BlockRustSteelEnum("block_rust_steel", Material.IRON, 5f, 30f, "pickaxe", 1, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
				
		block_test = new BlockBase("block_test", Material.IRON, 5f, 30f, "pickaxe", 1, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
		//block_test_enum = new BlockTestEnum("block_test_enum", Material.ROCK, CreativeTabs.MISC);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{
		//event.getRegistry().registerAll(block_iron);
		event.getRegistry().registerAll(block_steel);
		//event.getRegistry().registerAll(block_rust_steel);
		
		event.getRegistry().registerAll(block_test);		
		//event.getRegistry().registerAll(block_test_enum);
	}

	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) 
	{
		//event.getRegistry().registerAll(new ItemBlockEnum(block_iron).setRegistryName(block_iron.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlockEnum(block_steel).setRegistryName(block_steel.getRegistryName()));
		//event.getRegistry().registerAll(new ItemBlockEnum(block_rust_steel).setRegistryName(block_rust_steel.getRegistryName()));
	
		event.getRegistry().registerAll(new ItemBlock(block_test).setRegistryName(block_test.getRegistryName()));
		//event.getRegistry().registerAll(new ItemBlockEnum(block_test_enum).setRegistryName(block_test_enum.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) 
	{
		
		
		
		registerRender(ItemBlockEnum.getItemFromBlock(block_steel));
		for (int i = 0; i < SteelType.values().length; i++) {
			registerRender(block_steel, i, SteelType.values()[i].getName());
		}
	}

		

	
	
	private static void registerRender(Block block, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
				new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, fileName), "inventory"));
		
	}

	

	public static void registerRender(Item item) 
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
		
}