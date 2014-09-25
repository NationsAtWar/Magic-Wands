package org.nationsatwar.magictestingwands;

import java.util.Set;

import net.minecraftforge.common.config.Configuration;

import org.nationsatwar.magictestingwands.items.ModItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = MagicWands.MODID, name = MagicWands.NAME, version = MagicWands.VERSION)
public class MagicWands 
{
    public static final String MODID = "magictestingwands";
    public static final String NAME = "Magic Testing Wands";
    public static final String VERSION = "1.7.10-0.1";
    public static Configuration config;
    
    public static String wandCategory = "wands";
    public String wandCategoryComment = "Add wands here, in the format 'B:\"[name]\"=[boolean]'. One wand per line. Name can include spaces. Set \nboolean to 'true' to generate and register the wand when starting the server, or to 'false' not to \ngenerate and register the wand. Item unlocalised name will be magictestingwands_[name]";
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		config.addCustomCategoryComment(wandCategory, wandCategoryComment);
		boolean testString = config.get(wandCategory, "Example Wand", true).getBoolean();
		config.save();
		ModItems.init();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) 
	{
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event) 
	{
		
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
	}
}
// can get list of categories in config
// one category per wand? Category as name, command and stuff beneath?