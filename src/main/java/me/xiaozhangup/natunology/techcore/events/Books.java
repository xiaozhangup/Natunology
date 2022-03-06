package me.xiaozhangup.natunology.techcore.events;

import me.xiaozhangup.natunology.techcore.api.ItemHash;
import me.xiaozhangup.natunology.techcore.views.InfoMenu;
import me.xiaozhangup.natunology.techcore.views.MainTap;
import me.xiaozhangup.natunology.techcore.views.Menukey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import static me.xiaozhangup.natunology.techcore.Datahash.itemgroupd;
import static me.xiaozhangup.natunology.techcore.Datahash.lastgroup;

public class Books implements Listener {

    @EventHandler
    public void onItemClick(PlayerInteractEvent e) {
        if (e.getItem() != null &&
                e.getItem().hasItemMeta() &&
                e.getItem().getItemMeta().hasCustomModelData() &&
                e.getItem().getItemMeta().getCustomModelData() == 1) {
            Player p = e.getPlayer();
            String key = lastgroup.get(p);
            e.setCancelled(true);
            if (p.isSneaking()) {
                InfoMenu.openInfoMenu(p);
                return;
            } else if (key != null) {
                if (key.startsWith("g")) {
                    MainTap.openGroup(p, key.replace("g", ""));
                    return;
                } else {
                    MainTap.openCraft(p, Integer.valueOf(key.replace("id", "")));
                    return;
                }
            }
            MainTap.openMainTap(p);
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        Player player = (Player) e.getWhoClicked();
        InventoryHolder holder = player.getOpenInventory().getTopInventory().getHolder();
        if (holder instanceof Menukey) {
            e.setCancelled(true);
            ItemStack itemStack = e.getCurrentItem();

            if (itemStack != null && itemStack.hasItemMeta() && itemStack.getItemMeta().hasCustomModelData()) {
                if (itemStack.getItemMeta().getCustomModelData() == 2) {
                    InfoMenu.openInfoMenu(player);
                } else if (itemStack.getItemMeta().getCustomModelData() == 3) {
                    MainTap.openMainTap(player);
                    lastgroup.remove(player);
                } else if (itemStack.getItemMeta().getCustomModelData() == 4) {
                    MainTap.openGroup(player, itemgroupd.get(Integer.valueOf(lastgroup.get(player).replace("id", ""))));
                    lastgroup.put(player, "g" + itemgroupd.get(Integer.valueOf(lastgroup.get(player).replace("id", ""))));
                } else if (itemStack.getItemMeta().getCustomModelData() == 5) {
                    MainTap.openGroup(player, "misc");
                    lastgroup.put(player, "gmisc");
                } else {
                    MainTap.openCraft(player, itemStack.getItemMeta().getCustomModelData());
                }
            } else if (itemStack != null) {
                if (ItemHash.getGroupId(itemStack) != null) {
                    MainTap.openGroup(player, ItemHash.getGroupId(itemStack));
                    lastgroup.put(player, "g" + ItemHash.getGroupId(itemStack));
                }
            }
        }
    }
}
