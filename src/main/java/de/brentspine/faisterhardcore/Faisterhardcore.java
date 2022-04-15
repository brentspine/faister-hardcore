package de.brentspine.faisterhardcore;

import de.brentspine.faisterhardcore.commands.MaxHealthCommand;
import de.brentspine.faisterhardcore.commands.SummonMobBossCommand;
import de.brentspine.faisterhardcore.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Faisterhardcore extends JavaPlugin {

    public static Faisterhardcore instance;

    private PlayerMoveListener playerMoveListener;
    private MobSpawnListener mobSpawnListener;

    @Override
    public void onEnable() {
        this.instance = this;
        playerMoveListener = new PlayerMoveListener(this);
        mobSpawnListener = new MobSpawnListener(this);
        register(Bukkit.getPluginManager());
    }

    public void register(PluginManager pluginManager) {
        pluginManager.registerEvents(new ArmorEquipListener(this), this);
        pluginManager.registerEvents(mobSpawnListener,this);
        pluginManager.registerEvents(playerMoveListener, this);
        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        pluginManager.registerEvents(new EntityExplosionListener(this), this);
        getCommand("maxhealth").setExecutor(new MaxHealthCommand());
        getCommand("summonbossmob").setExecutor(new SummonMobBossCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public PlayerMoveListener getPlayerMoveListener() {
        return playerMoveListener;
    }

    public MobSpawnListener getMobSpawnListener() {
        return mobSpawnListener;
    }

}
