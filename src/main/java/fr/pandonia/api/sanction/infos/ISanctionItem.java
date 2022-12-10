package fr.pandonia.api.sanction.infos;

import org.bukkit.Material;

import java.util.List;

/**
 * Le SanctionItem est un type de sanction, il sera listé dans le panel de sanctions
 */
public interface ISanctionItem {

    /**
     * Récupère l'identifiant du SanctionItem
     * @return l'identifiant du SanctionItem
     */
    int getID();

    /**
     * Récupère le nom de la catégorie du SanctionItem
     * @return le nom de la catégorie du SanctionItem
     */
    String getCategory();

    /**
     * Récupère le nom du SanctionItem
     * @return le nom du SanctionItem
     */
    String getName();

    /**
     * Récupère le Bukkit Material qui représente le SanctionItem
     * @return
     */
    Material getMaterial();

    /**
     * Récupère le slot dans lequel se trouve le SanctionItem dans l'inventaire
     * @return le slot dans lequel se trouve le SanctionItem dans l'inventaire
     */
    int getInvSlot();

    /**
     * Récupère si le type de sanction demande un warn avant une sanction
     * @return si le type de sanction demande un warn avant une sanction
     */
    boolean isWarn();

    /**
     * Récupère les 3 niveaux de sanctions (Exemple: "ban 30j")
     * @return les 3 niveaux de sanctions
     */
    List<String> getLevels();

}
