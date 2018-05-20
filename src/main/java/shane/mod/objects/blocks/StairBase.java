package shane.mod.objects.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class StairBase extends BlockStairs 
{
	public StairBase(String name, IBlockState modelState, Material material, float hardness, float resistance, String tool, int level, CreativeTabs tab, SoundType sound, float value)
	{
		super(modelState);
		
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
