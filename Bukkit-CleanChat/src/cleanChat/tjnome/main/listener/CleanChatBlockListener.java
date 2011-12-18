package cleanChat.tjnome.main.listener;
import org.bukkit.event.block.BlockListener;

import cleanChat.tjnome.main.CleanChat;

/**
 *
 * @author tjnome
 */
public class CleanChatBlockListener extends BlockListener {
    private final CleanChat plugin;

    public CleanChatBlockListener(final CleanChat plugin) {
        this.plugin = plugin;
    }

    //put all Block related code here
}
