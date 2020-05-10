package com.mechetech.scouter.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.mechetech.scouter.items.Scouters;

/**
 * Command to grant a scouter
 * @author Zachary Jones
 *
 */
public class GrantScouter implements CommandExecutor {


	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, 
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command.");
			return false;
		}
		if (args.length > 2) {
			return false;
		}
		
		Player p = (Player) Bukkit.getServer().getPlayer(args[0]);
		if (p == null) {
			sender.sendMessage("The player you wish to grant a scouter is offline");
			return false;
		}
		
		ItemStack scouter;
		
		if (args.length == 2) {
			if (args[1].equalsIgnoreCase("major")) {
				scouter = Scouters.makeGreaterScouter();
			} else if (args[1].equalsIgnoreCase("scouter")) {
				scouter = Scouters.makeScouter();
			} else {
				return false;
			}
		} else {
			scouter = Scouters.makeScouter();
		}
		
		HashMap<Integer, ItemStack> unAdded = p.getInventory().addItem(scouter);
		if (unAdded.size() > 0) {
			p.getWorld().dropItem(p.getLocation(), scouter);
		}
		
		return true;
	}
}
