package fr.pandonia.api.rank;

public interface IRank {

    /**
     * Nom du grade
     * @return le nom du grade
     */
    String getName();

    /**
     * Couleur du grade
     * @return la couleur du grade
     */
    String getColor();

    /**
     * Préfixe du grade
     * @return le préfixe du grade
     */
    String getPrefix();

    /**
     * Suffixe du grade
     * @return le suffixe du grade
     */
    String getSuffix();

    /**
     * Power du grade
     * @return le power du grade
     */
    int getPower();

    /**
     * Récupère le nombre de préconfigs
     * @return le nombre de préconfigs
     */
    int getPreConfigs();

    /**
     * Récupère la valeur du boost de saphirs et d'xp
     * @return la valeur du boost de saphirs et d'xp
     */
    double getBoost();

    /**
     * Si le grade peut lancer des hosts
     * @return si le grade peut lancer des hosts
     */
    boolean isHost();

    /**
     * Si le grade est prioritaire dans les files d'attente
     * @return si le grade est prioritaire dans les files d'attente
     */
    boolean isPriority();

    /**
     * Si le grade est celui par défaut
     * @return si le grade est celui par défaut
     */
    boolean isDefault();

    /**
     * Si le grade a les permissions administrateur
     * @return si le grade a les permissions administrateur
     */
    boolean isAdmin();

    /**
     * Si le grade est staff
     * @return si le grade est staff
     */
    boolean isStaff();
}
