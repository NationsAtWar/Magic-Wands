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
	private String command = "";
	private boolean isCommand = true;
	
	public ItemMagicWand(String name)
	{
		setUnlocalizedName(MagicWands.MODID + "_" + name);
		setTextureName(MagicWands.MODID + ":" + "magicWand");
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMisc);
	}
}
