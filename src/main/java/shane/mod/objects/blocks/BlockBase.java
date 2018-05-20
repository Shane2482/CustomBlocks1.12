package shane.mod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBase extends Block
{
	public BlockBase(String name, Material material, float hardness, float resistance, String tool, int level, CreativeTabs tab, SoundType sound, float value) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, level);
		setCreativeTab(tab);
		setSoundType(sound);
		setLightLevel(value);		
	}
}


