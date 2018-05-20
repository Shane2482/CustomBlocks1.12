package shane.mod.objects.items;

import net.minecraft.item.Item;

public class ItemBase extends Item{
	public ItemBase(String name) 
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
	}

	
}