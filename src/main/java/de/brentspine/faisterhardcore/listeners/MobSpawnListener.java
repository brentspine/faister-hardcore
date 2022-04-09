package de.brentspine.faisterhardcore.listeners;

import de.brentspine.faisterhardcore.Faisterhardcore;
import de.brentspine.faisterhardcore.utils.Dice;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

public class MobSpawnListener implements Listener {

    private Faisterhardcore plugin;
    private final ArrayList<EntityType> blockedEntityTypes;

    public MobSpawnListener(Faisterhardcore plugin) {
        this.plugin = plugin;
        blockedEntityTypes = new ArrayList<>();
        blockedEntityTypes.add(EntityType.ENDER_DRAGON);
        blockedEntityTypes.add(EntityType.WITHER);
        blockedEntityTypes.add(EntityType.VEX);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onMobSpawn(EntitySpawnEvent event) {
        event.getEntity().setCustomNameVisible(true);

        if(!(event.getEntity() instanceof LivingEntity))
            return;
        if(event.getEntity().getType() == EntityType.ENDER_DRAGON )
            return;
        LivingEntity entity = (LivingEntity) event.getEntity();

        Dice random = new Dice(1, 10);
        int level = 1;
        while (random.nextResult() == 10 || level >= 5) {
            level++;
        }
        modifyMobByLevel(entity, level);
    }

    public static String modifyMobByLevel(LivingEntity entity, int level) {
        for (int i = 0; i < level; i++) {
            entity.setMaxHealth(entity.getMaxHealth() * 1.50);
            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, false, false));
        }
        if(level > 0)
            entity.setCustomName(entity.getName() + " [LvL " + level + "]");
        if(level >= 4) {
            for(Player current : Bukkit.getOnlinePlayers()) {
                current.sendMessage("§4§lWARNUNG §r§cEs ist ein §6" + entity.getName() + "§c gespawnt");
            }
        }
        if(level > 0)
            entity.setCustomName(getLevelColor(level) + entity.getName());
        return entity.getCustomName();
    }

    public static String getLevelColor(int level) {
        switch (level) {
            case 0:
                return "§f";
            case 1:
                return "§a";
            case 2:
                return "§e";
            case 3:
                return "§6";
            case 4:
                return "§c";
            case 5:
                return "§4";
            case 6:
            default:
                return "§4§l";
        }
    }

}
