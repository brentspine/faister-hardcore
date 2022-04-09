package de.brentspine.faisterhardcore;

import de.brentspine.faisterhardcore.commands.MaxHealthCommand;
import de.brentspine.faisterhardcore.listeners.ArmorEquipListener;
import de.brentspine.faisterhardcore.listeners.MobSpawnListener;
import de.brentspine.faisterhardcore.listeners.PlayerJoinListener;
import de.brentspine.faisterhardcore.listeners.PlayerMoveListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Faisterhardcore extends JavaPlugin {

    public static Faisterhardcore instance;

    private PlayerMoveListener playerMoveListener;

    @Override
    public void onEnable() {
        this.instance = this;
        playerMoveListener = new PlayerMoveListener(this);
        register(Bukkit.getPluginManager());
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage("§aHallo Welt");
        }
    }

    public void register(PluginManager pluginManager) {
        pluginManager.registerEvents(new ArmorEquipListener(this), this);
        pluginManager.registerEvents(new MobSpawnListener(),this);
        pluginManager.registerEvents(playerMoveListener, this);
        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        getCommand("maxhealth").setExecutor(new MaxHealthCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public PlayerMoveListener getPlayerMoveListener() {
        return playerMoveListener;
    }

}
