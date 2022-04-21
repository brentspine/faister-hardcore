package de.brentspine.faisterhardcore.listeners;

import de.brentspine.faisterhardcore.Faisterhardcore;
import de.brentspine.faisterhardcore.utils.Dice;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PlayerEatListener implements Listener {

    private Faisterhardcore plugin;
    private static HashMap<UUID, PotionEffectType> potionEffects = new HashMap<>();
    private static ArrayList<PotionEffectType> allowedEffectTypes = new ArrayList<>();

    public PlayerEatListener(Faisterhardcore plugin) {
        this.plugin = plugin;
        run();
    }

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event) {
        if(!event.getItem().getType().isEdible()) return;
        addRandomPotionEffect(event.getPlayer());
    }

    public static void run() {
        if(allowedEffectTypes.size() > 0) return;
        for(PotionEffectType potionEffectType : PotionEffectType.values())
            allowedEffectTypes.add(potionEffectType);
        allowedEffectTypes.remove(PotionEffectType.HARM);
        allowedEffectTypes.remove(PotionEffectType.WITHER);
    }

    public static PotionEffectType addRandomPotionEffect(Player player) {
        if(potionEffects.containsKey(player.getUniqueId())) {
            for(PotionEffect current : player.getActivePotionEffects()) {
                if(potionEffects.get(player.getUniqueId()) == current.getType()) {
                    PotionEffect potionEffect = player.getPotionEffect(potionEffects.get(player.getUniqueId()));
                    PotionEffect newPotionEffect = new PotionEffect(potionEffect.getType(), potionEffect.getDuration() + (10 * 20), potionEffect.getAmplifier() + 1, false, true, true);
                    newPotionEffect.apply(player);
                    return newPotionEffect.getType();
                }
            }
            potionEffects.remove(player.getUniqueId());
        }
        PotionEffect potionEffect = new PotionEffect(allowedEffectTypes.get(Dice.generateNumberBetween(0, allowedEffectTypes.size() - 1)), 10*20, 0, false, true, true);
        potionEffect.apply(player);
        potionEffects.put(player.getUniqueId(), potionEffect.getType());
        return potionEffect.getType();
    }

}
