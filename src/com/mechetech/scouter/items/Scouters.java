package com.mechetech.scouter.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Scouters {

	private static Material scouterMaterial = Material.STICK;
	
	public static ItemStack makeScouter() {
		ItemStack scouter = new ItemStack(scouterMaterial);
		ItemMeta meta = scouter.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "Scouter");
		
		List<String> lore = new ArrayList<>();
		lore.add("This is a scouter!");
		lore.add("Right click to discover mormoons within 250 blocks.");
		lore.add("One use. No refunds!");
		
		return scouter;
	}
	
	public static ItemStack makeGreaterScouter() {
		ItemStack scouter = new ItemStack(scouterMaterial);
		ItemMeta meta = scouter.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "Major Scouter");
		
		List<String> lore = new ArrayList<>();
		lore.add("This is a Major Scouter!");
		lore.add("Right click to discover mormoons within 2000 blocks.");
		lore.add("Many refunds!");
		
		return scouter;
	}
}
