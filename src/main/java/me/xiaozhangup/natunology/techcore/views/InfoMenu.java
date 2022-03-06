package me.xiaozhangup.natunology.techcore.views;

import me.xiaozhangup.natunology.api.Message;
import me.xiaozhangup.natunology.api.NString;
import me.xiaozhangup.natunology.techcore.Datahash;
import me.xiaozhangup.natunology.techcore.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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

        inventory.setItem(4, Items.getHome());

        inventory.setItem(9, Items.itemBuilder(Material.PAPER, "&fItems", " ", "&7T: " + Datahash.items.size()));
        inventory.setItem(10, Items.itemBuilder(Material.PAPER, "&fGroup", " ", "&7T: " + Datahash.group.size()));
        inventory.setItem(11, Items.itemBuilder(Material.PAPER, "&fItemGroupD", " ", "&7T: " + Datahash.itemgroupd.size()));
        inventory.setItem(12, Items.itemBuilder(Material.PAPER, "&fGroupID", " ", "&7T: " + Datahash.groupid.size()));
        inventory.setItem(13, Items.itemBuilder(Material.PAPER, "&fLastGroup", " ", "&7T: " + Datahash.lastgroup.size()));

        inventory.setItem(17, Items.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDU2Yzk0NjE5MDMxMjMxNjhjZTY2N2VhZDdlYTU2YTUxNjEzMDk3MDQ5YmE2NDc4MzJiMzcyMmFmZmJlYjYzNiJ9fX0=", "&f服务器运行", NString.toStringlist("", "&7Bukkit " + Bukkit.getBukkitVersion(), "&7Minecraft " + Bukkit.getMinecraftVersion(), "&7Version " + Bukkit.getVersion())));

        p.openInventory(inventory);

    }
}
