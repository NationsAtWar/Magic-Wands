package org.nationsatwar.magictestingwands.items;

import java.util.Collection;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Property;

import org.nationsatwar.magictestingwands.MagicWands;

public final class ModItems 
{
	public static Item magicWand;
	
	public static void init()
	{
		// get names, commands from config file
		// pass name, command from the configuration file to constructor for as many entries as are present
		//for(int i = 0; i < MagicWands.categories.length(); i++)
		//{
		//	magicWand = new ItemMagicWand("MagicWand" + Integer.toString(i));
		//}
		ConfigCategory wandCategory = MagicWands.config.getCategory("wands");
		
		Map<String, Property> val = wandCategory.getValues();
		
		for (String key : val.keySet()) 
		{
		    magicWand = new ItemMagicWand(key,val.get(key).getString());
		}
	}
}
