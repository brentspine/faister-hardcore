package de.brentspine.faisterhardcore.listeners;

import de.brentspine.faisterhardcore.Faisterhardcore;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Locale;

public class ArmorEquipListener implements Listener {

    public final ArrayList<Material> damagingItems = new ArrayList<>();
    private Faisterhardcore plugin;

    public ArmorEquipListener(Faisterhardcore plugin) {
        this.plugin = plugin;
        damagingItems.add(Material.LEATHER_BOOTS);
        damagingItems.add(Material.LEATHER_LEGGINGS);
        damagingItems.add(Material.LEATHER_CHESTPLATE);
        damagingItems.add(Material.LEATHER_HELMET);
        damagingItems.add(Material.CHAINMAIL_BOOTS);
        damagingItems.add(Material.CHAINMAIL_LEGGINGS);
        damagingItems.add(Material.CHAINMAIL_CHESTPLATE);
        damagingItems.add(Material.CHAINMAIL_HELMET);
        damagingItems.add(Material.GOLDEN_BOOTS);
        damagingItems.add(Material.GOLDEN_LEGGINGS);
        damagingItems.add(Material.GOLDEN_CHESTPLATE);
        damagingItems.add(Material.GOLDEN_HELMET);
        damagingItems.add(Material.IRON_BOOTS);
        damagingItems.add(Material.IRON_LEGGINGS);
        damagingItems.add(Material.IRON_CHESTPLATE);
        damagingItems.add(Material.IRON_HELMET);
        damagingItems.add(Material.DIAMOND_BOOTS);
        damagingItems.add(Material.DIAMOND_LEGGINGS);
        damagingItems.add(Material.DIAMOND_CHESTPLATE);
        damagingItems.add(Material.DIAMOND_HELMET);
        damagingItems.add(Material.NETHERITE_BOOTS);
        damagingItems.add(Material.NETHERITE_LEGGINGS);
        damagingItems.add(Material.NETHERITE_CHESTPLATE);
        damagingItems.add(Material.NETHERITE_HELMET);
    }

    @EventHandler
    public void onPlayerEquip(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        boolean clickedDamaging;

        if(player.getItemOnCursor() != null) {
            if(damagingItems.contains(player.getItemOnCursor().getType())) {
                clickedDamaging = true;
            } else
                clickedDamaging = false;
        } else
            clickedDamaging = false;

        if (event.getSlotType() == InventoryType.SlotType.ARMOR) { //Is Armor Slot
            if (clickedDamaging) {
                reduceMaxHealth(player, 2.0f);
            }
        }
        else if(event.isShiftClick()) {
            if(damagingItems.contains(event.getCurrentItem().getType())) {
                if(event.getCurrentItem().getType().name().toLowerCase(Locale.ROOT).contains("helmet") && player.getInventory().getHelmet() == null) {
                    reduceMaxHealth(player, 2.0f);
                }
                else if(event.getCurrentItem().getType().name().toLowerCase(Locale.ROOT).contains("chestplate") && player.getInventory().getChestplate() == null) {
                    reduceMaxHealth(player, 2.0f);
                }
                else if(event.getCurrentItem().getType().name().toLowerCase(Locale.ROOT).contains("leggings") && player.getInventory().getLeggings() == null) {
                    reduceMaxHealth(player, 2.0f);
                }
                else if(event.getCurrentItem().getType().name().toLowerCase(Locale.ROOT).contains("boots") && player.getInventory().getBoots() == null) {
                    reduceMaxHealth(player, 2.0f);
                }
            }
        }
    }

    @EventHandler
    public void onRightClickEquip(PlayerInteractEvent event) {
        if(event.getItem() != null) {
            Player player = event.getPlayer();
            ItemStack item = event.getItem();
            if(damagingItems.contains(item.getType())) {
                if(item.getType().name().toLowerCase(Locale.ROOT).contains("helmet") && player.getInventory().getHelmet() == null) {
                    reduceMaxHealth(player, 2.0f);
                }
                else if(item.getType().name().toLowerCase(Locale.ROOT).contains("chestplate") && player.getInventory().getChestplate() == null) {
                    reduceMaxHealth(player, 2.0f);
                }
                else if(item.getType().name().toLowerCase(Locale.ROOT).contains("leggings") && player.getInventory().getLeggings() == null) {
                    reduceMaxHealth(player, 2.0f);
                }
                else if(item.getType().name().toLowerCase(Locale.ROOT).contains("boots") && player.getInventory().getBoots() == null) {
                    reduceMaxHealth(player, 2.0f);
                }
            }
        }
    }


    public static void reduceMaxHealth(Player player, float amount) {
        if(player.getMaxHealth() - 2.0 > 0) {
            player.setMaxHealth(player.getMaxHealth() - amount);
            return;
        }
        player.setHealth(0);
    }

}
