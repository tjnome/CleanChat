package cleanChat.tjnome.main.listener;

import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.PlayerDeathEvent;

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

public class CleanChatEnityListener extends EntityListener {

	private final CleanChat plugin;

	public CleanChatEnityListener(CleanChat instance) {
		this.plugin = instance;
	}
	
	public void onEntityDeath(EntityDeathEvent event) {
		CleanChatConf cfg = this.plugin.getGlobalConfiguration();
        if (event instanceof PlayerDeathEvent) {
          PlayerDeathEvent pde = (PlayerDeathEvent) event;
          if (cfg.death) {
        	  pde.setDeathMessage(null);
          } else {
        	  if (cfg.customizedeathmsg) {
        		  DamageCause death = pde.getEntity().getLastDamageCause().getCause();
        		  if (event.getEntity() instanceof Player) {
        			  if ((Player) event.getEntity() != null) {
        				  if (death == DamageCause.PROJECTILE) {
        					  Player attacker = (Player)event.getEntity().getLastDamageCause().getEntity();
        					  if(attacker instanceof Player) {
        						  pde.setDeathMessage(getAttacker(attacker));
        						  return;
        	                  }
        				  }
        			  }
        			  pde.setDeathMessage(getDeathCause(death));
        		  }
        	  }
          }
        }
	}
	
	private String getDeathCause(DamageCause death) {
		String msg = "";
		
		if (death == DamageCause.DROWNING) {
			 msg = ("Was killed by " + death.toString());
		  } else if (death == DamageCause.CONTACT) {
			  msg = ("Was killed by " + death.toString());
	      } else if (death == DamageCause.ENTITY_EXPLOSION) {
	    	  msg = ("Was killed by " + death.toString());
	      } else if (death == DamageCause.BLOCK_EXPLOSION) {
	    	  msg = ("Was killed by " + death.toString());
	      } else if (death == DamageCause.FALL) {
	    	  msg = ("Was killed by " + death.toString());
	      } else if (death == DamageCause.SUFFOCATION) {
	    	  msg = ("Was killed by " + death.toString()); 
		  } else if (death == DamageCause.FIRE) {
			  msg = ("Was killed by " + death.toString()); 
		  } else if (death == DamageCause.FIRE_TICK) {
			  msg = ("Was killed by " + death.toString()); 
		  } else if (death == DamageCause.LAVA) {
			  msg = ("Was killed by " + death.toString());   
		  } else if (death == DamageCause.VOID) {
			  msg = ("Was killed by " + death.toString());
		  } else if (death == DamageCause.LIGHTNING) {
			  msg = ("Was killed by " + death.toString()); 
		  } else if (death == DamageCause.STARVATION) {
			  msg = ("Was killed by " + death.toString()); 
		  } else if (death == DamageCause.SUICIDE) {
			  msg = ("Was killed by " + death.toString());
		  }
		return msg;
	}
	
	private String getAttacker(Object attacker) {
        String msg = "";
        
        if(attacker instanceof Player) {
			  Player aggressor = (Player)attacker;
			  
			  
        } else if (attacker instanceof Ghast || attacker instanceof Fireball) {
        	
        } else if (attacker instanceof PigZombie) {
        	
        } else if (attacker instanceof Zombie) {
        	
        } else if (attacker instanceof Skeleton) {
        	
        } else if (attacker instanceof Creeper) {
        	
        } else if (attacker instanceof Spider) {
        	
        } else if (attacker instanceof Slime) {
        	
        } else if (attacker instanceof Giant) {
        	
        } else if (attacker instanceof Wolf) {
        	
        } else if (attacker instanceof CaveSpider) {
        	
        } else if (attacker instanceof Enderman) {
        	
        } else if (attacker instanceof Silverfish) {
        	
        } else if (attacker instanceof MagmaCube) {
        	
        } else if (attacker instanceof Blaze) {
        	
        } else if (attacker instanceof Snowman) {
        	
        } else if (attacker instanceof EnderDragon) {
        	
        } else if(attacker == null) {
        	
        }
        return msg;
    }
}
