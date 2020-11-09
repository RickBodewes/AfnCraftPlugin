package events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import net.md_5.bungee.api.ChatColor;

public class MobHealthBars implements Listener  {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		if(entity.getCustomName() == null) return;
		LivingEntity livingEntity = (LivingEntity)entity;
		String entityName = entity.getCustomName();
		
		if((entity instanceof Skeleton)) {
			switch(entityName) {
				case "Healthy Old Guard":
					entity.setCustomName(ChatColor.DARK_RED + "Healthy Old Guard " + ChatColor.GRAY + (int)livingEntity.getHealth() + "/" + (int)livingEntity.getMaxHealth());
					break;
				case "Old Guard":
					entity.setCustomName(ChatColor.DARK_RED + "Old Guard " + ChatColor.GRAY + (int)livingEntity.getHealth() + "/" + (int)livingEntity.getMaxHealth());
					break;
				case "Speedy Old Guard":
					entity.setCustomName(ChatColor.DARK_RED + "Speedy Old Guard " + ChatColor.GRAY + (int)livingEntity.getHealth() + "/" + (int)livingEntity.getMaxHealth());
					break;
				default:
					break;
			}
		}
	}
}
