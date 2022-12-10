package fr.pandonia.api.player.stats.manager;

import fr.pandonia.api.player.stats.IPlayerStats;

import java.util.List;
import java.util.UUID;

public interface IPlayerStatsManager {

    /**
     * Récupère le PlayerStats d'un joueur connecté à l'instance à l'aide de son UUID
     * @param playerUUID UUID du joueur
     * @return le PlayerStats trouvé (ou null)
     */
    IPlayerStats getPlayerStats(UUID playerUUID);

    /**
     * Ajoute le PlayerStats à la liste (chargement compte du joueur)
     * @param stats PlayerStats à ajouter
     */
    void addPlayerStats(IPlayerStats stats);

    /**
     * Retire le PlayerStats de la liste (déconnexion du joueur)
     * @param playerUUID UUID du PlayerSettings à retirer
     */
    void removePlayerStats(UUID playerUUID);

    /**
     * Récupère la liste des PlayerStats chargés
     * @return la liste des PlayerStats chargés
     */
    List<IPlayerStats> getPlayerStatsList();

}