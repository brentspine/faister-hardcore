package de.brentspine.faisterhardcore.commands;

import de.brentspine.faisterhardcore.Faisterhardcore;
import de.brentspine.faisterhardcore.listeners.MobSpawnListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Locale;

public class SummonMobBossCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Can't execute from console");
            return false;
        }
        Player player = (Player) sender;
        //      /summonbossmob <Mob> <Level>
        if(args.length < 2) {
            player.sendMessage("§cUsage: /summonbossmob <Mob> <Level>");
            return false;
        }
        String mobName = args[0];
        int level;
        try {
            level = Integer.valueOf(args[1]);
        } catch (NumberFormatException e) {
            player.sendMessage("§cSeems like \"" + args[1] + "\" is not a number");
            return false;
        }
        Entity entity;
        try {
            entity = player.getWorld().spawnEntity(player.getLocation(), EntityType.valueOf(mobName.toUpperCase()));
        } catch (IllegalArgumentException e) {
            player.sendMessage("§cUnknown EntityType \"" + mobName + "\"");
            return false;
        }
        if(entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.setCustomName(livingEntity.getType().name().substring(0, 1).toUpperCase(Locale.ROOT) + livingEntity.getType().name().toLowerCase().substring(1));
            Faisterhardcore.instance.getMobSpawnListener().blockedEntities.add(livingEntity.getUniqueId());
            MobSpawnListener.modifyMobByLevel(livingEntity, level);
            if(level < 4)
                player.sendMessage("§aSummoned " + livingEntity.getName());
        } else
            player.sendMessage("§cCan't modify " + entity.getName());
        return false;
    }

}
