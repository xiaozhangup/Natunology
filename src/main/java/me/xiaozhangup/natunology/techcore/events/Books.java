package me.xiaozhangup.natunology.techcore.events;

import me.xiaozhangup.natunology.api.Message;
import me.xiaozhangup.natunology.techcore.views.MainTap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Books implements Listener {

    @EventHandler
    public void onItemClick(PlayerInteractEvent e) {
        if (e.getItem() != null &&
                e.getItem().hasItemMeta() &&
                e.getItem().getItemMeta().hasCustomModelData() &&
                e.getItem().getItemMeta().getCustomModelData() == 1) {
            Player p = e.getPlayer();
            e.setCancelled(true);
            MainTap.openMainTap(p);
        }
    }
}
