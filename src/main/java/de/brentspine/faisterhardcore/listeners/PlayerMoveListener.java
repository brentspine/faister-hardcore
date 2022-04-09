package de.brentspine.faisterhardcore.listeners;

import de.brentspine.faisterhardcore.Faisterhardcore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerMoveListener implements Listener {

    private Faisterhardcore plugin;
    Team hideNameTags;

    public PlayerMoveListener(Faisterhardcore plugin) {
        this.plugin = plugin;
        hideNameTags = plugin.getServer().getScoreboardManager().getNewScoreboard().registerNewTeam("hideNameTags");
        hideNameTags.setCanSeeFriendlyInvisibles(false);
        hideNameTags.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        /*for(Entity entity : event.getPlayer().getNearbyEntities(50, 20, 50)) {
            hideNameTags.addEntry(entity.getUniqueId().toString());
            event.getPlayer().sendMessage(entity.getUniqueId().toString());
        }
        for(Entity entity : event.getPlayer().getNearbyEntities(10, 2, 10)) {
            hideNameTags.removeEntry(entity.getUniqueId().toString());
            event.getPlayer().sendMessage(entity.getUniqueId().toString());
        }*/
    }

    public Team getHideNameTags() {
        return hideNameTags;
    }

}
