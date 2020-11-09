package spawns;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;

import afnCraft.AfnCraft;
import net.minecraft.server.v1_16_R2.WorldServer;

public class SpawnLocation {
	public int spawnLocID;
	public Location loc;
	public CraftWorld craftWorld;
	public WorldServer worldServer;
	
	public SpawnLocation(int spawnLocID, String world, double X, double Y, double Z, int interval) {
		this.spawnLocID = spawnLocID;
		
		craftWorld = (CraftWorld) Bukkit.getWorld(world);
		loc = new Location((World) craftWorld, X, Y, Z);
		worldServer = craftWorld.getHandle();		
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(AfnCraft.getInstance(), new Runnable() {
			@Override
			public void run() {
				spawn();
			}
		}, interval * 20, interval * 20);
	}
	
	public void spawn() {}
}
