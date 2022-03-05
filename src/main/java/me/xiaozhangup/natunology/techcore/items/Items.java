package me.xiaozhangup.natunology.techcore.items;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.sun.org.apache.xerces.internal.xs.StringList;
import me.xiaozhangup.natunology.api.Message;
import me.xiaozhangup.natunology.api.NString;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Items {

    HashMap<Integer, ItemStack> itemStackHashMap = new HashMap<>();

    public static ItemStack guide() {
        ItemStack itemStack = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(1);
        itemMeta.setDisplayName(Message.color("&7Natunology 指导书"));
        itemMeta.setLore(NString.toStringlist(" ", "&f右键单击打开书本", "&e技术 物品 工具"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack board() {
        ItemStack itemStack = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(" ");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getSkull(String base64, String name, List<String> stringList) {
        ItemStack rightArrowSkull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        SkullMeta rightArrowSkullMeta = (SkullMeta) rightArrowSkull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures",
                base64));
        Field profileField = null;
        try {
            profileField = rightArrowSkullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(rightArrowSkullMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        rightArrowSkullMeta.setDisplayName(Message.color(name));
        rightArrowSkullMeta.setLore(stringList);
        rightArrowSkull.setItemMeta(rightArrowSkullMeta);
        return rightArrowSkull;
    }

    public static ItemStack getSkull(String base64, String name) {
        ItemStack rightArrowSkull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        SkullMeta rightArrowSkullMeta = (SkullMeta) rightArrowSkull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures",
                base64));
        Field profileField = null;
        try {
            profileField = rightArrowSkullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(rightArrowSkullMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        rightArrowSkullMeta.setDisplayName(Message.color(name));
        rightArrowSkull.setItemMeta(rightArrowSkullMeta);
        return rightArrowSkull;
    }

    public static ItemStack getSkull(String base64) {
        ItemStack rightArrowSkull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        SkullMeta rightArrowSkullMeta = (SkullMeta) rightArrowSkull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures",
                base64));
        Field profileField = null;
        try {
            profileField = rightArrowSkullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(rightArrowSkullMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        rightArrowSkull.setItemMeta(rightArrowSkullMeta);
        return rightArrowSkull;
    }

    public static ItemStack getHome() {
        ItemStack itemStack = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTJkN2E3NTFlYjA3MWUwOGRiYmM5NWJjNWQ5ZDY2ZTVmNTFkYzY3MTI2NDBhZDJkZmEwM2RlZmJiNjhhN2YzYSJ9fX0=" , "&f返回主页面" , NString.toStringlist(" " , "&7单击返回"));
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(3);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
