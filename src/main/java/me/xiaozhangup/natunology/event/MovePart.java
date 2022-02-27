package me.xiaozhangup.natunology.event;

import me.xiaozhangup.natunology.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.ItemStack;

public class MovePart implements Listener {

    public static void runStep() {
        Bukkit.getScheduler().runTaskTimer(Main.plugin , () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                Location location = p.getLocation();
                location.setY(location.getY() - 1D);
                if (location.getBlock().isEmpty() || location.getBlock().isLiquid() || p.isJumping()) {
                    return;
                }
                if (p.getTargetBlock(3).getLocation().equals(location.getBlock().getLocation())) {
                    return;
                }
                location.setY(p.getLocation().toBlockLocation().getY() - Main.plugin.getConfig().getDouble("Step.size"));
                ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location , EntityType.ARMOR_STAND);
                armorStand.setVisible(false);
                armorStand.setSmall(true);
                armorStand.setCanMove(false);
                armorStand.setNoDamageTicks(100);
                armorStand.setCanPickupItems(false);
                armorStand.setHelmet(new ItemStack(location.getBlock().getBlockData().getMaterial()));

                Bukkit.getScheduler().runTaskLater(Main.plugin , () -> {
                    armorStand.remove();
                } , 50L);
            }
        } , 1L , 16L);
    }

    @EventHandler
    public void onPlayerClickStep(PlayerArmorStandManipulateEvent e) {
        if (e.getRightClicked().isSmall() && !e.getRightClicked().getCanPickupItems()) {
            e.setCancelled(true);
            e.getRightClicked().remove();
        }
    }

    @EventHandler
    public void onPlayerHitStep(EntityDamageEvent e) {
        if (e.getEntity().getType() == EntityType.ARMOR_STAND) {
            ArmorStand armorStand = (ArmorStand) e.getEntity();
            if (armorStand.isSmall() && !armorStand.getCanPickupItems() && e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                e.setCancelled(true);
                e.getEntity().remove();
            }
        }
    }
}
