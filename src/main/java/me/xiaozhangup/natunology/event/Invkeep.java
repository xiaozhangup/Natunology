package me.xiaozhangup.natunology.event;

import com.sun.org.apache.xerces.internal.xs.StringList;
import me.xiaozhangup.natunology.api.Message;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Invkeep implements Listener {

    HashMap<Player, Location> deathlocation = new HashMap<>();
    private Inventory inv;

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        e.setKeepInventory(true);
        e.setKeepLevel(true);
        deathlocation.put(e.getPlayer() , e.getPlayer().getLocation());
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player p =e.getPlayer();
        Location location = deathlocation.get(p);
        location.setY(location.getY() - 1D);
        if (location.getBlock().isLiquid() || location.getBlock().isEmpty()) {
            p.sendTitle("" , Message.color("&c死亡地点不安全,不能带回!") , 0 , 20 , 0);
        } else {
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(Message.color("&7具体坐标"));
            lore.add(Message.color("&7X: " + deathlocation.get(p).getX()));
            lore.add(Message.color("&7Y: " + deathlocation.get(p).getY()));
            lore.add(Message.color("&7Z: " + deathlocation.get(p).getZ()));
            lore.add(Message.color("&7世界: " + deathlocation.get(p).getWorld().getName()));
            Inventory inv = Bukkit.createInventory(new respawngui(), 27, Message.color("回到死亡点 或按下Esc退出选择"));
            ItemStack itemStack = new ItemStack(Material.RESPAWN_ANCHOR);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(Message.color("&c回到死亡地点"));
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
            inv.setItem(12 , itemStack);
            p.openInventory(inv);
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player))
            return;
        Player player = (Player) e.getWhoClicked();
        InventoryHolder holder = player.getOpenInventory().getTopInventory().getHolder();
        if(holder instanceof respawngui) {
            e.getClickedInventory().close();
            e.getWhoClicked().teleport(deathlocation.get(e.getWhoClicked()));
            ((Player) e.getWhoClicked()).sendTitle("" , Message.color("&e已送回!") , 0 , 10 , 0);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        deathlocation.remove(e.getPlayer());
    }

    class respawngui implements InventoryHolder {// 定义一个Holder用于识别此插件的GUI
        @Override
        public Inventory getInventory() {
            return inv;
        }
    }
}
