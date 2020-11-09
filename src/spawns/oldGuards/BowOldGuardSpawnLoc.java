package spawns.oldGuards;

import customEntities.mobs.oldGuards.BowOldGuard;
import spawns.SpawnLocation;

public class BowOldGuardSpawnLoc extends SpawnLocation {
	BowOldGuard entity;
	public BowOldGuardSpawnLoc(int spawnLocID, String world, double X, double Y, double Z, int interval) {
		super(spawnLocID, world, X, Y, Z, interval);
		
		entity = new BowOldGuard(this.loc);
		this.worldServer.addEntity(entity);
	}
	
	public void spawn() {
		if(!entity.isAlive()) {
			entity = new BowOldGuard(this.loc);
			this.worldServer.addEntity(entity);
		}
	}
}
