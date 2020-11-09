package items.weapons.wands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WitherRodItem {
	public static ItemStack witherRod;
	
	public static void init() {
		createWitherRod();
	}
	
	//wither rod creation
	private static void createWitherRod() {
		ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§5§kAAA §r§5Wither Rod §kAAA");
		List<String> lore = new ArrayList<>();
		lore.add("§9Wither Rod, left click to get real angry!");
		lore.add("");
		lore.add("§7Cooldown: 10s");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		witherRod = item;
		
		//creating the recipe
		//NOTE: recipe disabled untill planned what happens with this item
// 		ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("wither_rod"), item);
//		recipe.shape("N  ",
//					 " S ",
//					 "  S");
//		recipe.setIngredient('N', Material.NETHER_STAR);
//		recipe.setIngredient('S', Material.STICK);
//		Bukkit.getServer().addRecipe(recipe);
	}
}
