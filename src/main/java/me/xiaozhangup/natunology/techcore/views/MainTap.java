package me.xiaozhangup.natunology.techcore.views;

import me.xiaozhangup.natunology.api.Message;
import me.xiaozhangup.natunology.api.NString;
import me.xiaozhangup.natunology.techcore.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainTap implements Listener {

    public static void openMainTap(Player p) {
        Inventory inventory = Bukkit.createInventory(new Menukey(), 54, Message.color("&8&lNatunology 指导书"));

        for (int i = 0; i <= 8; i++) {
            inventory.setItem(i, Items.board());
        }
        for (int i = 45; i <= 53; i++) {
            inventory.setItem(i, Items.board());
        }

        ItemStack info = Items.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTAzNmMwZjA0OTM2OTkxYjVhYTAyNzFjZDdmMmZmMjhkOWMzNzRiNTg2YTVkZGUxM2E1ZjRiYzU0NWU5M2UyMSJ9fX0=");
        ItemMeta meta = info.getItemMeta();
        meta.setDisplayName(Message.color("&fNatunology 相关"));
        meta.setLore(NString.toStringlist("", "&7查阅插件相关的情况"));
        meta.setCustomModelData(2);
        info.setItemMeta(meta);


        inventory.setItem(44, info);

        p.openInventory(inventory);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        Player player = (Player) e.getWhoClicked();
        InventoryHolder holder = player.getOpenInventory().getTopInventory().getHolder();
        if (holder instanceof Menukey) {
            e.setCancelled(true);
            ItemStack itemStack = e.getCurrentItem();
            if (itemStack != null && itemStack.hasItemMeta() && itemStack.getItemMeta().hasCustomModelData()) {
                if (itemStack.getItemMeta().getCustomModelData() == 2) {
                    InfoMenu.openInfoMenu(player);
                } else if (itemStack.getItemMeta().getCustomModelData() == 3) {
                    openMainTap(player);
                }
            }
        }
    }
}
