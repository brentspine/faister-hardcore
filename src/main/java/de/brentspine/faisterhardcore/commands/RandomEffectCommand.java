package de.brentspine.faisterhardcore.commands;

import de.brentspine.faisterhardcore.listeners.PlayerEatListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomEffectCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            return false;
        Player player = (Player) sender;
        player.sendMessage("§aDir wurde §6" + PlayerEatListener.addRandomPotionEffect(player) + "§a als Random Effekt gegeben");
        return false;
    }

}
