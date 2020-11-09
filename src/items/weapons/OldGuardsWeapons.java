package items.weapons;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OldGuardsWeapons {
	public static ItemStack oldGuardSword;
	public static ItemStack oldGuardBow;
	public static ItemStack oldGuardShield;
	
	public static void init() {
		createOldGuardSword();
		createOldGuardBow();
		createOldGuardShield();
	}
	
	private static void createOldGuardSword() {
		ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<>();

		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 6, Operation.ADD_NUMBER, EquipmentSlot.HAND));
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 1.7, Operation.ADD_NUMBER, EquipmentSlot.HAND));
		
		meta.setDisplayName("§aOld Guards Sword");
		lore.add("§5The sword used by the old guards.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		meta.addEnchant(Enchantment.DURABILITY, 4, true);
		item.setItemMeta(meta);
		oldGuardSword = item;
	}
	
	private static void createOldGuardBow() {
		ItemStack item = new ItemStack(Material.BOW, 1);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<>();		
		meta.setDisplayName("§aOld Guards Bow");
		lore.add("§5The bow used by the old guards.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
		meta.addEnchant(Enchantment.DURABILITY, 4, true);
		item.setItemMeta(meta);
		oldGuardBow = item;
	}
	
	private static void createOldGuardShield() {
		ItemStack item = new ItemStack(Material.SHIELD, 1);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<>();		
		meta.setDisplayName("§aOld Guards Shield");
		lore.add("§5The shield used by the old guards.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY, 4, true);
		item.setItemMeta(meta);
		oldGuardShield = item;
	}
}
