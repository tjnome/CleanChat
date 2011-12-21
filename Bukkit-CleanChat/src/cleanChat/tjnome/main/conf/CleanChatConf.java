package cleanChat.tjnome.main.conf;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;

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

public class CleanChatConf {

	private CleanChat plugin;
	private HashMap<String, Object> configDefaults = new HashMap<String, Object>();
	private YamlConfiguration config;
	private File configFile;
	
	public CleanChatConf(CleanChat plugin) {
		this.plugin = plugin;
	}
	// Server
	public boolean login;
	public boolean logout;
	public boolean death;
	
	//Customize - login/logout
	public boolean customizeloginmsg;
	public String loginmsg;
	public boolean customizelogoutmsg;
	public String logoutmsg;
	
	//Customize - death
	public boolean customizedeathmsg;
	public String attackplayer;
	public String attackghast;
	public String attackpigzombie;
	public String attackzombie;
	public String attackskeleton;
	public String attackcreeper;
	public String attackspider;
	public String attackslime;
	public String attackgiant;
	public String attackwolf;
	public String attackcavespider;
	public String attackenderman;
	public String attacksilverfish;
	public String attackmagmacube;
	public String attackblaze;
	public String attacksnowman;
	public String attackenderdragon;
	
	public String environmentdrowning;
	public String environmentcontact;
	public String environmententityexplosion;
	public String environmentblockexplosion;
	public String environmentfall;
	public String environmentsuffocation;
	public String environmentfire;
	public String environmentfire_tick;
	public String environmentlava;
	public String environmentvoid;
	public String environmentlightning;
	public String environmentstarvation;
	public String environmentsuicide;

	public void load() {
		this.config = new YamlConfiguration();
		this.configFile = new File(plugin.getDataFolder(), "config.yml");
		
		//Server
		this.configDefaults.put("Server.remove-login-msg", true);
		this.configDefaults.put("Server.remove-logout-msg", true);
		this.configDefaults.put("Server.remove-death-msg", true);
		
		//Customize - login/logout
		this.configDefaults.put("Server.customize.login", false);
		this.configDefaults.put("Server.customize.login.msg", "Welcome %player% to my Minecraft-server");
		this.configDefaults.put("Server.customize.logout", false);
		this.configDefaults.put("Server.customize.logout.msg", "Bye bye %player%");
		
		//Customize - death
		this.configDefaults.put("Server.customize.death", false);
		this.configDefaults.put("Server.customize.death.attacker.Player", "%player% was killed by %attacker-player%");
		this.configDefaults.put("Server.customize.death.attacker.Ghast", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.PigZombie", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Zombie", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Skeleton", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Creeper", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Spider", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Slime", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Giant", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Wolf", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.CaveSpider", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Enderman", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Silverfish", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.MagmaCube", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Blaze", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.Snowman", "%player% was killed by %mobs%");
		this.configDefaults.put("Server.customize.death.attacker.EnderDragon", "%player% was killed by %mobs%");
		
		this.configDefaults.put("Server.customize.death.environment.Drowning", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Contact", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Entity_explosion", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Block_explosion", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Fall", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Suffocation", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Fire", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Fire_tick", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Lava", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Void", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Lightning", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Starvation", "%player% was killed by %environment%");
		this.configDefaults.put("Server.customize.death.environment.Suicide", "%player% was killed by %environment%");
		
		
		if (!this.configFile.exists()) {
			for (String key : this.configDefaults.keySet()) {
				this.config.set(key, this.configDefaults.get(key));
			}
			try {
				config.save(this.configFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				config.load(this.configFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Server
		this.login = config.getBoolean("Server.remove-login-msg");
		this.logout = config.getBoolean("Server.remove-logout-msg");
		this.death = config.getBoolean("Server.remove-logout-msg");
		
		//Customize - login/logout
		this.customizeloginmsg = config.getBoolean("Server.customize.login");
		this.loginmsg = config.getString("Server.customize.login.msg");
		this.customizelogoutmsg = config.getBoolean("Server.customize.logout");
		this.logoutmsg = config.getString("Server.customize.logout.msg");
		
		//Customize - death
		this.attackplayer = config.getString("Server.customize.death.attacker.Player");
		this.attackghast = config.getString("Server.customize.death.attacker.Ghast");
		this.attackpigzombie = config.getString("Server.customize.death.attacker.PigZombie");
		this.attackzombie = config.getString("Server.customize.death.attacker.Zombie");
		this.attackskeleton = config.getString("Server.customize.death.attacker.Skeleton");
		this.attackcreeper = config.getString("Server.customize.death.attacker.Creeper");
		this.attackspider = config.getString("Server.customize.death.attacker.Spider");
		this.attackslime = config.getString("Server.customize.death.attacker.Slime");
		this.attackgiant = config.getString("Server.customize.death.attacker.Giant");
		this.attackwolf = config.getString("Server.customize.death.attacker.Wolf");
		this.attackcavespider = config.getString("Server.customize.death.attacker.CaveSpider");
		this.attackenderman = config.getString("Server.customize.death.attacker.Enderman");
		this.attacksilverfish = config.getString("Server.customize.death.attacker.Silverfish");
		this.attackmagmacube = config.getString("Server.customize.death.attacker.MagmaCube");
		this.attackblaze = config.getString("Server.customize.death.attacker.Blaze");
		this.attacksnowman = config.getString("Server.customize.death.attacker.Snowman");
		this.attackenderdragon = config.getString("Server.customize.death.attacker.EnderDragon");
		
		this.environmentdrowning = config.getString("Server.customize.death.environment.Drowning");
		this.environmentcontact = config.getString("Server.customize.death.environment.Contact");
		this.environmententityexplosion = config.getString("Server.customize.death.environment.Entity_explosion");
		this.environmentblockexplosion = config.getString("Server.customize.death.environment.Block_explosion");
		this.environmentfall = config.getString("Server.customize.death.environment.Fall");
		this.environmentsuffocation = config.getString("Server.customize.death.environment.Suffocation");
		this.environmentfire = config.getString("Server.customize.death.environment.Fire");
		this.environmentfire_tick = config.getString("Server.customize.death.environment.Fire_tick");
		this.environmentlava = config.getString("Server.customize.death.environment.Lava");
		this.environmentvoid = config.getString("Server.customize.death.environment.Void");
		this.environmentlightning = config.getString("Server.customize.death.environment.Lightning");
		this.environmentstarvation = config.getString("Server.customize.death.environment.Starvation");
		this.environmentsuicide = config.getString("Server.customize.death.environment.Suicide");
	}
	
	public void cleanup() {
		configDefaults.clear();
	}
}


