package fr.pandonia.api.player.stats.uhc;

import org.bson.Document;

public interface IPlayerUHCStats {

    /**
     * Récupère le mode de jeu lié au stats actuel
     * @return le mode
     */
    String getMode();

    /**
     * Récupère le nombre de kills
     * @return le nombre de kills
     */
    int getKills();

    /**
     * Ajoute un kill
     */
    void addKill();

    /**
     * Récupère le nombre d'assistances
     * @return le nombre d'assistances
     */
    int getAssists();

    /**
     * Ajoute une assist
     */
    void addAssist();

    /**
     * Récupère le nombre de morts
     * @return le nombre de morts
     */
    int getDeaths();

    /**
     * Ajoute une mort
     */
    void addDeath();

    /**
     * Récupère le nombre de victoires
     * @return le nombre de victoires
     */
    int getWins();

    /**
     * Ajoute une victoire
     */
    void addWin();

    /**
     * Récupère le nombre de parties jouées
     * @return le nombre de parties jouées
     */
    int getGamesPlayed();

    /**
     * Ajoute une partie jouée
     */
    void addGamePlayed();

    /**
     * Récupère les dégats reçus
     * @return les dégats reçus
     */
    double getDamagesReceived();

    /**
     * Ajoute des dégats reçus
     * @param received dégats reçus
     */
    void addDamagesReceived(double received);

    /**
     * Récupère les dégats infligés
     * @return les dégats infligés
     */
    double getDamagesInflected();

    /**
     * Ajoute des déjats infligés
     * @param inflected déjats infligés
     */
    void addDamagesInflected(double inflected);

    /**
     * Récupère le ratio Kills + Assists / Deaths
     * @return le ratio Kills + Assists / Deaths
     */
    double getRatio();

    /**
     * Récupère le taux de victoire
     * @return le taux de victoire
     */
    double getWinRate();

    /**
     * Récupère le PlayerUHCStats sous forme de Document bson
     * @return le PlayerUHCStats sous forme de Document bson
     */
    Document toDocument();

    /**
     * Met à jour le PlayerUHCStats grâce à un document
     * @param document document
     */
    void update(Document document);

}
