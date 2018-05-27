package shane.mod.objects.blocks.blocksbase;

import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class FenceBase extends BlockFence 
{
	public FenceBase(String name, MapColor color, Material material, float hardness, float resistance, String tool, int level, CreativeTabs tab, SoundType sound, float value) {
		super(material, color);
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, level);
		setCreativeTab(tab);
		setSoundType(sound);
		setLightLevel(value);
		this.useNeighborBrightness = true;
	}


	
}
