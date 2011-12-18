package cleanChat.tjnome.main;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import cleanChat.tjnome.main.conf.CleanChatConf;

/**
 * CleanChat for Bukkit
 * 
 * @author tjnome
 */
public class CleanChat extends JavaPlugin {
	public PluginManager pm;
	private final CleanChatPlayerListener playerListener = new CleanChatPlayerListener(this);
	private final CleanChatBlockListener blockListener = new CleanChatBlockListener(this);
	protected final CleanChatConf configuration;
	
	public CleanChat() {
		configuration = new CleanChatConf(this);
	}

	public void onEnable() {
		registerEvents();
		PluginDescriptionFile pdfFile = this.getDescription();
		this.configuration.load();
		System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
	}

	public void onDisable() {
		System.out.println("CleanChat disablet!");
		configuration.cleanup();
	}

	public void registerEvents() {
		this.pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_QUIT, this.playerListener,Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, this.playerListener,Event.Priority.Normal, this);
	}

}
