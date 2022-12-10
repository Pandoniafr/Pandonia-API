package fr.pandonia.api.tablist;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Collection;
import java.util.Map;

public interface ITeamTagView {

    /**
     * Défini la {@link ITeamTagView} au joueur
     * @param player joueur à qui définir la view
     */
    void set(Player player);

    /**
     * Défini la {@link ITeamTagView} à une liste de joueur
     * @param players listes des joueurs à qui définir la view
     */
    void setAll(Collection< ? extends Player> players);

    /**
     * Défini la {@link ITeamTagView} à une liste de joueur
     * @param players listes des joueurs à qui définir la view
     */
    void setAll(Player[] players);

    void setTeamTagHide(String player, boolean teamTagHide);

    void setSuffix(String player, String suffix);

    void setPrefix(String player, String prefix);

    void setPriority(String player, int priority);

    void setNameTag(String player, String prefix, int priority);

    /**
     * Défini des règles à un joueur dans la {@link ITeamTagView}
     * @param player joueur à qui on défini les règles
     * @param prefix préfixe du joueur
     * @param suffix suffixe du joueur
     * @param priority ordre dans le tab (plus le nombre est élevé, plus il sera haut dans le tab)
     */
    void setNameTag(String player, String prefix, String suffix, int priority);

    /**
     * Défini des règles à un joueur dans la {@link ITeamTagView}
     * @param player joueur à qui on défini les règles
     * @param prefix préfixe du joueur
     * @param suffix suffixe du joueur
     * @param priority ordre dans le tab (plus le nombre est élevé, plus il sera haut dans le tab)
     * @param hideNameTag si le name tag sera affiché au dessus du joueur
     */
    void setNameTag(String player, String prefix, String suffix, int priority, boolean hideNameTag);

    void setNameTag(String player, String prefix, String suffix, int priority, boolean hideNameTag, boolean save);

    void restoreNameTag(String player);

    /**
     * Récupère le nom de la view
     * @return nom de la view
     */
    String getName();

    /**
     * Récupère le Bukkit {@link Scoreboard}
     * @return bukkit scoreboard
     */
    Scoreboard getScoreboard();

    /**
     * Récupère la liste des {@link ITeamTag}
     * @return la liste
     */
    Map<String, ITeamTag> getTeamTags();

    /**
     * Récupère le {@link ITeamTag} d'un joueur donné
     * @param player le joueur
     * @return le team tag
     */
    ITeamTag getPlayerTeamTag(String player);

    /**
     * Force tous les name tags de la View a être caché ou non
     * @param value
     */
    void forceNameTagHide(boolean value);

    /**
     * Update les name tags en fonction de la valeur initiale donnée en paramètre
     */
    void updateNameTagVisibility();

    ITeamTagView clone(String name);
}