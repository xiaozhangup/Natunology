package me.xiaozhangup.natunology.api;

import org.bukkit.entity.Player;

public class Message {
    public static void send(Player p, String s) {
        p.sendMessage(s.replace("&", getCode()));
    }

    public static void send(Player p, String... s) {
        for (String message : s) {
            p.sendMessage(message.replace("&", getCode()));
        }
    }

    public static String getCode() {
        return "§";
    }

    public static String color(String s) {
        return s.replace("&", getCode());
    }
}
