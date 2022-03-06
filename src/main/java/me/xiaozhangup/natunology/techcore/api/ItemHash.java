package me.xiaozhangup.natunology.techcore.api;

import me.xiaozhangup.natunology.techcore.Datahash;
import org.bukkit.inventory.ItemStack;

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
