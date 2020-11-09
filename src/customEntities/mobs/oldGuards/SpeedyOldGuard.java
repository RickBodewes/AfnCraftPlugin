package customEntities.mobs.oldGuards;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R2.ChatComponentText;
import net.minecraft.server.v1_16_R2.EntityHuman;
import net.minecraft.server.v1_16_R2.EntitySkeleton;
import net.minecraft.server.v1_16_R2.EntityTypes;
import net.minecraft.server.v1_16_R2.GenericAttributes;
import net.minecraft.server.v1_16_R2.IChatBaseComponent;
import net.minecraft.server.v1_16_R2.PathfinderGoalNearestAttackableTarget;

public class SpeedyOldGuard extends EntitySkeleton{
	public SpeedyOldGuard(Location loc) {
		super(EntityTypes.SKELETON, ((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		//setting params
		this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(6.0f);
		this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(.50);
		
		//setting the custom name
		this.setCustomNameVisible(true);
		this.setCustomName(new ChatComponentText(ChatColor.DARK_RED + "Speedy Old Guard " + ChatColor.GRAY + (int)this.getMaxHealth() + "/" + (int)this.getMaxHealth()));
		
		//always prio human target
		this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, false));
	}
	
	@Override
	public boolean isFireProof() {
		return true;
	}

	public IChatBaseComponent getCustomName() {
		return new ChatComponentText("Speedy Old Guard");
	}
}
