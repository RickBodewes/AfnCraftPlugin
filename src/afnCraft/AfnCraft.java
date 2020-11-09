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
		loadConfig();
		
		instance = this;
		
		//connecting to the database
		this.SQL = new MySQL();
		this.SQL.init();
		
		this.SQLHandler = new SQLHandler(this);
		this.SQLHandler.init();
		
		if(SQL.isConnected()) {
			//initializing all custom mob spawns
			SpawnManager.init();
		}
		//registering custom spawn location command
		getCommand("setspawnlocation").setExecutor(new SetSpawnLocation());
		getCommand("resetpawnlocations").setExecutor(new ResetSpawnLocs());
		
		//initializing all custom items
		ItemManager.init();
		
		//registering wither rod events and commands
		getCommand("givecustomweapon").setExecutor(new GiveCustomWeapon());
		getServer().getPluginManager().registerEvents(new WitherRod(), this);
		
		//registering custom mob spawn commands
		getCommand("spawncustom").setExecutor(new SpawnCustom());
		
		//change mob healthbars
		getServer().getPluginManager().registerEvents(new MobHealthBars(), this);
		
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
