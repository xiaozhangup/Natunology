package me.xiaozhangup.natunology.techcore.views;

import me.xiaozhangup.natunology.api.Message;
import me.xiaozhangup.natunology.techcore.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InfoMenu {

    public static void openInfoMenu(Player p) {
        Inventory inventory = Bukkit.createInventory(new Menukey(), InventoryType.CHEST, Message.color("&8&lNatunology 关于页"));

        for (int i = 0; i <= 8; i++) {
            inventory.setItem(i, Items.board());
        }
        for (int i = 18; i <= 26; i++) {
            inventory.setItem(i, Items.board());
        }

        inventory.setItem(4 , Items.getHome());

        p.openInventory(inventory);

    }
}
