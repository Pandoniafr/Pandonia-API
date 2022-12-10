package fr.pandonia.api.player.owning.manager;

import fr.pandonia.api.player.owning.IPlayerOwning;

import java.util.List;
import java.util.UUID;

public interface IPlayerOwningManager {

    /**
     * Récupère le PlayerOwning d'un joueur connecté à l'instance à l'aide de son UUID
     * @param playerUUID UUID du joueur
     * @return le PlayerOwning trouvé (ou null)
     */
    IPlayerOwning getPlayerOwning(UUID playerUUID);

    /**
     * Ajoute le PlayerOwning à la liste (chargement compte du joueur)
     * @param owning PlayerOwning à ajouter
     */
    void addPlayerOwning(IPlayerOwning owning);

    /**
     * Retire le PlayerOwning de la liste (déconnexion du joueur)
     * @param playerUUID UUID du PlayerOwning à retirer
     */
    void removePlayerOwning(UUID playerUUID);

    /**
     * Récupère la liste des PlayerOwning chargés
     * @return la liste des PlayerOwning chargés
     */
    List<IPlayerOwning> getPlayerOwningList();

}

