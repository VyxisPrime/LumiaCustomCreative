package flakes.lumia.src.noxpbottle;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import flakes.lumia.src.noxpbottle.Listeners.EntityListener;
import flakes.lumia.src.noxpbottle.Listeners.PotionListener;

public class Main extends JavaPlugin {
	Main plugin;

	public Logger logger = Logger.getLogger("Minecraft");
	public void onEnable(){
		logger.info(" is Enabling!");
		
		getServer().getPluginManager().registerEvents(new PotionListener(plugin), plugin);
		getServer().getPluginManager().registerEvents(new EntityListener(plugin), plugin);
		logger.info(" is Enabled!");
		logger.info(" is running version 1.0");
	}
	public void onDisable(){
		logger.info(" is Disabled!");
	}
	
}
