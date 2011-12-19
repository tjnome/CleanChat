package cleanChat.tjnome.main.listener;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

import cleanChat.tjnome.main.CleanChat;
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
    	} else {
    		if (cfg.customizelogoutmsg) {
    			event.setQuitMessage(this.plugin.colorTxt(cfg.logoutmsg));
    		}
    	}
	}
    
    public void onPlayerJoin(PlayerJoinEvent event) {
    	CleanChatConf cfg = this.plugin.getGlobalConfiguration();
    	if (cfg.login) {
    		event.setJoinMessage(null);
    	} else {
    		if (cfg.customizeloginmsg) {
    			event.setJoinMessage(this.plugin.colorTxt(cfg.loginmsg));
    		}
    	}
    }
}

