package cleanChat.tjnome.main;
import java.io.File;

import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * CleanChat for Bukkit
 *
 * @author tjnome
 */
public class CleanChat extends JavaPlugin {
	public PluginManager pm;
    private final CleanChatPlayerListener playerListener = new CleanChatPlayerListener(this);
    private final CleanChatBlockListener blockListener = new CleanChatBlockListener(this);

    public CleanChat(PluginLoader pluginLoader, Server instance, PluginDescriptionFile desc, File folder, File plugin, ClassLoader cLoader) {
    }

   

    public void onEnable() {
    	registerEvents();
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }
    public void onDisable() {
        System.out.println("CleanChat disablet!");
    }
    
    public void registerEvents() {

		this.pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_QUIT, this.playerListener,Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, this.playerListener,Event.Priority.Normal, this);
    }
    
}

