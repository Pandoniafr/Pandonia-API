package fr.pandonia.api.player.settings.manager;

import fr.pandonia.api.player.settings.IPlayerSettings;

import java.util.List;
import java.util.UUID;

public interface IPlayerSettingsManager {

    /**
     * Récupère le PlayerSettings d'un joueur connecté à l'instance à l'aide de son UUID
     * @param playerUUID UUID du joueur
     * @return le PlayerSettings trouvé (ou null)
     */
    IPlayerSettings getPlayerSettings(UUID playerUUID);

    /**
     * Ajoute le PlayerSettings à la liste (chargement compte du joueur)
     * @param settings PlayerSettings à ajouter
     */
    void addPlayerSettings(IPlayerSettings settings);

    /**
     * Retire le PlayerSettings de la liste (déconnexion du joueur)
     * @param playerUUID UUID du PlayerSettings à retirer
     */
    void removePlayerSettings(UUID playerUUID);

    /**
     * Récupère la liste des PlayerSettings chargés
     * @return la liste des PlayerSettings chargés
     */
    List<IPlayerSettings> getPlayerSettingsList();

}
