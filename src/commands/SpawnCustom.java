package commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.Player;

import customEntities.mobs.oldGuards.*;
import net.minecraft.server.v1_16_R2.WorldServer;

public class SpawnCustom implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player)sender;
		WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("only players can use this command");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("spawncustom")) {
			switch(args[0]) {
				case "healthyoldguard":
					HealthyOldGuard healthyOldGuard = new HealthyOldGuard(player.getLocation());
					world.addEntity(healthyOldGuard);
					break;
				case "swordoldguard":
					SwordOldGuard swordOldGuard = new SwordOldGuard(player.getLocation());
					world.addEntity(swordOldGuard);
					break;
				case "bowoldguard":
					BowOldGuard bowOldGuard = new BowOldGuard(player.getLocation());
					world.addEntity(bowOldGuard);
					break;
				case "speedyoldguard":
					SpeedyOldGuard speedyOldGuard = new SpeedyOldGuard(player.getLocation());
					world.addEntity(speedyOldGuard);
					break;
				default:
					player.sendMessage(ChatColor.RED + "That mob is not recognised!");
					break;
			}
		}
		
		return true;
	}

}
