package fr.pandonia.api.server.manager;

import fr.pandonia.api.player.ISimplePlayer;
import fr.pandonia.api.server.IServer;

import java.util.List;
import java.util.UUID;

public interface IServerManager {

    /**
     * Récupère un serveur en cache
     * @param serverName nom du serveur à chercher
     * @return Server trouvé (ou null)
     */
    IServer getServer(String serverName);

    /**
     * Récupère si un serveur existe avec un certain nom
     * @param serverName nom du serveur à cherche
     * @return si le serveur existe
     */
    boolean exists(String serverName);

    /**
     * Ajoute un serveur à la liste des serveurs
     * @param server serveur à ajouter
     */
    void addServer(IServer server);

    /**
     * Retire un serveur de la liste des serveurs
     * @param server serveur à retirer
     */
    void removeServer(IServer server);

    /**
     * Retire un serveur de la liste des serveurs
     * @param serverName nom du serveur à retirer
     */
    void removeServer(String serverName);

    /**
     * Récupère un {@link IServer} depuis la base de donnée
     * @param name nom du serveur à trouver
     * @return Server trouvé (ou null)
     */
    IServer getServerFromDatabase(String name);


    /**
     * Récupère une liste de serveur d'un certain type
     * @param serverType nom du type de serveur
     * @return liste des serveurs trouvés
     */
    List<IServer> getServerListByType(String serverType);

    /**
     * Récupère le nombre de joueurs cummulés sur les serveurs d'un certain type
     * @param serverType nom du type de serveur
     * @return le nombre de joueurs
     */
    int getNumberOfPlayersByType(String serverType);

    /**
     * Met à jour la liste des serveurs en cache
     */
    void updateServers();

    /**
     * Démarrage la mise à jour automatique des serveurs en cache
     */
    void startUpdateTask();

    /**
     * Récupère si l'instance met à jour les serveurs en cache automatiquement
     * @return si l'instance met à jour les serveurs en cache automatiquement
     */
    boolean isUpdating();

    /**
     * Récupère la liste des serveurs en cache
     * @return la liste des serveurs en cache
     */
    List<IServer> getServers();

    /**
     * Récupère la liste des joueurs sur tout les serveurs en cache
     * @return la liste des joueurs sur tout les serveurs en cache
     */
    List<ISimplePlayer> getAllPlayers();

    /**
     * Récupère le serveur d'un joueur
     * @param uuid l'uuid du joueur
     * @return le serveur du joueur
     */
    IServer getPlayerServer(UUID uuid);

    boolean isHosts();

    void setHosts(boolean hosts);
}
