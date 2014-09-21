package org.nationsatwar.magictestingwands.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nationsatwar.magictestingwands.MagicWands;
import org.nationsatwar.magictestingwands.items.ItemMagicWand;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Property;

public class CommandListWands implements ICommand
{
	private List aliases;
	public CommandListWands()
	{
		// set up command aliases
		this.aliases = new ArrayList();
		this.aliases.add("listWands");
		this.aliases.add("listwands");
	}

	@Override
	public int compareTo(Object o) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() 
	{
		// TODO Auto-generated method stub
		return "listWands";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) 
	{
		// TODO Auto-generated method stub
		return "listWands";
	}

	@Override
	public List getCommandAliases() 
	{
		// TODO Auto-generated method stub
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) 
	{
		// TODO Auto-generated method stub
		ConfigCategory wandCategory = MagicWands.config.getCategory("wands");
		
		Map<String, Property> val = wandCategory.getValues();
		
		for (String key : val.keySet()) 
		{
		    String wandString = key + ": " + val.get(key).getString();
		    ChatComponentText msg = new ChatComponentText(wandString);
		    p_71515_1_.addChatMessage(msg);

		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}
