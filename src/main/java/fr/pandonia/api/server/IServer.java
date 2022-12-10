package fr.pandonia.api.server;

import fr.pandonia.api.player.ISimplePlayer;
import org.bson.Document;

import java.util.List;
import java.util.UUID;

public interface IServer {

    /**
     * Récupère le nombre de joueur sur ce serveur ayant un grade spécifique
     * @param rank grade des joueurs à compter
     * @return le nombre de joueur sur ce serveur ayant un grade spécifique
     */
    int getNumberOfPlayersWithRank(String rank);

    /**
     * Récupère le nom du serveur
     * @return le nom du serveur
     */
    String getName();

    /**
     * Récupère le nom modifié du serveur
     * @return le nom modifié du serveur
     */
    String getCustomName();

    String getUserFriendlyName();

    /**
     * Récupère le nom du type de serveur
     * @return le nom du type de serveur
     */
    String getType();

    /**
     * Récupère les slots du serveur
     * @return les slots du serveur
     */
    int getSlots();

    /**
     * Récupère l'ip de la machine sur laquelle se trouve le serveur
     * @return l'ip de la machine sur laquelle se trouve le serveur
     */
    String getIP();

    /**
     * Récupère le port du serveur
     * @return le port du serveur
     */
    int getPort();

    /**
     * Récupère le status du serveur
     * @return le status du serveur
     */
    ServerStatus getServerStatus();

    /**
     * Récupère l'host de la partie
     * @return l'host de la partie
     */
    ISimplePlayer getHost();

    boolean isServerStatus(ServerStatus... serverStatuses);

    /**
     * Récupère la liste des joueurs sur le serveur
     * @return la liste des joueurs sur le serveur
     */
    List<ISimplePlayer> getPlayers();

    List<UUID> getAlivePlayers();

    int getSpecs();

    /**
     * Récupère si la whitelist est activée
     * @return si la whitelist est activée
     */
    boolean isWhitelist();

    /**
     * Récupère si la file d'attente est ouverte
     * @return si la file d'attente est ouverte
     */
    boolean isQueueStatus();

    /**
     * Récupère les joueurs dans la whitelist
     * @return les joueurs dans la whitelist
     */
    List<String> getWhitelist();

    /**
     * Récupère si un joueur est whitelist ou non
     * @param name Le nom du joueur
     * @return true si le joueur est whitelist
     */
    boolean isWhiteList(String name);

    /**
     * Récupère la liste des scénatios activés
     * @return la liste des scénatios activés
     */
    List<String> getScenarios();

    int getNumberOfPlayersWithDisplayRank(String rank);

    /**
     * Récupère si le serveur est en mode partie officielle
     * @return si le serveur est en mode partie officielle
     */
    boolean isOfficial();

    /**
     * Récupère si le link discord est nécéssaire
     * @return le link discord est nécéssaire
     */
    boolean isLinkNeeded();

    /**
     * Récupère le serveur sous forme de Document bson
     * @return le serveur sous forme de Document bson
     */
    Document toDocument();

}
