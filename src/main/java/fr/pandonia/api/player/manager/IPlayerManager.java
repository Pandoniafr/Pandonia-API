package fr.pandonia.api.player.manager;

import fr.pandonia.api.player.IPPlayer;
import fr.pandonia.api.player.ISimplePlayer;
import org.bson.Document;

import java.util.List;
import java.util.UUID;

public interface IPlayerManager {

    /**
     * Récupère un PPlayer connecté à cette instance grâce à son UUID
     * @param uuid uuid du joueur à trouver
     * @return le PPlayer trouvé (ou null)
     */
    IPPlayer getPlayer(UUID uuid);

    /**
     * Récupère un PPlayer connecté à cette instance grâce à son pseudo
     * @param name pseudo du joueur à trouver
     * @return le PPlayer trouvé (ou null)
     */
    IPPlayer getPlayer(String name);

    /**
     * Update le joueur dans le proxy
     * @param uuid UUID du joueur
     */
    void savePlayer(UUID uuid);

    ISimplePlayer SimplePlayerFromDocument(Document document);

    /**
     * Retire des listes, tout ce qui est en lien avec ce joueur
     * @param uuid UUID du joueur
     */
    void removeAllPlayer(UUID uuid);

    /**
     * Ajoute le PPlayer à la liste des joueurs (chargement compte du joueur)
     * @param player joueur à ajouter
     */
    void addPlayer(IPPlayer player);

    /**
     * Retire le PPlayer de la liste des joueurs (déconnexion du joueur)
     * @param player uuid du joueur à retirer
     */
    void removePlayer(UUID player);

    /**
     * Récupère la liste des PPlayer chargés
     * @return la liste des PPlayer chargés
     */
    List<IPPlayer> getPlayers();


}
