package fr.pandonia.api.tablist.manager;

import fr.pandonia.api.tablist.ITeamTagView;
import org.bukkit.entity.Player;

import java.util.List;

public interface ITeamTagManager {

    /**
     * Défini une view à un jouer
     * @param p joueur à qui on défini la view
     * @param name nom de la view à définit
     */
    void setView(Player p, String name);

    /**
     * Récupère une view à l'aide de son nom
     * @param name nom de la view à récupérer
     * @return
     */
    ITeamTagView getView(String name);

    ITeamTagView getPlayerView(Player p);

    void setSuffix(String player, String suffix);

    /**
     * Défini des règles à un joueurs dans toutes les views
     * @param player joueur à qui on défini les règles
     * @param prefix préfixe du joueur
     * @param suffix suffixe du joueur
     * @param priority ordre dans le tab (plus le nombre est élevé, plus il sera haut dans le tab)
     */
    void setNameTag(String player, String prefix, String suffix, int priority);

    /**
     * Créé une view, l'ajoute à la liste et la retourne
     * @param name nom de la view à créer
     * @return view créée
     */
    ITeamTagView createView(String name);

    /**
     * Récupère la liste des view
     * @return la liste des view
     */
    List<ITeamTagView> getViews();

    boolean isGlobalNameTagHide();

    /**
     * Défini si tous les name tag sont cachés
     * @param value
     */
    void setGlobalHideNameTag(boolean value);

    void updateAllNameTags();

    void shopPlayersLives(Player p);
}
