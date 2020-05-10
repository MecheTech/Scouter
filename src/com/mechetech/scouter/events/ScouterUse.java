/**
 * 
 */
package com.mechetech.scouter.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Listens for the use of the scouter
 * @author Zachary Jones
 *
 */
public class ScouterUse implements Listener {
	
	@EventHandler
	public void useScouter(PlayerInteractEvent event) {
		if (event.getItem().getType() == Material.STICK && 
				event.getItem().getItemMeta().getDisplayName().contains("Scouter")) {
			int range = 250;
			if (event.getItem().getItemMeta().isUnbreakable()) {
				range = 2000;
			}
			
			Player user = event.getPlayer();
			
			List<Player> players = new ArrayList<Player>(user.getWorld().getPlayers());
			List<Player> north = new ArrayList<Player>();
			List<Player> east = new ArrayList<Player>();
			List<Player> south = new ArrayList<Player>();
			List<Player> west = new ArrayList<Player>();
			
			for (Player p : players) {
				double distance = user.getLocation().distanceSquared(p.getLocation());
				if (distance <= range * range) {
					Location diff = user.getLocation().subtract(p.getLocation());
					diff = new Location(user.getWorld(), diff.getX(), 0, diff.getZ());
					Location unitX = new Location(user.getWorld(), 1, 0, 0);
					Location unitY = new Location(user.getWorld(), 0, 0, 1);
					double angleX = unitX.toVector().angle(diff.toVector());
					double angleY = unitY.toVector().angle(diff.toVector());
					if (angleX < Math.PI/4) {
						east.add(p);
					} else if (angleX >= 3*Math.PI/4) {
						west.add(p);
					} else if (angleY < Math.PI/4) {
						north.add(p);
					} else if (angleY > 3*Math.PI/4) {
						south.add(p);
					}
				}
			}
			
			user.sendMessage("You detect " + north.size() + " North from here, " +
					east.size() + " East of here, " + south.size() + " South of here, " +
					west.size() + " West of here.");
			
			
			ItemMeta meta = event.getItem().getItemMeta();
			if (!meta.isUnbreakable()) {
				event.getPlayer().getInventory().removeItem(event.getItem());
			}
		}
	}
}
