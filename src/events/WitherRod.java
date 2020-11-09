package events;

import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import afnCraft.AfnCraft;
import items.weapons.wands.WitherRodItem;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;

public class WitherRod implements Listener {
	private static Map<UUID, Long> skullsCooldowns = new HashMap<>();
	private static int skullsCooldown = 10;
	
	@EventHandler
	public static void onRightClick(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
			if(item != null) {
				if(item.getItemMeta().equals(WitherRodItem.witherRod.getItemMeta())) {
					
					Runnable shootSkull = new Runnable() {
						public void run () {
							WitherSkull witherSkull = player.launchProjectile(WitherSkull.class);
							witherSkull.setCharged(true);
							witherSkull.setVelocity(player.getEyeLocation().getDirection().multiply(5.0f));
							witherSkull.setCustomName("explosive");
						}
					};
					
					if(((System.currentTimeMillis() - skullsCooldowns.getOrDefault(player.getUniqueId(), (long) 0)) / 1000) <= skullsCooldown) {
						player.sendMessage(ChatColor.RED + "You can't use this for another " + ((int)( skullsCooldown - ((System.currentTimeMillis() - skullsCooldowns.get(player.getUniqueId())) / 1000))) + " seconds!");
					}else{
						Bukkit.getScheduler().scheduleSyncDelayedTask(AfnCraft.getInstance(), shootSkull, 0);
						Bukkit.getScheduler().scheduleSyncDelayedTask(AfnCraft.getInstance(), shootSkull, 8);
						Bukkit.getScheduler().scheduleSyncDelayedTask(AfnCraft.getInstance(), shootSkull, 16);
						Bukkit.getScheduler().scheduleSyncDelayedTask(AfnCraft.getInstance(), shootSkull, 24);
						Bukkit.getScheduler().scheduleSyncDelayedTask(AfnCraft.getInstance(), shootSkull, 32);
						Bukkit.getScheduler().scheduleSyncDelayedTask(AfnCraft.getInstance(), shootSkull, 40);
						
						skullsCooldowns.put(player.getUniqueId(), System.currentTimeMillis());
					}
				}
			}
		}
	}
	
	//disabling block explosions
	@EventHandler
	public static void onEntityExplode(EntityExplodeEvent event) {
		if (event.getEntity() instanceof WitherSkull) {
            if(event.getEntity().getCustomName().equals("explosive")) {
            	event.setCancelled(true);
            	event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation(), 0);
            	event.getEntity().getWorld().playSound(event.getEntity().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 2.5f, 0.75f);
            }
        }
	}
}
