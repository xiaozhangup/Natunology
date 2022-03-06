package me.xiaozhangup.natunology.techcore.api;

import me.xiaozhangup.natunology.techcore.Datahash;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemHash {

    public static void addGroup(ItemStack itemStack, String id) {
        Datahash.group.add(itemStack);
        Datahash.groupid.put(itemStack, id);
    }

    public static String getGroupId(ItemStack itemStack) {
        try {
            return Datahash.groupid.get(itemStack);
        } catch (Exception e) {
            return null;
        }
    }

    public static void addItem(ItemStack itemStack, Integer integer, String group) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(integer);
        itemStack.setItemMeta(itemMeta);
        Datahash.items.put(integer, itemStack);
        Datahash.itemgroupd.put(integer, group);
    }

    public static ItemStack getItem(Integer integer) {
        try {
            return Datahash.items.get(integer);
        } catch (Exception e) {
            return null;
        }
    }
}
