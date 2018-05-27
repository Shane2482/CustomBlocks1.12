package shane.mod.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shane.mod.library.ItemBlockEnum;
import shane.mod.library.Reference;
import shane.mod.objects.blocks.blocksbase.BlockBase;
import shane.mod.objects.blocks.blocksbase.BlockFaceRotBase;
import shane.mod.objects.blocks.blocksbase.BlockFullRotBase;
import shane.mod.objects.blocks.blocksbase.FenceBase;
import shane.mod.objects.blocks.blocksbase.GateBase;
import shane.mod.objects.blocks.blocksbase.StairBase;
import shane.mod.objects.blocks.blocksbase.WallBase;
import shane.mod.objects.blocks.blocksenum.BlockTestEnum;
import shane.mod.objects.blocks.blocksenum.BlockTestEnum.EnumType;
import shane.mod.objects.blocks.blocksslab.SlabDoubleBase;
import shane.mod.objects.blocks.blocksslab.SlabHalfBase;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)

public class BlockObjectInit 
{
//	static Block stair_test;
//
//	static Block fence_test;
//
//	static Block gate_test;
//
//	static Block wall_test;
//
//	public static SlabHalfBase slab_half_test;
//	public static SlabDoubleBase slab_double_test;
//
//	public static void init() 
//	{
//		// Stairs: name, default state, material, hardness, resistance, harvest level(tool, level), Creative Tab, Sound, Light
//		stair_test = new StairBase("stair_test", stair_test.getDefaultState(), Material.IRON, 5f, 30f, "pickaxe", 2, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
//
//		// Fencce, name, color, material, hardness, resistance, harvest level(tool, level), Creative Tab, Sound, Light
//		fence_test = new FenceBase("fence_test", MapColor.IRON, Material.IRON, 5f, 30f, "pickaxe", 2, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
//
//		// Gate, name, color, material, hardness, resistance, harvest level(tool, level), Creative Tab, Sound, Light
//		gate_test = new GateBase("gate_test", MapColor.IRON, Material.IRON, 5f, 30f, "pickaxe", 2, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
//
//		slab_double_test = new SlabDoubleBase("slab_double_test", Material.ROCK);
//		slab_half_test = new SlabHalfBase("slab_half_test", Material.ROCK);
//
//		wall_test = new WallBase("wall_test", Material.ROCK);
//	}
//
//	@SubscribeEvent
//	public static void registerBlocks(RegistryEvent.Register<Block> event) 
//	{
//		event.getRegistry().registerAll(stair_test);
//
//		event.getRegistry().registerAll(fence_test);
//
//		event.getRegistry().registerAll(gate_test);
//
//		event.getRegistry().registerAll(slab_half_test);
//		event.getRegistry().registerAll(slab_double_test);
//
//		event.getRegistry().registerAll(wall_test);
//	}
//
//	@SubscribeEvent
//	public static void registerItemBlocks(RegistryEvent.Register<Item> event) 
//	{
//		event.getRegistry().registerAll(new ItemBlock(stair_test).setRegistryName(stair_test.getRegistryName()));
//
//		event.getRegistry().registerAll(new ItemBlock(fence_test).setRegistryName(fence_test.getRegistryName()));
//
//		event.getRegistry().registerAll(new ItemBlock(gate_test).setRegistryName(gate_test.getRegistryName()));
//
//		event.getRegistry().registerAll(new ItemSlab(slab_half_test, slab_half_test, slab_double_test).setRegistryName(slab_half_test.getRegistryName()));
//
//		event.getRegistry().registerAll(new ItemBlock(wall_test).setRegistryName(wall_test.getRegistryName()));
//	}
//
//	@SubscribeEvent
//	public static void registerRenders(ModelRegistryEvent event) 
//	{
//		registerRender(Item.getItemFromBlock(stair_test));
//
//		registerRender(Item.getItemFromBlock(fence_test));
//
//		registerRender(Item.getItemFromBlock(gate_test));
//
//		registerRender(Item.getItemFromBlock(slab_half_test));
//
//		registerRender(Item.getItemFromBlock(wall_test));
//	}
//
//	public static void registerRender(Item item) 
//	{
//		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
//	}
}