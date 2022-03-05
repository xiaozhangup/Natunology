package me.xiaozhangup.natunology.event;

import me.xiaozhangup.natunology.api.Holo;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockHolo implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Holo.createHoloTime(e.getBlock().getBlockData().getMaterial().toString(), e.getBlock().getLocation(), 20);
    }
}
