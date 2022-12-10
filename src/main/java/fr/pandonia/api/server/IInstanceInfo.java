package fr.pandonia.api.server;

import fr.pandonia.api.player.ISimplePlayer;

import java.util.List;

/**
 * InstanceInfo permet à l'instance de récupèrer les informations sur elle-même
 */
public interface IInstanceInfo {

    /**
     * Récupère le nom de l'instance
     * @return le nom de l'instance
     */
    String getName();

    /**
     * Récupère le nom modifié de l'instance
     * @return le nom modifié de l'instance
     */
    String getCustomName();

    ServerSettings getServerSettings();

    /**
     * Récupère le nom du type de serveur
     * @return le nom du type de serveur
     */
    String getType();

    /**
     * Récupère les slots de l'instance
     * @return les slots de l'instance
     */
    int getSlots();

    /**
     * Récupère l'ip de l'instance venant du fichier config.json
     * @return l'ip de l'instance
     */
    String getIP();

    /**
     * Récupère le port de l'instance
     * @return le port de l'instance
     */
    int getPort();

    /**
     * Récupère le ServerStatus de l'instance
     * @return le ServerStatus de l'instance
     */
    ServerStatus getStatus();

    /**
     * Récupère la liste des joueurs dans l'instance
     * @return la liste des joueurs dans l'instance
     */
    List<ISimplePlayer> getPlayers();

    /**
     * Récupère l'host de l'instance
     * @return l'host de l'instance
     */
    ISimplePlayer getHost();

    /**
     * Récupère si l'instance est en mode officiel
     * @return si l'instance est en mode officiel
     */
    boolean isOfficial();

    /**
     * Défini (en local uniquement) si l'instance est en mode officiel
     * @param officialLocal valeur
     */
    void setOfficialLocal(boolean officialLocal);

    /**
     * Met à jour les informations sur l'instance
     */
    void updateInstanceInfo();

    /**
     * Récupère le serveur de l'instance
     * @return l'instance du serveur
     */
    IServer getServer();
}

