package fr.pandonia.api.cosmetics.pet;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public interface IPetArmorStand {

    /**
     * Met à jour la position du pet
     */
    void update();

    /**
     * Supprime l'entité
     */
    void remove();

    /**
     * Récupère le {@link IPet}
     * @return le {@link IPet}
     */
    IPet getPet();

    /**
     * Récupère le Bukkit Player a qui est lié le PetArmorStand
     * @return
     */
    Player getPlayer();

    /**
     * Récupère l'entité (ArmorStand)
     * @return l'entité
     */
    ArmorStand getArmorStand();

}

