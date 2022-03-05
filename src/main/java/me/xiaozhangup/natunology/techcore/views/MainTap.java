package me.xiaozhangup.natunology.techcore.views;

import me.xiaozhangup.natunology.api.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MainTap implements Listener {

    public static void openMainTap(Player p) {
        Inventory inventory = Bukkit.createInventory(new Menukey() , 54 , Message.color("&8&lNatunology 指导书"));
        p.openInventory(inventory);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        Player player = (Player) e.getWhoClicked();
        InventoryHolder holder = player.getOpenInventory().getTopInventory().getHolder();
        if(holder instanceof Menukey) {
            e.setCancelled(true);
        }
    }
}
