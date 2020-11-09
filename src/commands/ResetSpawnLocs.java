package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import afnCraft.AfnCraft;
import net.md_5.bungee.api.ChatColor;

public class ResetSpawnLocs implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("only players can use this command");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("resetpawnlocations")) {
			AfnCraft.SQLHandler.resetSpawnLocs();
			sender.sendMessage(ChatColor.GREEN + "all spawn locations have been removed from the database, please restart the server for it to update.");
		}
		return true;
	}
}
