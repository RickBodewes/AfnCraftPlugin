package spawns.oldGuards;

import customEntities.mobs.oldGuards.SpeedyOldGuard;
import spawns.SpawnLocation;

public class SpeedyOldGuardSpawnLoc extends SpawnLocation {
	SpeedyOldGuard entity;
	public SpeedyOldGuardSpawnLoc(int spawnLocID, String world, double X, double Y, double Z, int interval) {
		super(spawnLocID, world, X, Y, Z, interval);
		
		entity = new SpeedyOldGuard(this.loc);
		this.worldServer.addEntity(entity);
	}
	
	public void spawn() {
		if(!entity.isAlive()) {
			entity = new SpeedyOldGuard(this.loc);
			this.worldServer.addEntity(entity);
		}
	}
}
