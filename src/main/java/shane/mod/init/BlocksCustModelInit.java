package shane.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import shane.mod.library.Reference;
import shane.mod.objects.blocks.blockscustommodels.BlockLampsC;
import shane.mod.objects.blocks.blockscustommodels.BlockLampsT;
import shane.mod.objects.blocks.blockscustommodels.BlockTrash;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class BlocksCustModelInit 
{		
	public static List<Block> BLOCKS = new ArrayList<Block>();
	
	//Custom Blocks
	
	public static final Block block_factory_lightn = new BlockLampsT("block_factory_light");
	public static final Block block_caged_light = new BlockLampsC("block_caged_light");
	public static final Block block_trash = new BlockTrash("block_trash");
	
}
