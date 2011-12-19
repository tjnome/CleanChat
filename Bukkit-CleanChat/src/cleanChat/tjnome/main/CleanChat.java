package cleanChat.tjnome.main;

import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import cleanChat.tjnome.main.conf.CleanChatConf;
import cleanChat.tjnome.main.listener.CleanChatBlockListener;
import cleanChat.tjnome.main.listener.CleanChatPlayerListener;

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
	
	public CleanChatConf getGlobalConfiguration() {
		return configuration;
	}
	
	public String colorTxt(String string) {
        string = string.replaceAll("&0", ChatColor.BLACK + "");
        string = string.replaceAll("&1", ChatColor.DARK_BLUE + "");
        string = string.replaceAll("&2", ChatColor.DARK_GREEN + "");
        string = string.replaceAll("&3", ChatColor.DARK_AQUA + "");
        string = string.replaceAll("&4", ChatColor.DARK_RED + "");
        string = string.replaceAll("&5", ChatColor.DARK_PURPLE + "");
        string = string.replaceAll("&6", ChatColor.GOLD + "");
        string = string.replaceAll("&7", ChatColor.GRAY + "");
        string = string.replaceAll("&8", ChatColor.DARK_GRAY + "");
        string = string.replaceAll("&9", ChatColor.BLUE + "");
        string = string.replaceAll("&a", ChatColor.GREEN + "");
        string = string.replaceAll("&b", ChatColor.AQUA + "");
        string = string.replaceAll("&c", ChatColor.RED + "");
        string = string.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
        string = string.replaceAll("&e", ChatColor.YELLOW + "");
        string = string.replaceAll("&f", ChatColor.WHITE + "");
        return string;
    }

}
