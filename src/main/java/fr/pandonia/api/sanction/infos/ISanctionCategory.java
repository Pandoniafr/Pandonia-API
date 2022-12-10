package fr.pandonia.api.sanction.infos;

import org.bukkit.Material;

public interface ISanctionCategory {

    /**
     * Récupère le nom de la catégorie de sanctions
     * @return le nom de la catégorie de sanctions
     */
    String getName();

    /**
     * Récupère le Bukkit Material qui représente la sanction
     * @return le Bukkit Material qui représente la sanction
     */
    Material getMaterial();

    /**
     * Récupère la couleur de la catégorie sous forme sous forme de dura
     * @return la couleur de la catégorie sous forme sous forme de dura
     */
    byte getGlassColor();

    /**
     * Récupère le slots dans lequel se trouve la catégorie dans l'inventaire
     * @return le slots dans lequel se trouve la catégorie dans l'inventaire
     */
    int getInvSlot();

}