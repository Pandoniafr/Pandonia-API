package fr.pandonia.api.cosmetics;

public interface ICosmetic {

    /**
     * Récupère l'ID du Cosmetic
     * @return
     */
    int getID();

    /**
     * Récupère le type de Cosmetic (pour le stockage en base de donnée)
     * @return le type de Cosmetic
     */
    CosmeticType getType();

    /**
     * Récupère le nom du Cosmetic
     * @return le nom du Cosmetic
     */
    String getName();

    /**
     * Récupère le prix du cosmetic (-1 si non achetable)
     * @return le prix du cosmetic
     */
    int getPrice();

    /**
     * Récupère le power nécéssaire pour pouvoir acheter le cosmetic
     * @return le power nécéssaire pour pouvoir acheter le cosmetic
     */
    int getPowerRequired();

    /**
     * Récupère le texte expliquant comment obtenir le cosmetic
     * @return le texte expliquant comment obtenir le cosmetic
     */
    String getHowToGetIt();
}
