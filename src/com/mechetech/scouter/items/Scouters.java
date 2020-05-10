package com.mechetech.scouter.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Scouters extends ItemStack {

	/** The MC material scouter uses */
	private static final Material SCOUTER_MATERIAL = Material.STICK;
	
	public Scouters () {
		super(SCOUTER_MATERIAL);
	}
	
	public class Scouter extends Scouters {
		public Scouter() {
			super();
			ItemMeta meta = getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Scouter");
			
			List<String> lore = new ArrayList<>();
			lore.add("This is a scouter!");
			lore.add("Right click to discover mormoons within 250 blocks.");
			lore.add("One use. No refunds!");
		}
	}
	
	public class MajorScouter extends Scouters {
		public MajorScouter() {
			super();
			
			ItemMeta meta = getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Major Scouter");
			
			List<String> lore = new ArrayList<>();
			lore.add("This is a Major Scouter!");
			lore.add("Right click to discover mormoons within 2000 blocks.");
			lore.add("Many refunds!");
			meta.setLore(lore);
		}
	}
	
//	public static ItemStack makeScouter() {
//		ItemStack scouter = new ItemStack(scouterMaterial);
//		ItemMeta meta = scouter.getItemMeta();
//		meta.setDisplayName(ChatColor.GRAY + "Scouter");
//		
//		List<String> lore = new ArrayList<>();
//		lore.add("This is a scouter!");
//		lore.add("Right click to discover mormoons within 250 blocks.");
//		lore.add("One use. No refunds!");
//		
//		return scouter;
//	}
	
	public static ItemStack makeGreaterScouter() {
		ItemStack scouter = new ItemStack(SCOUTER_MATERIAL);
		ItemMeta meta = scouter.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "Major Scouter");
		
		List<String> lore = new ArrayList<>();
		lore.add("This is a Major Scouter!");
		lore.add("Right click to discover mormoons within 2000 blocks.");
		lore.add("Many refunds!");
		
		return scouter;
	}
}
