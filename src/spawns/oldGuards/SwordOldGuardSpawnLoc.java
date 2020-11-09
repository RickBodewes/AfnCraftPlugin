package spawns.oldGuards;

import customEntities.mobs.oldGuards.SwordOldGuard;
import spawns.SpawnLocation;

public class SwordOldGuardSpawnLoc extends SpawnLocation {
	SwordOldGuard entity;
	public SwordOldGuardSpawnLoc(int spawnLocID, String world, double X, double Y, double Z, int interval) {
		super(spawnLocID, world, X, Y, Z, interval);
		
		entity = new SwordOldGuard(this.loc);
		this.worldServer.addEntity(entity);
	}
	
	public void spawn() {
		if(!entity.isAlive()) {
			entity = new SwordOldGuard(this.loc);
			this.worldServer.addEntity(entity);
		}
	}
}
