package afnCraft;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import commands.GiveCustomWeapon;
import commands.ResetSpawnLocs;
import commands.SetSpawnLocation;
import commands.SpawnCustom;
import events.MobHealthBars;
import events.WitherRod;
import items.ItemManager;
import spawns.SpawnManager;
import sql.MySQL;
import sql.SQLHandler;

public class AfnCraft extends JavaPlugin {
	private static AfnCraft instance;
	
	public MySQL SQL;
	public static SQLHandler SQLHandler;
	
	@SuppressWarnings("static-access")
	@Override
	public void onEnable() {
//setting the instance for other classes to use
		instance = this;
		
		//loading config
		loadConfig();
		
		//setting up database connection
		this.SQL = new MySQL();
		this.SQL.init();
		
		//setting up the database handler
		this.SQLHandler = new SQLHandler(this);
		
		//checking if SQL connection is present
		if(SQL.isConnected()) {
			//initializing SQL handler
			this.SQLHandler.init();
			
			//initializing all custom mob spawns
			SpawnManager.init();
		}
		
		//initializing all custom objects
		ItemManager.init();
		
		//registering all commands
		getCommand("setspawnlocation").setExecutor(new SetSpawnLocation());
		getCommand("resetpawnlocations").setExecutor(new ResetSpawnLocs());
		getCommand("givecustomweapon").setExecutor(new GiveCustomWeapon());
		getCommand("spawncustom").setExecutor(new SpawnCustom());
		
		//registering all events
		getServer().getPluginManager().registerEvents(new WitherRod(), this);
		getServer().getPluginManager().registerEvents(new MobHealthBars(), this);
		
		//if everything went well, say that plugin has started succesfully
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "AfnCraft plugin has been enabled");
	}
	
	@Override
	public void onDisable() {
		this.SQL.disconnect();
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "AfnCraft plugin has been disabled");
	}
	

	public static AfnCraft getInstance() {
		return instance;
	}
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();
	}
}
