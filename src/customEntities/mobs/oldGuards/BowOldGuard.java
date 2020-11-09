package customEntities.mobs.oldGuards;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.inventory.CraftItemStack;

import items.armor.OldGuardArmor;
import items.weapons.OldGuardsWeapons;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R2.ChatComponentText;
import net.minecraft.server.v1_16_R2.EntityHuman;
import net.minecraft.server.v1_16_R2.EntitySkeleton;
import net.minecraft.server.v1_16_R2.EntityTypes;
import net.minecraft.server.v1_16_R2.EnumItemSlot;
import net.minecraft.server.v1_16_R2.IChatBaseComponent;
import net.minecraft.server.v1_16_R2.PathfinderGoalNearestAttackableTarget;

public class BowOldGuard extends EntitySkeleton{
	public BowOldGuard(Location loc) {
		super(EntityTypes.SKELETON, ((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		//setting equipment
		this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(OldGuardsWeapons.oldGuardBow));
		this.setSlot(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(OldGuardArmor.oldGuardHelmet));
		this.setSlot(EnumItemSlot.CHEST, CraftItemStack.asNMSCopy(OldGuardArmor.oldGuardChestplate));
		this.setSlot(EnumItemSlot.LEGS, CraftItemStack.asNMSCopy(OldGuardArmor.oldGuardLeggings));
		this.setSlot(EnumItemSlot.FEET, CraftItemStack.asNMSCopy(OldGuardArmor.oldGuardBoots));

		this.dropChanceHand[0] = .1f;
		this.dropChanceArmor[0] = .1f;
		this.dropChanceArmor[1] = .1f;
		this.dropChanceArmor[2] = .1f;
		this.dropChanceArmor[3] = .1f;
		
		//setting the custom name
		this.setCustomNameVisible(true);
		this.setCustomName(new ChatComponentText(ChatColor.DARK_RED + "Old Guard " + ChatColor.GRAY + (int)this.getMaxHealth() + "/" + (int)this.getMaxHealth()));
		
		//always prio human target
		this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, false));
	}

	public IChatBaseComponent getCustomName() {
		return new ChatComponentText("Old Guard");
	}
}
