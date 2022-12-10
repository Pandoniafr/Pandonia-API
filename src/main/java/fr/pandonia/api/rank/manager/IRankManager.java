package fr.pandonia.api.rank.manager;

import fr.pandonia.api.rank.IRank;

import java.util.List;

public interface IRankManager {

    /**
     * Enregistre (ou recharge) les ranks depuis la base de donnée Mongo
     */
    void register();

    /**
     * Récupère la liste des ranks chargés
     * @return la liste des ranks chargés
     */
    List<IRank> getRanks();

    /**
     * Récupère un rank à l'aide de son nom
     * @param name nom du rank
     * @return rank trouvé (ou null)
     */
    IRank getRank(String name);

    boolean isPowerHigherOrEqual(String rank, String toTest);

    /**
     * Récupère un rank à l'aide de son power
     * @param power power du rank
     * @return rank trouvé (ou null)
     */
    IRank getRankByPower(int power);

    /**
     * Récupère le rank par défaut
     * @return le rank par défaut (null si pas trouvé)
     */
    IRank getDefaultRank();

}
