package fr.pandonia.api.battlepass.manager;

import fr.pandonia.api.battlepass.IBPChallenge;
import fr.pandonia.api.battlepass.IBPItem;

import java.util.List;

public interface IBPItemManager {
    /**
     * Récupère la liste de tous les items du BattlePass
     * @return la liste de tous les items du BattlePass
     */
    List<IBPItem> getItems();

    /**
     * Récupère un item via son level
     * @param level le level
     * @return l'item
     */
    IBPItem getItem(int level);

    /**
     * Récupère la liste des défis
     * @return la liste des défis
     */
    List<IBPChallenge> getChallenges();

    /**
     * Récupère un défi à l'aide de son nom
     * @param name nom du défi à trouver
     * @return défi trouvé ou null
     */
    IBPChallenge getChallenge(String name);

    IBPChallenge getChallenge(int id);
}
