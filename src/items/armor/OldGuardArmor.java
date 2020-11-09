package items.armor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OldGuardArmor {
	public static ItemStack oldGuardHelmet;
	public static ItemStack oldGuardChestplate;
	public static ItemStack oldGuardLeggings;
	public static ItemStack oldGuardBoots;
	
	public static void init() {
		createOldGuardHelmet();
		createOldGuardChestPlate();
		createOldGuardLeggings();
		createOldGuardBoots();
	}
	
	private static void createOldGuardHelmet() {
		ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§aOld Guards Helmet");
		List<String> lore = new ArrayList<>();
		lore.add("§5The helmet used by the old guards.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
		item.setItemMeta(meta);
		oldGuardHelmet = item;
	}
	
	private static void createOldGuardChestPlate() {
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§aOld Guards Chestplate");
		List<String> lore = new ArrayList<>();
		lore.add("§5The chestplate used by the old guards.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
		item.setItemMeta(meta);
		oldGuardChestplate = item;
	}
	
	private static void createOldGuardLeggings() {
		ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§aOld Guards Leggings");
		List<String> lore = new ArrayList<>();
		lore.add("§5The leggings used by the old guards.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
		item.setItemMeta(meta);
		oldGuardLeggings = item;
	}
	
	private static void createOldGuardBoots() {
		ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§aOld Guards Boots");
		List<String> lore = new ArrayList<>();
		lore.add("§5The boots used by the old guards.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
		item.setItemMeta(meta);
		oldGuardBoots = item;
	}
}
