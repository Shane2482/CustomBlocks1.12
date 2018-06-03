package shane.mod.objects.blocks.blocksrotbase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBrickFaceRot extends BlockFaceRotBase
{
	public BlockBrickFaceRot(String name) {
		super(name, Material.ROCK);		
		setHardness(1.5f);
		setResistance(30f);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setSoundType(SoundType.STONE);
		
	}
	
}
