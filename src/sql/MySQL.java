package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import afnCraft.AfnCraft;
import net.md_5.bungee.api.ChatColor;

public class MySQL {
	private String host;
	private String port;
	private String database;
	private String username;
	private String password;
	
	private Connection connection;
	
	public void init() {
		this.host = AfnCraft.getInstance().getConfig().getString("sql.host");
		this.port = AfnCraft.getInstance().getConfig().getString("sql.port");
		this.database = AfnCraft.getInstance().getConfig().getString("sql.database");
		this.username = AfnCraft.getInstance().getConfig().getString("sql.username");
		this.password = AfnCraft.getInstance().getConfig().getString("sql.password");
		
		try {
			connect();
		} catch (ClassNotFoundException | SQLException e) {
			Bukkit.getLogger().info(ChatColor.RED + "Database not connected");
		}
		
		if(this.isConnected()) {
			Bukkit.getLogger().info(ChatColor.GREEN + "Database is connected");
		}
	}
	
	public void connect() throws ClassNotFoundException, SQLException{
		if(!isConnected()) {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false", username, password);
		}
	}
	
	public void disconnect() {
		if(isConnected()) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public boolean isConnected() {
		return(connection == null ? false : true);
	}
}
