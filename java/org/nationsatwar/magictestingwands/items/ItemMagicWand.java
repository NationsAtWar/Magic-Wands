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
		if(command.charAt(0) == "/".toCharArray()[0])
			isCommand = true;
		else
			isCommand = false;
	}
	
	//public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	//{
	//	if(executeBoundCommand(par3EntityPlayer, par2World, par3EntityPlayer.serverPosX, par3EntityPlayer.serverPosY, par3EntityPlayer.serverPosZ))
	//	{
	//		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "random.orb", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	//		return par1ItemStack;
	//	}
	//	else
	//		return par1ItemStack;
	//}
	
	public boolean onItemUse(ItemStack tool, EntityPlayer player, World world, int x, int y, int z, int par7, float xFloat, float yFloat, float zFloat)
	{
		if(executeBoundCommand(player, world, x, y, z))
		{
			player.worldObj.playSoundAtEntity(player, "random.orb", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			return true;
		}
		else
			return false;
	}
	
	public boolean executeBoundCommand(EntityPlayer player, World world, int x, int y, int z)
	{
		if(!player.worldObj.isRemote)
		{
			// replace special strings with data
			String fixedCommand = command;
			fixedCommand = fixedCommand.replaceAll("%x", String.valueOf(x));
			fixedCommand = fixedCommand.replaceAll("%y", String.valueOf(y));
			fixedCommand = fixedCommand.replaceAll("%z", String.valueOf(z));
			if(isCommand)
			{
				MinecraftServer.getServer().getCommandManager().executeCommand(player, fixedCommand);
				return true;
			}
			else
			{
				// not that it currently can't be a command, but may want to have it do messages, too.
				ChatComponentText msg = new ChatComponentText(fixedCommand);
				player.addChatComponentMessage(msg);
				return true;
			}
		}
		return false;
	}
}
