package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import items.weapons.OldGuardsWeapons;
import items.weapons.wands.WitherRodItem;

import org.bukkit.ChatColor;

public class GiveCustomWeapon implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player)sender;
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("only players can use this command");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("givecustomweapon")) {
			switch(args[0]) {
				case "witherrod":
					player.getInventory().addItem(WitherRodItem.witherRod);
					break;
				case "oldguardsword":
					player.getInventory().addItem(OldGuardsWeapons.oldGuardSword);
					break;
				case "oldguardbow":
					player.getInventory().addItem(OldGuardsWeapons.oldGuardBow);
					break;
				default:
					player.sendMessage(ChatColor.RED + "That item is not recognised!");
					break;
			}
		}
		
		return true;
	}
}
