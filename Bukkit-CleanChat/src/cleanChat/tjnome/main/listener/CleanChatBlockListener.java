package cleanChat.tjnome.main.listener;
import org.bukkit.event.block.BlockListener;

import cleanChat.tjnome.main.CleanChat;

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

public class CleanChatBlockListener extends BlockListener {
    private final CleanChat plugin;

    public CleanChatBlockListener(final CleanChat plugin) {
        this.plugin = plugin;
    }

    //put all Block related code here
}
