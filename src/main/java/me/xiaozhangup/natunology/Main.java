package me.xiaozhangup.natunology;

import me.xiaozhangup.natunology.event.BlockHolo;
import me.xiaozhangup.natunology.event.Invkeep;
import me.xiaozhangup.natunology.event.MovePart;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        getLogger().info(" ");

        plugin = this;

        saveDefaultConfig();
        reloadConfig();

        if (getConfig().getBoolean("Step.enable")) {
            MovePart.runStep();
            Bukkit.getPluginManager().registerEvents(new MovePart() , this);
            getLogger().info("Step Loaded!");
        }

//        if (getConfig().getBoolean("Dead.enable")) {
//            Bukkit.getPluginManager().registerEvents(new Invkeep() , this);
//            getLogger().info("DeadKeep Loaded!");
//        }
//
//        if (getConfig().getBoolean("Holo.enable")) {
//            Bukkit.getPluginManager().registerEvents(new BlockHolo() , this);
//            getLogger().info("Holo Loaded!");
//        }

        getLogger().info(this + " Loaded!");
        getLogger().info(Bukkit.getBukkitVersion());
        getLogger().info(" ");


    }
}
