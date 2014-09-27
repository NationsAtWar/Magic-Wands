package org.nationsatwar.magictestingwands.items;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import org.nationsatwar.magictestingwands.MagicWands;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemMagicWand extends Item 
{	
	private String stackName = "";
	
	public ItemMagicWand(String name)
	{
		setUnlocalizedName(MagicWands.MODID + "_" + name.replaceAll(" ", "_"));
		setTextureName(MagicWands.MODID + ":" + "magicWand");
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMisc);
		
		setMaxStackSize(1);
		stackName = name;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack p_77653_1_) 
	{
		return stackName;
	}
}
