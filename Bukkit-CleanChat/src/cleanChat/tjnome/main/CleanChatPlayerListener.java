package cleanChat.tjnome.main;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

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
    	event.setQuitMessage(null);
	}
    
    public void onPlayerJoin(PlayerJoinEvent event) {
    	event.setJoinMessage(null);
    }
}

