package me.xiaozhangup.natunology.event;

import me.xiaozhangup.natunology.Main;
import me.xiaozhangup.natunology.api.Message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormat implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (e.isCancelled()) return;
        e.setFormat(Main.plugin.getConfig().getString("ChatFormat").replace("&" , Message.getCode()).replace("{MESSAGE}" , e.getMessage()));
    }

}
