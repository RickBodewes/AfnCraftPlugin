package items;

import items.armor.ArmorManager;
import items.weapons.WeaponsManager;

public class ItemManager {
	public static void init() {
		WeaponsManager.init();
		ArmorManager.init();
	}
}
