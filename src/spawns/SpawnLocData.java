package spawns;

public class SpawnLocData {
	private int spawnLocID;
	private String spawnLocWorld;
	private int spawnLocInterval;
	private double spawnLocX;
	private double spawnLocY;
	private double spawnLocZ;
	
	public void setSpawnLocID(int spawnLocID) {
		this.spawnLocID = spawnLocID;
	}
	
	public void setSpawnLocWorld(String spawnLocWorld) {
		this.spawnLocWorld = spawnLocWorld;
	}
	
	public void setSpawnLocInterval(int spawnLocInterval) {
		this.spawnLocInterval = spawnLocInterval;
	}
	
	public void setSpawnLocX (double spawnLocX) {
		this.spawnLocX = spawnLocX;
	}
	
	public void setSpawnLocY (double spawnLocY) {
		this.spawnLocY = spawnLocY;
	}
	
	public void setSpawnLocZ (double spawnLocZ) {
		this.spawnLocZ = spawnLocZ;
	}
	
	public int getSpawnLocID() {
		return this.spawnLocID;
	}
	
	public String getSpawnLocWorld() {
		return this.spawnLocWorld;
	}
	
	public int getSpawnLocInterval() {
		return this.spawnLocInterval;
	}
	
	public double getSpawnLocX() {
		return this.spawnLocX;
	}
	
	public double getSpawnLocY() {
		return this.spawnLocY;
	}
	
	public double getSpawnLocZ() {
		return this.spawnLocZ;
	}
}
