package spawns;

import java.util.ArrayList;
import java.util.List;

import afnCraft.AfnCraft;
import spawns.oldGuards.*;

public class SpawnManager {
	
	public static List<HealthyOldGuardSpawnLoc> healthyOldGuardSpawns = new ArrayList<>();
	public static List<BowOldGuardSpawnLoc> bowOldGuardSpawns = new ArrayList<>();
	public static List<SwordOldGuardSpawnLoc> swordOldGuardSpawns = new ArrayList<>();
	public static List<SpeedyOldGuardSpawnLoc> speedyOldGuardSpawns = new ArrayList<>();
	
	public static void init() {
		initHealthyOldGuards();
		initBowOldGuards();
		initSwordOldGuards();
		initSpeedyOldGuards();
	}
	
	private static void initHealthyOldGuards() {
		List<SpawnLocData> spawnLocs = AfnCraft.SQLHandler.getSpawnLocs("healthyoldguard");
		for(SpawnLocData spawnLocData : spawnLocs) {
			healthyOldGuardSpawns.add(new HealthyOldGuardSpawnLoc(spawnLocData.getSpawnLocID(), spawnLocData.getSpawnLocWorld(), spawnLocData.getSpawnLocX(), spawnLocData.getSpawnLocY(), spawnLocData.getSpawnLocZ(), spawnLocData.getSpawnLocInterval()));
		}
	}
	
	private static void initBowOldGuards() {
		List<SpawnLocData> spawnLocs = AfnCraft.SQLHandler.getSpawnLocs("bowoldguard");
		for(SpawnLocData spawnLocData : spawnLocs) {
			bowOldGuardSpawns.add(new BowOldGuardSpawnLoc(spawnLocData.getSpawnLocID(), spawnLocData.getSpawnLocWorld(), spawnLocData.getSpawnLocX(), spawnLocData.getSpawnLocY(), spawnLocData.getSpawnLocZ(), spawnLocData.getSpawnLocInterval()));
		}
	}
	
	private static void initSwordOldGuards() {
		List<SpawnLocData> spawnLocs = AfnCraft.SQLHandler.getSpawnLocs("swordoldguard");
		for(SpawnLocData spawnLocData : spawnLocs) {
			swordOldGuardSpawns.add(new SwordOldGuardSpawnLoc(spawnLocData.getSpawnLocID(), spawnLocData.getSpawnLocWorld(), spawnLocData.getSpawnLocX(), spawnLocData.getSpawnLocY(), spawnLocData.getSpawnLocZ(), spawnLocData.getSpawnLocInterval()));
		}
	}
	
	private static void initSpeedyOldGuards() {
		List<SpawnLocData> spawnLocs = AfnCraft.SQLHandler.getSpawnLocs("speedyoldguard");
		for(SpawnLocData spawnLocData : spawnLocs) {
			speedyOldGuardSpawns.add(new SpeedyOldGuardSpawnLoc(spawnLocData.getSpawnLocID(), spawnLocData.getSpawnLocWorld(), spawnLocData.getSpawnLocX(), spawnLocData.getSpawnLocY(), spawnLocData.getSpawnLocZ(), spawnLocData.getSpawnLocInterval()));
		}
	}
}
