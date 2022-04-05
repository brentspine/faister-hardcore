package de.brentspine.faisterhardcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class MaxHealthCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cNicht in der Konsole verfügbar");
            return true;
        }
        Player player = (Player) sender;
        if(args.length == 0) {
            player.sendMessage("§cVerwendung: /maxhealth <amount> [Player]");
            return true;
        }
        Player target = player;
        if(args.length >= 2) {
            boolean foundPlayer = false;
            for(Player current : Bukkit.getOnlinePlayers()) {
                if(current.getName().equalsIgnoreCase(args[1]) || current.getUniqueId().equals(args[1])) {
                    target = current;
                    foundPlayer = true;
                }
            }
            if(!foundPlayer) {
                player.sendMessage("§cSpieler nicht gefunden");
                return true;
            }
        }
        float health;
        try {
            health = Float.valueOf(args[0]);
        } catch (NumberFormatException e) {
            player.sendMessage("§c\"" + args[0] + "\" scheint keine Zahl zu sein");
            return true;
        }
        player.sendMessage("§aDie maximalen Leben von §6" + target.getName() + "§a wurden von §6" + target.getMaxHealth() + "§a auf §6" + health + "§a gesetzt");
        Double oldMaxHealth = target.getMaxHealth(); // 20
        target.setMaxHealth(health); // 5
        player.sendMessage("" + (target.getHealth() + health - oldMaxHealth));
        if(target.getHealth() + health - oldMaxHealth > 0)
            if(target.getHealth() + health - oldMaxHealth <= 2048.0)
                target.setHealth(target.getHealth() + health - oldMaxHealth); // 20 + 5 - 20
            else
                target.setHealth(2048.0);
        return false;
    }

}
