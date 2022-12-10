package fr.pandonia.api.sanction.infos.loader;

import fr.pandonia.api.sanction.infos.ISanctionCategory;
import fr.pandonia.api.sanction.infos.ISanctionItem;

import java.util.List;

public interface ISanctionsInfosLoader {

    /**
     * Met en cache les SanctionItem et les SanctionCategory
     */
    void load();

    /**
     * Récupère une catégorie de sanctions
     * @param name nom de la catégorie à chercher
     * @return SanctionCategory trouvé (ou null)
     */
    ISanctionCategory getSanctionCategory(String name);

    /**
     * Récupère la liste des catégories de sanction
     */
    List<ISanctionCategory> getSanctionCategories();

    /**
     * Récupère un type de sanction
     * @param name nom du type de sanction à chercher
     * @return SanctionItem trouvé (ou null)
     */
    ISanctionItem getSanctionItem(String name);

    /**
     * Récupère un type de sanction
     * @param id id du type de sanction à chercher
     * @return SanctionItem trouvé (ou null)
     */
    ISanctionItem getSanctionItem(int id);

    /**
     * Récupère la liste des types de sanctions appartenant à une catégorie
     * @param categoryName nom de la catégorie
     * @return liste des types de sanctions trouvés
     */
    List<ISanctionItem> getSanctionItemsInCategory(String categoryName);

    /**
     * Récupère la liste des types de sanctions
     * @return la liste des types de sanctions
     */
    List<ISanctionItem> getSanctionItems();

}
