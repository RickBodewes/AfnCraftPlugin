package commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import afnCraft.AfnCraft;
import spawns.SpawnManager;
import spawns.oldGuards.*;


public class SetSpawnLocation implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player)sender;
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("only players can use this command");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("setspawnlocation")) {
			if(isParsable(args[0])) {
				double locX = player.getLocation().getX();
				double locY = player.getLocation().getY();
				double locZ = player.getLocation().getZ();
				
				String world = player.getWorld().getName();
				
				int spawnLocID = 0;
				
				switch(args[1]) {
					case "healthyoldguard":
						spawnLocID = AfnCraft.SQLHandler.addSpawnLoc("healthyoldguard", world, Integer.parseInt(args[0]), locX, locY, locZ);
						SpawnManager.healthyOldGuardSpawns.add(new HealthyOldGuardSpawnLoc(spawnLocID , world, locX, locY, locZ, Integer.parseInt(args[0])));
						player.sendMessage("Spawn location with id " + spawnLocID + " and delay " + args[0] + " has been created!");
						break;
					case "bowoldguard":
						spawnLocID = AfnCraft.SQLHandler.addSpawnLoc("bowoldguard", world, Integer.parseInt(args[0]), locX, locY, locZ);
						SpawnManager.bowOldGuardSpawns.add(new BowOldGuardSpawnLoc(spawnLocID , world, locX, locY, locZ, Integer.parseInt(args[0])));
						player.sendMessage("Spawn location with id " + spawnLocID + " and delay " + args[0] + " has been created!");
						break;
					case "swordoldguard":
						spawnLocID = AfnCraft.SQLHandler.addSpawnLoc("swordoldguard", world, Integer.parseInt(args[0]), locX, locY, locZ);
						SpawnManager.swordOldGuardSpawns.add(new SwordOldGuardSpawnLoc(spawnLocID , world, locX, locY, locZ, Integer.parseInt(args[0])));
						player.sendMessage("Spawn location with id " + spawnLocID + " and delay " + args[0] + " has been created!");
						break;
					case "speedyoldguard":
						spawnLocID = AfnCraft.SQLHandler.addSpawnLoc("speedyoldguard", world, Integer.parseInt(args[0]), locX, locY, locZ);
						SpawnManager.speedyOldGuardSpawns.add(new SpeedyOldGuardSpawnLoc(spawnLocID , world, locX, locY, locZ, Integer.parseInt(args[0])));
						player.sendMessage("Spawn location with id " + spawnLocID + " and delay " + args[0] + " has been created!");
						break;
					default:
						player.sendMessage(ChatColor.RED + "That mob is not recognised!");
						break;
				}
			}else {
				player.sendMessage(ChatColor.RED + "Invalid format for interval!");
			}
		}
		
		return true;
	}
	
	private boolean isParsable(String input) {
	    try {
	        Integer.parseInt(input);
	        return true;
	    } catch (final NumberFormatException e) {
	        return false;
	    }
	}
}
