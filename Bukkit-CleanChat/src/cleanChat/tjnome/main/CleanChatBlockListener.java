package cleanChat.tjnome.main;
import org.bukkit.event.block.BlockListener;

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
