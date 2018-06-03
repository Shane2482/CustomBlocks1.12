package shane.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import shane.mod.library.Reference;
import shane.mod.objects.blocks.blocksbase.BlockBaseMetal;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class BlockMetalInit 
{			
	public static List<Block> BLOCKS = new ArrayList<Block>();
	
	//Metal Blocks
	//Steel
//	public static final Block block_steel = new BlockBaseMetal("block_steel");
//	public static final Block block_steel_plating = new BlockBaseMetal("block_steel_plating");
//	public static final Block block_steel_dent = new BlockBaseMetal("block_steel_dent");
//	public static final Block block_steel_dent_rivets = new BlockBaseMetal("block_steel_dent_rivets");
//	//Steel Rust
//	public static final Block block_steel_r = new BlockBaseMetal("block_steel_r");
//	public static final Block block_steel_r_plating = new BlockBaseMetal("block_steel_r_plating");
//	public static final Block block_steel_r_dent = new BlockBaseMetal("block_steel_r_dent");
//	public static final Block block_steel_r_dent_rivets = new BlockBaseMetal("block_steel_r_dent_rivets");
//	//Steel Paint
//	public static final Block block_steel_plating_blue = new BlockBaseMetal("block_steel_plating_blue");
		
	//desine testing
	public static final Block block_orange_metal_dent_rivets_ct = new BlockBaseMetal("block_orange_metal_dent_rivets_ct");
	public static final Block block_orange_metal_dent_rivets = new BlockBaseMetal("block_orange_metal_dent_rivets");
	public static final Block block_orange_metal_dent_ct = new BlockBaseMetal("block_orange_metal_dent_ct");
	public static final Block block_orange_metal_dent = new BlockBaseMetal("block_orange_metal_dent");
//	public static final Block block_blue_metal_dent = new BlockBaseMetal("block_blue_metal_dent");
//	public static final Block block_blue_metal_dent_rivets = new BlockBaseMetal("block_blue_metal_dent_rivets");
//	public static final Block block_blue_metal_diamond = new BlockBaseMetal("block_blue_metal_diamond");
//	public static final Block block_blue_metal_large_plate = new BlockBaseMetal("block_blue_metal_large_plate");
//	public static final Block block_blue_metal_mesh = new BlockBaseMetal("block_blue_metal_mesh");
//	public static final Block block_blue_metal_plating = new BlockBaseMetal("block_blue_metal_plating");
//	public static final Block block_blue_metal_sheet = new BlockBaseMetal("block_blue_metal_sheet");
	
}
