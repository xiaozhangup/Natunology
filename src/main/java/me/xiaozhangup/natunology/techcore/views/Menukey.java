package me.xiaozhangup.natunology.techcore.views;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class Menukey implements InventoryHolder {

    private Inventory inv;

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
