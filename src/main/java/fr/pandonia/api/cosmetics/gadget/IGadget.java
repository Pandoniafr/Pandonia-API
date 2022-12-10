package fr.pandonia.api.cosmetics.gadget;

import fr.pandonia.api.cosmetics.ICosmetic;
import org.bukkit.inventory.ItemStack;

public interface IGadget extends ICosmetic {

    /**
     * Récupère l'item du gadget
     * @return l'item du gadget
     */
    ItemStack getItem();

}