package fr.pandonia.api.player.battlepass.manager;

import fr.pandonia.api.player.battlepass.IPlayerBattlePass;

import java.util.List;
import java.util.UUID;

public interface IPlayerBattlePassManager {

    /**
     * Récupère le PlayerBattlePass d'un joueur connecté à l'instance à l'aide de son UUID
     * @param playerUUID UUID du joueur
     * @return le PlayerBattlePass trouvé (ou null)
     */
    IPlayerBattlePass getPlayerBattlePass(UUID playerUUID);

    /**
     * Ajoute le PlayerBattlePass à la liste (chargement compte du joueur)
     * @param owning PlayerBattlePass à ajouter
     */
    void addPlayerBattlePass(IPlayerBattlePass owning);

    /**
     * Retire le PlayerBattlePass de la liste (déconnexion du joueur)
     * @param playerUUID UUID du PlayerBattlePass à retirer
     */
    void removePlayerBattlePass(UUID playerUUID);

    /**
     * Récupère la liste des PlayerBattlePass chargés
     * @return la liste des PlayerBattlePass chargés
     */
    List<IPlayerBattlePass> getPlayerBattlePassList();

}
