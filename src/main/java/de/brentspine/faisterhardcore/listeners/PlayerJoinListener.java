package de.brentspine.faisterhardcore.listeners;

import de.brentspine.faisterhardcore.Faisterhardcore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private Faisterhardcore plugin;

    public PlayerJoinListener(Faisterhardcore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getPlayerMoveListener().hideNameTags.addEntry(event.getPlayer().getName());
    }

}
