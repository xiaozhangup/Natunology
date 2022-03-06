package me.xiaozhangup.natunology.techcore;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Datahash {

    public static HashMap<Integer, ItemStack> items = new HashMap<>();
    public static List<ItemStack> group = new ArrayList<>();
    public static HashMap<Integer, String> itemgroupd = new HashMap<>();
    public static HashMap<ItemStack, String> groupid = new HashMap<>();

    public static HashMap<Player, String> lastgroup = new HashMap<>();

    public static HashMap<Integer, List<ItemStack>> crafttable = new HashMap<>();

}
