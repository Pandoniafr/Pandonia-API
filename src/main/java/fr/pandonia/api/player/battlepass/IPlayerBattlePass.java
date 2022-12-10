package fr.pandonia.api.player.battlepass;

import org.bson.Document;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public interface IPlayerBattlePass {

    /**
     * Récupère l'UUID du joueur
     * @return l'UUID du joueur
     */
    UUID getPlayerUUID();

    /**
     * Récupère le niveau du Battle Pass
     * @return le niveau du Battle Pass
     */
    int getLevel();

    /**
     * Récupère l'XP du Battle Pass
     * @return l'XP du Battle Pass
     */
    int getXP();

    /**
     * Récupère l'XP obtenu à ce niveau
     * @return l'XP obtenu à ce niveau
     */
    int getActualXP();

    /**
     * Ajoute de l'XP au Battle Pass
     * @param xp xp à ajouter
     */
    void addXP(int xp);

    /**
     * Ajoute de l'XP au Battle Pass (avec une raison)
     * @param xp xp à ajouter
     */
    void addXPWithReason(int xp, String reason);

    /**
     * Récupère le pourcentage d'avancement dans le niveau
     * @return le pourcentage d'avancement dans le niveau
     */
    int getPercent();

    /**
     * Récupère l'XP nécéssaire (globale) pour passer du niveau actuel au niveau suivant
     * @return l'XP nécéssaire (globale) pour passer du niveau actuel au niveau suivant
     */
    int getAllNeededXPForNextLevel();

    /**
     * Récupère l'XP nécéssaire pour passer du niveau actuel au niveau suivant
     * @return l'XP nécéssaire pour passer du niveau actuel au niveau suivant
     */
    int getNeededXPForNextLevel();

    /**
     * Récupère l'XP nécéssaire avant de passer de niveau
     * @return l'XP nécéssaire avant de passer de niveau
     */
    int getRemainingXP();

    /**
     * Récupère si le joueur a acheté le Battle Pass
     * @return si le joueur a acheté le Battle Pass
     */
    boolean isBuy();

    /**
     * Défini si le joueur a acheté le Battle PAss
     * @param buy valeur
     */
    void setBuy(boolean buy);

    /**
     * Récupère si le BattlePass est boosté
     * @return si le BattlePass est boosté
     */
    boolean isBoosted();

    /**
     * Défini si le BattlePass est boosté
     * @param boosted valeur
     */
    void setBoosted(boolean boosted);

    /**
     * Récupère les items claim du joueur
     * @return items claim du joueur
     */
    Map<Integer, Date> getClaimedItems();

    Map<Integer, Date> getChallenge();

    void addChallenge(int id);

    /**
     * Récupère le PlayerOwning sous forme de Document bson
     * @return le PlayerOwning sous forme de Document bson
     */
    Document toDocument();

    /**
     * Met à jour le PlayerOwning grâce à un document
     * @param document document
     */
    void update(Document document);

}

