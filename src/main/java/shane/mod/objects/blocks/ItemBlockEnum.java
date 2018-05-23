package shane.mod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockEnum extends ItemBlock
{
	public ItemBlockEnum(Block block) 
	{
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damage) 
	{
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) 
	{
		return super.getUnlocalizedName() + "." + ((IMetaBlockName) block).getSpecialName(stack);
	}
}
