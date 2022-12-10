package fr.pandonia.api.battlepass;

import org.bukkit.inventory.ItemStack;

public interface IBPChallenge {

    /**
     * Récupère l'id du challenge
     * @return l'id du challenge
     */
    int getId();

    /**
     * Récupère le nom du challenge
     * @return le nom du challenge
     */
    String getName();

    /**
     * Récupère le mode de jeu dans lequel le défi doit être réalisé
     * @return le mode de jeu
     */
    String getMode();

    /**
     * Récupère l'expérience gagnée lors que la réalisation du défi
     * @return l'expérience gagnée lors que la réalisation du défi
     */
    int getGain();

    /**
     * Récupère l'item représentant le défi
     * @return l'item représentant le défi
     */
    ItemStack getItem();

}

