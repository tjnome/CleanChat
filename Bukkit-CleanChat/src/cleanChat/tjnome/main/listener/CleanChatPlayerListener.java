package cleanChat.tjnome.main.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

import cleanChat.tjnome.main.CleanChat;
import cleanChat.tjnome.main.conf.CleanChatConf;

/**
 *
 * CleanChat
 * Copyright (C) 2011 tjnome
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 *  @author tjnome
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
    			Player player = event.getPlayer();
    			event.setQuitMessage(this.plugin.colorTxt(cfg.logoutmsg.replace("%player%", (CharSequence) player)));
    		}
    	}
	}
    
    public void onPlayerJoin(PlayerJoinEvent event) {
    	CleanChatConf cfg = this.plugin.getGlobalConfiguration();
    	if (cfg.login) {
    		event.setJoinMessage(null);
    	} else {
    		if (cfg.customizeloginmsg) {
    			Player player = event.getPlayer();
    			event.setJoinMessage(this.plugin.colorTxt(cfg.loginmsg.replace("%player%", (CharSequence) player)));
    		}
    	}
    }
}

