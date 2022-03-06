package me.xiaozhangup.natunology.techcore.api;

import me.xiaozhangup.natunology.techcore.items.Items;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Test {

    public static void runTest() {
        ItemHash.addGroup(new ItemStack(Material.CHEST), "test1");
        ItemHash.addGroup(new ItemStack(Material.GLASS), "test2");
        ItemHash.addGroup(new ItemStack(Material.GRASS), "test3");
        ItemHash.addItem(Items.addId(new ItemStack(Material.LAVA_BUCKET), 42), 42, "misc");
        ItemHash.addItem(Items.addId(new ItemStack(Material.TORCH), 43), 43, "test1");
        ItemHash.addItem(Items.addId(new ItemStack(Material.ACACIA_BOAT), 44), 44, "test2");
        ItemHash.addItem(Items.addId(new ItemStack(Material.EGG), 45), 45, "test3");
    }

}
