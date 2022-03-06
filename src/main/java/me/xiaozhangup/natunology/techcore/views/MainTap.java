package me.xiaozhangup.natunology.techcore.views;

import me.xiaozhangup.natunology.api.Message;
import me.xiaozhangup.natunology.api.NString;
import me.xiaozhangup.natunology.techcore.Datahash;
import me.xiaozhangup.natunology.techcore.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainTap {

    public static int i = 9;

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

        int i = 9;
        for (ItemStack itemStack : Datahash.group) {
            inventory.setItem(i, itemStack);
            i++;
        }

        ItemStack misc = Items.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzgzZTc4NTM5YWU3NmJhNmExYWFlYmY3YjFlNzU4OTllNjgzOTg5NTYzYTk3YTljZGZhZjhhYmZkZTM0ZjNhMSJ9fX0=");
        ItemMeta miscItemMeta = misc.getItemMeta();
        miscItemMeta.setDisplayName(Message.color("&7杂七杂八"));
        miscItemMeta.setLore(NString.toStringlist("", "&7查看杂物类"));
        miscItemMeta.setCustomModelData(5);
        misc.setItemMeta(miscItemMeta);
        inventory.setItem(i, misc);

        inventory.setItem(44, info);

        p.openInventory(inventory);

    }

    public static void openGroup(Player p, String s) {
        Inventory inventory = Bukkit.createInventory(new Menukey(), 54, Message.color("&8&lNatunology 指导书"));

        for (int i = 0; i <= 8; i++) {
            inventory.setItem(i, Items.board());
        }
        for (int i = 45; i <= 53; i++) {
            inventory.setItem(i, Items.board());
        }

        inventory.setItem(4, Items.getHome());

        i = 9;
        Datahash.items.forEach((item, group) -> {
            if (Datahash.itemgroupd.get(item).equals(s)) {
                inventory.setItem(i, group);
                i++;
            }
        });

        p.openInventory(inventory);

    }

    public static void openCraft(Player p, Integer id) {
        try {
            Inventory inventory = Bukkit.createInventory(new Menukey(), 45, Message.color("&8&lNatunology 制作方法"));

            for (int i = 0; i <= 8; i++) {
                inventory.setItem(i, Items.board());
            }
            for (int i = 36; i <= 44; i++) {
                inventory.setItem(i, Items.board());
            }

            inventory.setItem(4, Items.getHome());
            inventory.setItem(0, Items.getBack());

            inventory.setItem(19, Datahash.items.get(id));

            //todo callevent

            p.openInventory(inventory);
        } catch (Exception ignored) {
        }
    }
}
