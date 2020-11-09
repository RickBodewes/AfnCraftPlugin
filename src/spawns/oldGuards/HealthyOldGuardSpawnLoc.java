package spawns.oldGuards;

import customEntities.mobs.oldGuards.HealthyOldGuard;
import spawns.SpawnLocation;

public class HealthyOldGuardSpawnLoc extends SpawnLocation {
	
	HealthyOldGuard entity;
	
	public HealthyOldGuardSpawnLoc(int spawnLocID, String world, double X, double Y, double Z, int interval) {
		super(spawnLocID, world, X, Y, Z, interval);
		
		entity = new HealthyOldGuard(this.loc);
		this.worldServer.addEntity(entity);
	}
	
	public void spawn() {
		if(!entity.isAlive()) {
			entity = new HealthyOldGuard(this.loc);
			this.worldServer.addEntity(entity);
		}
	}
}
