package de.brentspine.faisterhardcore.listeners;

import de.brentspine.faisterhardcore.Faisterhardcore;
import de.brentspine.faisterhardcore.utils.Dice;
import org.bukkit.Bukkit;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplosionListener implements Listener {

    private Faisterhardcore plugin;

    public EntityExplosionListener(Faisterhardcore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityExplosion(EntityExplodeEvent event) {
        int level = Faisterhardcore.instance.getMobSpawnListener().mobLevels.get(event.getEntity().getUniqueId());
        /*Dice dice = new Dice(1, 15);
        for (int i = 0; i < level - 1; i++) {
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                Creeper creeper = (Creeper) event.getLocation().getWorld().spawnEntity(event.getLocation().subtract(dice.nextResult() / 10, dice.nextResult() / 10, dice.nextResult() / 10), EntityType.CREEPER);
                creeper.explode();
            }, i * 10);
        }*/
    }

}
