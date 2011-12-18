package cleanChat.tjnome.main.conf;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;

import cleanChat.tjnome.main.CleanChat;

public class CleanChatConf {

	private CleanChat plugin;
	private HashMap<String, Object> configDefaults = new HashMap<String, Object>();
	private YamlConfiguration config;
	private File configFile;
	
	public CleanChatConf(CleanChat plugin) {
		this.plugin = plugin;
	}
	// Server
	public boolean login;
	public boolean logout;

	public void load() {
		this.config = new YamlConfiguration();
		this.configFile = new File(plugin.getDataFolder(), "config.yml");
		
		//Server
		this.configDefaults.put("Server.login", false);
		this.configDefaults.put("Server.logout", false);
		
		if (!this.configFile.exists()) {
			for (String key : this.configDefaults.keySet()) {
				this.config.set(key, this.configDefaults.get(key));
			}
			try {
				config.save(this.configFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				config.load(this.configFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.login = config.getBoolean("Server.login");
		this.logout = config.getBoolean("Server.logout");
	}
	
	public void cleanup() {
		configDefaults.clear();
	}
}


