package shane.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import shane.mod.library.Reference;
import shane.mod.objects.blocks.blocksbase.BlockBaseBrick;
import shane.mod.objects.blocks.blocksrotbase.BlockBrickFaceRot;
import shane.mod.objects.blocks.blocksrotbase.BlockBrickFullRot;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class BlocksBrickInit 
{			
	public static List<Block> BLOCKS = new ArrayList<Block>();
	
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

	
}
