package fr.pandonia.api.battlepass;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface IBPItem {

    /**
     * Récupère le level de l'item
     * @return le level de l'item
     */
    int getLevel();

    /**
     * Récupère le nom de l'item
     * @return le nom de l'item
     */
    String getName();

    /**
     * Récupère l'itemstack de l'item
     * @return l'itemstack de l'item
     */
    ItemStack getItem(Player p);

    /**
     * Récupère si l'item est gratuit
     * @return true si l'item est gratuit
     */
    boolean isFree();

    /**
     * Récupère l'event lorsque que l'item est give
     * @return l'event lorsque que l'item est give
     */
    ItemGiveEventHandler getEvent();
}
