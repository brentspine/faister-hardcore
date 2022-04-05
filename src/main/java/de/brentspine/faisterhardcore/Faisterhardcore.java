package de.brentspine.faisterhardcore;

import de.brentspine.faisterhardcore.commands.MaxHealthCommand;
import de.brentspine.faisterhardcore.listeners.ArmorEquipListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Faisterhardcore extends JavaPlugin {

    public static Faisterhardcore instance;

    @Override
    public void onEnable() {
        this.instance = this;
        register(Bukkit.getPluginManager());
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage("§aHallo Welt");
        }
    }

    public void register(PluginManager pluginManager) {
        pluginManager.registerEvents(new ArmorEquipListener(this), this);
        getCommand("maxhealth").setExecutor(new MaxHealthCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
