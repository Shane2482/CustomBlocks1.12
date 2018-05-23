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
import shane.mod.library.Reference;
import shane.mod.objects.blocks.BlockBase;
import shane.mod.objects.blocks.BlockTestEnum;
import shane.mod.objects.blocks.BlockTestEnum.EnumType;
import shane.mod.objects.blocks.FenceBase;
import shane.mod.objects.blocks.GateBase;
import shane.mod.objects.blocks.ItemBlockEnum;
import shane.mod.objects.blocks.StairBase;
import shane.mod.objects.blocks.WallBase;
import shane.mod.objects.blocks.slabs.SlabDoubleBase;
import shane.mod.objects.blocks.slabs.SlabHalfBase;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)

public class BlockInit  
{  
    static Block block_test;
    static Block brick_damaged;
    static Block brick_frosted;
    
    
           
    static Block stair_test;
   
    static Block fence_test;
   
    static Block gate_test;
   
    static Block wall_test;
   
    static Block block_test_enum;
   
    public static SlabHalfBase slab_half_test;
    public static SlabDoubleBase slab_double_test;
   
    public static void init()
    {
        //Blocks: name, material, hardness, resistance, harvest level(tool, level), Creative Tab, Sound, Light
       block_test = new BlockBase("block_test", Material.ROCK, 5f, 30f, "pickaxe", 2, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
       brick_damaged = new BlockBase("brick_damaged", Material.ROCK, 5f, 30f, "pickaxe", 2, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
       brick_frosted = new BlockBase("brick_frosted", Material.ROCK, 5f, 30f, "pickaxe", 2, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
       
        //Stairs: name, default state, material, hardness, resistance, harvest level(tool, level), Creative Tab, Sound, Light
        stair_test = new StairBase("stair_test", block_test.getDefaultState(), Material.IRON, 5f, 30f, "pickaxe", 2, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
 
        //Fencce, name, color, material, hardness, resistance, harvest level(tool, level), Creative Tab, Sound, Light
        fence_test = new FenceBase("fence_test", MapColor.IRON, Material.IRON, 5f, 30f, "pickaxe", 2, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
 
        //Gate, name, color, material, hardness, resistance, harvest level(tool, level), Creative Tab, Sound, Light
        gate_test = new GateBase("gate_test", MapColor.IRON, Material.IRON, 5f, 30f, "pickaxe", 2, CreativeTabs.DECORATIONS, SoundType.METAL, 0f);
 
        slab_double_test = new SlabDoubleBase("slab_double_test", Material.ROCK);
        slab_half_test = new SlabHalfBase("slab_half_test", Material.ROCK);
               
        wall_test = new WallBase("wall_test", Material.ROCK);
       
        block_test_enum = new BlockTestEnum("block_test_enum", Material.ROCK, CreativeTabs.MISC);
    }
    
      
    
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
 
       event.getRegistry().registerAll(block_test);
       event.getRegistry().registerAll(brick_damaged);
       event.getRegistry().registerAll(brick_frosted);
   
        event.getRegistry().registerAll(stair_test);
       
        event.getRegistry().registerAll(fence_test);
       
        event.getRegistry().registerAll(gate_test);
       
        event.getRegistry().registerAll(slab_half_test);
        event.getRegistry().registerAll(slab_double_test);
       
        event.getRegistry().registerAll(wall_test);
       
        event.getRegistry().registerAll(block_test_enum);
    }
 
    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(new ItemBlock(block_test).setRegistryName(block_test.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(brick_damaged).setRegistryName(brick_damaged.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(brick_frosted).setRegistryName(brick_frosted.getRegistryName()));
               
        event.getRegistry().registerAll(new ItemBlock(stair_test).setRegistryName(stair_test.getRegistryName()));
       
        event.getRegistry().registerAll(new ItemBlock(fence_test).setRegistryName(fence_test.getRegistryName()));
       
        event.getRegistry().registerAll(new ItemBlock(gate_test).setRegistryName(gate_test.getRegistryName()));
       
        event.getRegistry().registerAll(new ItemSlab(slab_half_test, slab_half_test, slab_double_test)
                .setRegistryName(slab_half_test.getRegistryName()));
       
        event.getRegistry().registerAll(new ItemBlock(wall_test).setRegistryName(wall_test.getRegistryName()));
        
        
   event.getRegistry().registerAll(new ItemBlockEnum(block_test_enum).setRegistryName(block_test_enum.getRegistryName()));
       

    }  
 
 
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event)
    {
        registerRender(Item.getItemFromBlock(block_test));
        registerRender(Item.getItemFromBlock(brick_damaged));
        registerRender(Item.getItemFromBlock(brick_frosted));
               
        registerRender(Item.getItemFromBlock(stair_test));
       
        registerRender(Item.getItemFromBlock(fence_test));
       
        registerRender(Item.getItemFromBlock(gate_test));
       
        registerRender(Item.getItemFromBlock(slab_half_test));
       
        registerRender(Item.getItemFromBlock(wall_test));
       
        registerRender(ItemBlockEnum.getItemFromBlock(block_test_enum));
        for (int i = 0; i < EnumType.values().length; i++) {
			registerRender(block_test_enum, i, "block_test_enum_" + EnumType.values()[i].getName());
		}
    }
   
    
    
    
    
    
    
    
    
    
    
    
    public static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
    } 

    
    
    public static void registerRender(Block block, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
				new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, fileName), "inventory"));
    
    }
	

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}