package fr.pandonia.api.cosmetics.killanimation;

import fr.pandonia.api.cosmetics.ICosmetic;
import org.bukkit.inventory.ItemStack;

public interface IKillAnimation extends ICosmetic {

    /**
     * Récupère le nom de la méthode à éxécuter dans ParticlePresets
     * @return le nom de la méthode à éxécuter dans ParticlePresets
     */
    String getMethodName();

    /**
     * Récupère l'item représentant le cosmétique
     * @return l'item représentant le cosmétique
     */
    ItemStack getItem();
}
