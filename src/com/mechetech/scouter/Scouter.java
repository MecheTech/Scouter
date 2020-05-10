package com.mechetech.scouter;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.mechetech.scouter.commands.GrantScouter;

/**
 * 
 * @author Zachary Jones
 *
 */
public class Scouter extends JavaPlugin {
	
	@Override
	public void onEnable() {
		super.onEnable();
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		getCommand("grantscouter").setExecutor(new GrantScouter());
		
		logger.info(pdfFile.getName() + " has been enabled (V." + 
				pdfFile.getVersion() + ")");
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + " has been disabled (V." + 
				pdfFile.getVersion() + ")");
	}
	
}
