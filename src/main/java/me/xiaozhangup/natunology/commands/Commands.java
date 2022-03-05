package me.xiaozhangup.natunology.commands;

import me.xiaozhangup.natunology.Main;
import me.xiaozhangup.natunology.api.Message;
import me.xiaozhangup.natunology.techcore.items.Items;
import me.xiaozhangup.natunology.techcore.views.MainTap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Commands {

    public static void regCommands() {
        Bukkit.getPluginCommand("natunology").setExecutor((commandSender, command, s, inside) -> {
            Player p = (Player) commandSender;
            try {
                if (inside[0].equals("version")) {
                    Message.send(p, " ",
                            " &7&lNatunology HAPPYLAND",
                            " &f运行时版本: &7" + Bukkit.getPluginManager().getPlugin(Main.plugin.getName()).getDescription().getVersion(),
                            " &f开发者: &7" + Bukkit.getPluginManager().getPlugin("Natunology").getDescription().getAuthors(),
                            " &f自述信息: &7" + Bukkit.getPluginManager().getPlugin("Natunology").getDescription().getDescription(),
                            " &c&l开放源代码 &7https://github.com/xiaozhangup/Natunology",
                            " ");
                } else if (inside[0].equals("help")) {
                    Message.send(p, " ",
                            " &f&lNatunology 命令帮助",
                            " &7&lCode By HAPPYLAND Team",
                            " ",
                            " &7/ntg help - 显示本页面",
                            " &7/ntg version - 显示版本信息",
                            " &7/ntg guide - 打开指导页面",
                            " &7/ntg book - 获取指导书本",
                            " &7/ntg getid - 获取手上物品可能存在的 NTGID",
                            " &7/ntg getitem <ntgid> - 通过NTGID获取物品",
                            " &7/ntg reload - &c重载配置文件(不安全)",
                            " ");
                } else if (inside[0].equals("reload")) {
                    if (p.isOp()) {
                        try {
                            Main.plugin.reloadConfig();
                            Message.send(p, "&f[&7科技&f] &a重载已完成,没有错误!");
                        } catch (Exception e) {
                            Message.send(p, "&f[&7科技&f] 重载可能已执行,但是 &c" + e.getMessage());
                        }
                    } else {
                        Message.send(p, "&f[&7科技&f] &c你没有权限执行这个命令");
                    }

                } else if (inside[0].equals("book")) {
                    p.getInventory().addItem(Items.guide());
                } else if (inside[0].equals("getid")) {
                    try {
                        Message.send(p, "&f[&7科技&f] 这个物品的NTGID是: " + p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData());
                    } catch (Exception e) {
                        Message.send(p, "&f[&7科技&f] &c这个物品没有 NTGID");
                    }
                } else if (inside[0].equals("guide")) {
                    MainTap.openMainTap(p);
                } else {
                    Message.send(p, "&f[&7科技&f] &c没有这个命令!", "&f[&7科技&f] 输入/ntg help 查看帮助");
                }
            } catch (Exception e) {
                Message.send(p, "&f[&7科技&f] 执行命令时遇到错误! 内容: &c" + e.getMessage(), "&f[&7科技&f] 输入/ntg help 查看帮助");
            }
            return false;
        });
    }
}
