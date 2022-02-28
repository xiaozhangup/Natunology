package me.xiaozhangup.natunology.event;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.WorldLoadEvent;

public class Invkeep implements Listener {

    @EventHandler
    public void onWorldLoad(WorldLoadEvent e) {
        e.getWorld().setGameRule(GameRule.KEEP_INVENTORY , true);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        for (World world : Bukkit.getWorlds()) {
            world.setGameRule(GameRule.KEEP_INVENTORY , true);
        }
    }
}
