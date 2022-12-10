package fr.pandonia.api.server;

import fr.pandonia.api.settings.InstanceSettings;

import java.util.List;
import java.util.Map;

public interface IServerType {

    /**
     * Récupère le nom du type de serveur
     * @return le nom du type de serveur
     */
    String getName();

    /**
     * Récupère le nom modifié (par défaut) du type de serveur
     * @return le nom modifié (par défaut) du type de serveur
     */
    String getCustomName();

    /**
     * Récupère les slots par défaut du type de serveur
     * @return les slots par défaut du type de serveur
     */
    int getSlots();

    /**
     * Récupère la liste des plugins du type de serveur
     * @return la liste des plugins du type de serveur
     */
    List<String> getPlugins();

    /**
     * Récupère la liste des fichiers du type de serveur
     * @return la liste des fichiers du type de serveur
     */
    List<String> getFiles();

    /**
     * Récupère la ram du type de serveur
     * @return la ram du type de serveur
     */
    IServerRam getRam();

    /**
     * Récupère les maps (Nom du dossier d'origine / Nom du dossier de destination) du type de serveur
     * @return les maps du type de serveur
     */
    Map<String, String> getMaps();

    /**
     * Récupère si le type de serveur est un hub
     * @return si le type de serveur est un hub
     */
    boolean isHub();

    /**
     * Récupère si le type de serveur est une partie hostée
     * @return si le type de serveur est une partie hostée
     */
    boolean isHost();

    /**
     * Récupère si le type de serveur est un mini-jeu
     * @return si le type de serveur est un mini-jeu
     */
    boolean isMiniGame();

    /**
     * Récupère si le tab général s'affiche dans ce type de serveur
     * @return si le tab général s'affiche dans ce type de serveur
     */
    boolean isShowTab();

    /**
     * Récupère si rejoindre ce type de serveur fait rejoindre une file (fait alors aussi quitter la file dans laquelle le joueur se trouve)
     * @return si rejoindre ce type de serveur fait rejoindre une file
     */
    boolean isLeaveQueue();

    InstanceSettings getInstanceSettings();

    String getState();
}

