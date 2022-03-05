package me.xiaozhangup.natunology.techcore.items;

import me.xiaozhangup.natunology.api.Message;
import me.xiaozhangup.natunology.api.NString;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class Items {

    HashMap<Integer , ItemStack> itemStackHashMap = new HashMap<>();

    public static ItemStack guide() {
        ItemStack itemStack = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(1);
        itemMeta.setDisplayName(Message.color("&7Natunology 指导书"));
        itemMeta.setLore(NString.toStringlist(" " , "&f右键单击打开书本" , "&e技术 物品 工具"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
