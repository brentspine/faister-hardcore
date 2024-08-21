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
import java.util.HashMap;
import java.util.UUID;

public class MobSpawnListener implements Listener {

    private Faisterhardcore plugin;
    private final ArrayList<EntityType> blockedEntityTypes;
    public final ArrayList<UUID> blockedEntities;
    public final HashMap<UUID, Integer> mobLevels;

    public MobSpawnListener(Faisterhardcore plugin) {
        this.plugin = plugin;
        blockedEntities = new ArrayList<>();
        blockedEntityTypes = new ArrayList<>();
        mobLevels = new HashMap<>();
        blockedEntityTypes.add(EntityType.ENDER_DRAGON);
        blockedEntityTypes.add(EntityType.WITHER);
        blockedEntityTypes.add(EntityType.BAT);
        blockedEntityTypes.add(EntityType.CAT);
        blockedEntityTypes.add(EntityType.CHICKEN);
        blockedEntityTypes.add(EntityType.COD);
        blockedEntityTypes.add(EntityType.FOX);
        blockedEntityTypes.add(EntityType.COW);
        blockedEntityTypes.add(EntityType.GLOW_SQUID);
        blockedEntityTypes.add(EntityType.MUSHROOM_COW);
        blockedEntityTypes.add(EntityType.OCELOT);
        blockedEntityTypes.add(EntityType.PIG);
        blockedEntityTypes.add(EntityType.PARROT);
        blockedEntityTypes.add(EntityType.SHEEP);
        blockedEntityTypes.add(EntityType.PUFFERFISH);
        blockedEntityTypes.add(EntityType.RABBIT);
        blockedEntityTypes.add(EntityType.SALMON);
        blockedEntityTypes.add(EntityType.PARROT);
        blockedEntityTypes.add(EntityType.SQUID);
        blockedEntityTypes.add(EntityType.TROPICAL_FISH);
        blockedEntityTypes.add(EntityType.TURTLE);
        blockedEntityTypes.add(EntityType.VILLAGER);
        blockedEntityTypes.add(EntityType.WANDERING_TRADER);
        blockedEntityTypes.add(EntityType.LLAMA);
        blockedEntityTypes.add(EntityType.TRADER_LLAMA);
        blockedEntityTypes.add(EntityType.PANDA);
        blockedEntityTypes.add(EntityType.DOLPHIN);
        blockedEntityTypes.add(EntityType.BEE);
        blockedEntityTypes.add(EntityType.ARMOR_STAND);
        blockedEntityTypes.add(EntityType.MULE);
        blockedEntityTypes.add(EntityType.DONKEY);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onMobSpawn(EntitySpawnEvent event) {

        if(!(event.getEntity() instanceof LivingEntity))
            return;
        if(blockedEntityTypes.contains(event.getEntity().getType()))
            return;
        LivingEntity entity = (LivingEntity) event.getEntity();
        event.getEntity().setCustomNameVisible(true);

        Dice random = new Dice(1, 5);
        int level = 1;
        while (random.nextResult() == 5 && level < 5) {
            level++;
        }
        if(!blockedEntities.contains(event.getEntity().getUniqueId()))
            modifyMobByLevel(entity, level);
    }

    public static String modifyMobByLevel(LivingEntity entity, int level) {
        for (int i = 0; i < level - 1; i++) {
            entity.setMaxHealth(entity.getMaxHealth() * 1.50);
        }
        entity.setHealth(entity.getMaxHealth());

        if(level > 0)
            entity.setCustomName(entity.getName() + " [LvL " + level + "]");


        switch (entity.getType()) {
            case CREEPER:
                Creeper creeper = (Creeper) entity;
                creeper.setExplosionRadius((level + 3) / 2);
                if(level == 1)
                    creeper.setExplosionRadius(2);
                break;
            default:
                if(level > 1)
                    entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, level - 2, false, false));
                break;
        }

        if(level >= 4) {
            for(Player current : Bukkit.getOnlinePlayers()) {
                current.sendMessage("§4§lWARNUNG §r§cEs ist ein §6" + entity.getName() + "§c gespawnt");
            }
        }


        if(level > 0)
            entity.setCustomName(getLevelColor(level) + entity.getName());
        Faisterhardcore.instance.getMobSpawnListener().mobLevels.put(entity.getUniqueId(), level);
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
