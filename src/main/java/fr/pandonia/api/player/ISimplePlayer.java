package fr.pandonia.api.player;

import fr.pandonia.api.player.nick.INick;
import fr.pandonia.api.rank.IRank;
import fr.pandonia.api.rank.manager.IRankManager;
import org.bson.Document;

import java.util.UUID;

public interface ISimplePlayer {

    /**
     * UUID du joueur
     * @return l'uuid du joueur
     */
    UUID getUUID();

    /**
     * Pseudo du joueur
     * @return pseudo du joueur
     */
    String getName();

    /**
     * Pseudo du joueur ou son pseudo nick si activé
     * @return pseudo du joueur à afficher
     */
    String getDisplayName();

    /**
     * Nom du rank du joueur
     * @return Nom du rank du joueur
     */
    String getRank();

    String getDisplayRank();

    /**
     * Récupère le nick du joueur
     * @return le nick du joueur
     */
    INick getNick();

    /**
     * Défini le nick du joueur
     * @param nick le nouveau nick du joueur
     */
    void setNick(INick nick);

    /**
     * Récupère le Rank sous sa forme  d'object (récupéré depuis le {@link IRankManager})
     * @return le Rank sous sa forme  d'object
     */
    IRank getRankObject(IRankManager rankManager);

    IRank getDisplayRankObject(IRankManager rankManager);

    /**
     * Récupère le préfix du joueur via son Rank (récupéré depuis le {@link IRankManager})
     * @return le préfix
     */
    String getPrefix(IRankManager rankManager);

    String getDisplayPrefix(IRankManager rankManager);

    /**
     * Récupère le nom custom d'un joueur si il est Pandore
     * @return le nom custom
     */
    String getCustomRankName();

    /**
     * Récupère la couleur custom d'un joueur si il est Pandore
     * @return la couleur
     */
    String getCustomRankColor();

    /**
     * Défini un nouveau nom custom pour un joueur Pandore
     * @param customRankName le nouveau nom
     */
    void setCustomRankName(String customRankName);

    /**
     * Défini une nouvelle couleur custom pour un joueur Pandore
     * @param customRankColor
     */
    void setCustomRankColor(String customRankColor);

    void setRank(String rank);

    /**
     * Récupère le SimplePlayer sous forme de {@link Document}
     * @return player en tant que Document (JSON)
     */
    Document toDocument();

    /**
     * Récupère le SimplePlayer sous forme de {@link Document}
     * @return player en tant que Document (JSON)
     */
    Document toSimpleDocument();

}

