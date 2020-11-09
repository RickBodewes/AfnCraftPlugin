package customEntities.mobs.oldGuards;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;

import net.minecraft.server.v1_16_R2.EntityTypes;
import net.minecraft.server.v1_16_R2.GenericAttributes;
import net.minecraft.server.v1_16_R2.IChatBaseComponent;
import net.minecraft.server.v1_16_R2.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R2.PathfinderGoalMoveTowardsTarget;
import net.minecraft.server.v1_16_R2.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R2.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R2.PathfinderGoalRandomStrollLand;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R2.ChatComponentText;
import net.minecraft.server.v1_16_R2.EntityHuman;
import net.minecraft.server.v1_16_R2.EntitySkeleton;

public class HealthyOldGuard extends EntitySkeleton {
	public HealthyOldGuard(Location loc) {
		super(EntityTypes.SKELETON, ((CraftWorld) loc.getWorld()).getHandle());
		
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		this.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(200.0f);
		
		this.setHealth(200.0f);
		
		this.getAttributeInstance(GenericAttributes.ATTACK_KNOCKBACK).setValue(25.0f);
		
		this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(6.0f);
		
		this.setCustomNameVisible(true);
		
		this.setCustomName(new ChatComponentText(ChatColor.DARK_RED + "Healthy Old Guard " + ChatColor.GRAY + (int)this.getMaxHealth() + "/" + (int)this.getMaxHealth()));
		
		this.goalSelector.a(0, new PathfinderGoalMoveTowardsTarget(this, .6, 1));
		this.goalSelector.a(1, new PathfinderGoalMeleeAttack(this, .9, true));
		this.goalSelector.a(2, new PathfinderGoalRandomStrollLand(this, .6));
		this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
		
		//always prio human target
		this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, false));
	}
	
	@Override
	public boolean isFireProof() {
		return true;
	}

	public IChatBaseComponent getCustomName() {
		return new ChatComponentText("Healthy Old Guard");
	}
}
