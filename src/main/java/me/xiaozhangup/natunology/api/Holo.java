package me.xiaozhangup.natunology.api;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;


public class Holo {

    public static void createHoloTime(String s , Location loc , int i) {
        loc.setX(loc.getX() + 0.5);
        loc.setZ(loc.getZ() + 0.5);
        AreaEffectCloud flag = (AreaEffectCloud) (loc.getWorld().spawnEntity(loc , EntityType.AREA_EFFECT_CLOUD));
        flag.setRadius(-10.0F);
        flag.setParticle(Particle.ASH);
        flag.setCustomName(s);
        flag.setCustomNameVisible(true);
        flag.setDuration(i);
    }
}
