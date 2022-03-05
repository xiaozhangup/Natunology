package me.xiaozhangup.natunology.commands;

import me.xiaozhangup.natunology.Main;
import me.xiaozhangup.natunology.api.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Commands {

    public static void regCommands() {
        Bukkit.getPluginCommand("natunology").setExecutor((commandSender, command, s, inside) -> {
            Player p = (Player) commandSender;
            try {
                if (inside[0].equals("version")) {
                    Message.send(p , " ",
                            " &7&lNatunology HAPPYLAND" ,
                            " &f运行时版本: &7" + Bukkit.getPluginManager().getPlugin("Natunology").getDescription().getVersion() ,
                            " &f详细信息: &7" + Bukkit.getPluginManager().getPlugin("Natunology").getDescription().toString(),
                            " &c&l开放源代码 &7https://github.com/xiaozhangup/Natunology",
                            " ");
                } else if (inside[0].equals("help")) {
                    Message.send(p , " ",
                            " &f&lNatunology 命令帮助",
                            " &7Code By HAPPYLAND Team",
                            " ",
                            " &7/ntg help - 显示本页面",
                            " &7/ntg version - 显示版本信息",
                            " &7/ntg guide - 打开指导页面",
                            " &7/ntg book - 获取指导书本",
                            " ");
                }
            } catch (Exception e) {
                Message.send(p , "&f[&7科技&f] 执行命令时遇到错误! 内容: &c" + e.getMessage());
            }
            return false;
        });
    }
}
