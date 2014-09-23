package org.nationsatwar.magictestingwands.commands;

import java.util.ArrayList;
import java.util.List;

import org.nationsatwar.magictestingwands.MagicWands;
import org.nationsatwar.magictestingwands.items.ItemMagicWand;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandAddWand implements ICommand
{
	
	private List aliases;
	public CommandAddWand()
	{
		// set up command aliases
		this.aliases = new ArrayList();
		this.aliases.add("addWand");
		this.aliases.add("addwand");
	}

	@Override
	public String getCommandName() 
	{
		// TODO Auto-generated method stub
		return "addWand";
	}
	  
	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) 
	{
		// TODO Auto-generated method stub
		return "addWand [wandName] [wandCommand]";
	}

	@Override
	public List getCommandAliases() 
	{
		// Returns list of valid aliases for the command
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) 
	{
		// TODO Auto-generated method stub
		
		String wandName = "";
		int commandStart = 0;
		String wandCommand = "";
		
		if(p_71515_2_[0].startsWith("\""))
		{
			for(int i = 0; i < p_71515_2_.length; i++) 
			{
				wandName += " " + p_71515_2_[i];
				
				if(p_71515_2_[i].endsWith("\""))
				{
					commandStart = i+1;
					break;
				}
			}
		}
		else
		{
			wandName = p_71515_2_[0];
			commandStart = 1;
		}
		
		if(!MagicWands.config.getCategory("wands").containsKey(wandName))
		{
			wandName = wandName.replaceAll("\"","");
			for(int i = commandStart; i < p_71515_2_.length; i++) 
			{
				wandCommand += " " + p_71515_2_[i];
			}
			
			// add to config
			MagicWands.config.get("wands", wandName.trim(), wandCommand.trim()).getString();
			MagicWands.config.save();
			
			// create item
			ItemMagicWand magicWand = new ItemMagicWand(wandName.trim(),wandCommand.trim());
			
			// give copy to player
			// Note that func_152612_a is a function that takes a string and spits out a Player; may be getPlayerForUsername() mentioned here: http://www.minecraftforge.net/forum/index.php?topic=4111.0
			EntityPlayer player = MinecraftServer.getServer().getConfigurationManager().func_152612_a(p_71515_1_.getCommandSenderName());
			player.inventory.addItemStackToInventory(new ItemStack(magicWand));
		}
		else
		{
			ChatComponentText error = new ChatComponentText("Error: wand name '" + wandName + "' already in use; please remove the existing wand or use another name.");
			p_71515_1_.addChatMessage(error);
		}
		
		//ChatComponentText msg = new ChatComponentText(wandName + "," + wandCommand);
	    //p_71515_1_.addChatMessage(msg);
		// multi-word names: if they still show up as separate entries in array, look for "s on start and end of entries for the name
		// assume first such pair is a name and anything following is a command
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
