package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import afnCraft.AfnCraft;
import spawns.SpawnLocData;

public class SQLHandler {
	private AfnCraft plugin;
	
	public SQLHandler(AfnCraft plugin) {
		this.plugin = plugin;
	}
	
	public void init() {
		createTables();
	}
	
	private void createTables() {
		PreparedStatement spawnLocsPS;
		try {
			spawnLocsPS = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS animecraft_spawnlocations (spawnLocationID INT NOT NULL AUTO_INCREMENT , type VARCHAR(256) NOT NULL , world VARCHAR(256) NOT NULL , spawnInterval INT NOT NULL , locX DOUBLE NOT NULL , locY DOUBLE NOT NULL , locZ DOUBLE NOT NULL , PRIMARY KEY (spawnLocationID))"); 
			spawnLocsPS.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public int addSpawnLoc(String type, String world, int interval, double locX, double locY, double locZ) {
		PreparedStatement addSpawnLocsPS;
		int spawnLocId = 0;
		
		try {
			addSpawnLocsPS = plugin.SQL.getConnection().prepareStatement("INSERT INTO animecraft_spawnlocations (type, world, spawnInterval, locX, locY, locZ) values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); 
			addSpawnLocsPS.setString(1, type); 
			addSpawnLocsPS.setString(2, world); 
			addSpawnLocsPS.setInt(3, interval); 
			addSpawnLocsPS.setDouble(4, locX); 
			addSpawnLocsPS.setDouble(5, locY); 
			addSpawnLocsPS.setDouble(6, locZ);
			addSpawnLocsPS.executeUpdate();
			
			ResultSet spawnLocGeneratedKeys = addSpawnLocsPS.getGeneratedKeys();
			if(spawnLocGeneratedKeys.next()) {
				spawnLocId = spawnLocGeneratedKeys.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return spawnLocId;
	}
	
	public List<SpawnLocData> getSpawnLocs(String type) {
		PreparedStatement getSpawnLocsPS;
		List<SpawnLocData> spawnLocs = new ArrayList<SpawnLocData>();
		
		try{
			getSpawnLocsPS = plugin.SQL.getConnection().prepareStatement("SELECT * FROM animecraft_spawnlocations WHERE type = ?");
			getSpawnLocsPS.setString(1, type);
			ResultSet results = getSpawnLocsPS.executeQuery();
			
			while(results.next()) {
				SpawnLocData spawnLoc = new SpawnLocData();
				spawnLoc.setSpawnLocID(results.getInt("spawnLocationID"));
				spawnLoc.setSpawnLocWorld(results.getString("world"));
				spawnLoc.setSpawnLocInterval(results.getInt("spawnInterval"));
				spawnLoc.setSpawnLocX(results.getDouble("locX"));
				spawnLoc.setSpawnLocY(results.getDouble("locY"));
				spawnLoc.setSpawnLocZ(results.getDouble("locZ"));
				spawnLocs.add(spawnLoc);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return spawnLocs;
	}
	
	public void resetSpawnLocs() {
		PreparedStatement resetSpawnLocsPS;
		try {
			resetSpawnLocsPS = plugin.SQL.getConnection().prepareStatement("TRUNCATE TABLE animecraft_spawnlocations");
			resetSpawnLocsPS.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
