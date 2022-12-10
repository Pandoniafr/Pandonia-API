package fr.pandonia.api.cosmetics.pet;

import fr.pandonia.api.cosmetics.ICosmetic;
import org.bukkit.Color;
import org.bukkit.Material;

public interface IPet extends ICosmetic {

    /**
     * Récupère la catégorie du Pet
     * @return la catégorie du Pet
     */
    String getCategory();


    /**
     * Récupère la texture de la tête (base64)
     * @return la texture de la tête (base64)
     */
    String getHeadTexture();

    /**
     * Récupère le type de plastron du Pet (Material.AIR si pas de chestplate)
     * @return le type de plastron du Pet
     */
    Material getChestplate();

    /**
     * Récupère la couleur du plastron (Pour si le plastron est en cuir)
     * @return
     */
    Color getChestplateColor();

}
