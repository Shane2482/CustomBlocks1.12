package shane.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import shane.mod.library.Reference;
import shane.mod.objects.blocks.blocksbase.BlockBaseBrick;
import shane.mod.objects.blocks.blocksbase.BlockBaseMetal;
import shane.mod.objects.blocks.blockscustom.BlockLampsC;
import shane.mod.objects.blocks.blockscustom.BlockLampsT;
import shane.mod.objects.blocks.blockscustom.BlockTrash;
import shane.mod.objects.blocks.blocksrotbase.BlockBrickFaceRot;
import shane.mod.objects.blocks.blocksrotbase.BlockBrickFullRot;
import shane.mod.objects.blocks.blocksrotbase.BlockFaceRotBase;
import shane.mod.objects.blocks.blocksrotbase.BlockFullRotBase;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class BlocksInit 
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
	
	//Brick Blocks
	//Yellow
	public static final Block block_yellow_brick = new BlockBaseBrick("block_yellow_brick");
	public static final Block block_yellow_brick_small = new BlockBaseBrick("block_yellow_brick_small");
	public static final Block block_yellow_brick_large_tile = new BlockBaseBrick("block_yellow_brick_large_tile");
	public static final Block block_yellow_brick_small_tile = new BlockBaseBrick("block_yellow_brick_small_tile");
	public static final Block block_yellow_brick_disarray = new BlockBaseBrick("block_yellow_brick_disarray");
	public static final Block block_yellow_brick_dent = new BlockBaseBrick("block_yellow_brick_dent");	
	//Yellow Damaged
	// TODO Add rest of damaged blocks
	public static final Block block_yellow_brick_damaged = new BlockBaseBrick("block_yellow_brick_damaged");	
	//Yellow Special
	// TODO Add rest of special blocks
	public static final Block block_yellow_brick_layer = new BlockBrickFullRot("block_yellow_brick_layer");
	public static final Block block_yellow_brick_corner = new BlockBrickFaceRot("block_yellow_brick_corner");
		
	
	//Cream
	public static final Block block_cream_brick = new BlockBaseBrick("block_cream_brick");
	public static final Block block_cream_brick_small = new BlockBaseBrick("block_cream_brick_small");
	public static final Block block_cream_brick_large_tile = new BlockBaseBrick("block_cream_brick_large_tile");
	public static final Block block_cream_brick_small_tile = new BlockBaseBrick("block_cream_brick_small_tile");
	public static final Block block_cream_brick_disarray = new BlockBaseBrick("block_cream_brick_disarray");
	public static final Block block_cream_brick_dent = new BlockBaseBrick("block_cream_brick_dent");
	public static final Block block_cream_brick_layer = new BlockBrickFullRot("block_cream_brick_layer");
	//Cream Damaged
	// TODO Add damaged blocks
	//Cream Corners
	public static final Block block_cream_brick_corner = new BlockBrickFaceRot("block_cream_brick_corner");
	public static final Block block_cream_brick_corner_small = new BlockBrickFaceRot("block_cream_brick_corner_small");
	public static final Block block_cream_brick_corner_large_tile = new BlockBrickFaceRot("block_cream_brick_corner_large_tile");
	public static final Block block_cream_brick_corner_small_tile = new BlockBrickFaceRot("block_cream_brick_corner_small_tile");
	public static final Block block_cream_brick_corner_disarray = new BlockBrickFaceRot("block_cream_brick_corner_disarray");
	public static final Block block_cream_brick_corner_dent = new BlockBrickFaceRot("block_cream_brick_corner_dent");
	public static final Block block_cream_brick_corner_layer = new BlockBrickFaceRot("block_cream_brick_corner_layer");
	//Cream Special
	public static final Block block_cream_brick_pillar = new BlockBaseBrick("block_cream_brick_pillar");
	
	
	
	//Red
	public static final Block block_red_brick = new BlockBaseBrick("block_red_brick");
	public static final Block block_red_brick_small = new BlockBaseBrick("block_red_brick_small");
	public static final Block block_red_brick_large_tile = new BlockBaseBrick("block_red_brick_large_tile");
	public static final Block block_red_brick_small_tile = new BlockBaseBrick("block_red_brick_small_tile");
	public static final Block block_red_brick_disarray = new BlockBaseBrick("block_red_brick_disarray");
	public static final Block block_red_brick_dent = new BlockBaseBrick("block_red_brick_dent");
	//Red Damaged
	// TODO Add damaged blocks
	//Red Special
	// TODO Add rest of special blocks
	public static final Block block_red_brick_corner = new BlockBrickFaceRot("block_red_brick_corner");
	public static final Block block_red_brick_layer = new BlockBrickFullRot("block_red_brick_layer");
//	
//	//Custom Blocks
//	
//	public static final Block block_factory_lightn = new BlockLampsT("block_factory_light");
//	public static final Block block_caged_light = new BlockLampsC("block_caged_light");
//	public static final Block block_trash = new BlockTrash("block_trash");
	
	
	//desine testing
	public static final Block block_blue_metal_dent = new BlockBaseMetal("block_blue_metal_dent");
	public static final Block block_blue_metal_dent_rivets = new BlockBaseMetal("block_blue_metal_dent_rivets");
	public static final Block block_blue_metal_diamond = new BlockBaseMetal("block_blue_metal_diamond");
	public static final Block block_blue_metal_large_plate = new BlockBaseMetal("block_blue_metal_large_plate");
	public static final Block block_blue_metal_mesh = new BlockBaseMetal("block_blue_metal_mesh");
	public static final Block block_blue_metal_plating = new BlockBaseMetal("block_blue_metal_plating");
	public static final Block block_blue_metal_sheet = new BlockBaseMetal("block_blue_metal_sheet");
	
}
