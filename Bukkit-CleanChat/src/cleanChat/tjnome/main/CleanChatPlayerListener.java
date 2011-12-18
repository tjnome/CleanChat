package cleanChat.tjnome.main;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

import cleanChat.tjnome.main.conf.CleanChatConf;

/**
 *
 * @author tjnome
 */
public class CleanChatPlayerListener extends PlayerListener {
    private final CleanChat plugin;

    public CleanChatPlayerListener(CleanChat instance) {
        plugin = instance;
    }

    public void onPlayerQuit(PlayerQuitEvent event) {
    	CleanChatConf cfg = this.plugin.getGlobalConfiguration();
    	if (cfg.logout) {
    		event.setQuitMessage(null);
    	}
	}
    
    public void onPlayerJoin(PlayerJoinEvent event) {
    	CleanChatConf cfg = this.plugin.getGlobalConfiguration();
    	if (cfg.login) {
    		event.setJoinMessage(null);
    	}
    }
}

