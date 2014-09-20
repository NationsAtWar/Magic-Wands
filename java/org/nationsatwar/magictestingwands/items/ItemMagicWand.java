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
	
	public ItemMagicWand(String name, String newCommand)
	{
		setUnlocalizedName(MagicWands.MODID + "_" + name);
		setTextureName(MagicWands.MODID + ":" + "magicWand");
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMisc);
		
		command = newCommand;
	}
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par2World.playSoundAtEntity(par3EntityPlayer, "random.orb", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if(!par3EntityPlayer.worldObj.isRemote)
		{
			if(isCommand)
			{
				MinecraftServer.getServer().getCommandManager().executeCommand(par3EntityPlayer, command);
			}
			else
			{
				// not that it currently can't be a command, but may want to have it do messages, too.
				ChatComponentText msg = new ChatComponentText(command);
				par3EntityPlayer.addChatComponentMessage(msg);
			}
		}
		return par1ItemStack;
	}
}
