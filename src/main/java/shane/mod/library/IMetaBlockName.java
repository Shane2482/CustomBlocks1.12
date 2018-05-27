package shane.mod.library;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

public interface IMetaBlockName 
{
	String getSpecialName(ItemStack stack);

	int getMetaFromState(IBlockState state);
}

