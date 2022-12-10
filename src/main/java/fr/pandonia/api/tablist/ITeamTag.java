package fr.pandonia.api.tablist;

import org.bukkit.scoreboard.Team;

import java.util.Collection;
import java.util.UUID;

public interface ITeamTag {

    /**
     * Ajoute player à la {@link ITeamTag}
     * @param player joueur à ajouter
     */
    void set(String player);

    /**
     * Retire player de la {@link ITeamTag}
     * @param player joueur à retirer
     */
    void remove(String player);

    /**
     * Retire de la {@link ITeamTag} le joueur avec l'uuid en paramètre
     * @param uuid uuid du joueur à retirer
     */
    void resetTagUtils(UUID uuid);

    /**
     * Ajoute une liste de joueurs à la {@link ITeamTag}
     * @param players liste des joueurs à ajouter
     */
    void setAll(Collection<String> players);

    /**
     * Ajoute une liste de joueurs à la {@link ITeamTag}
     * @param players liste des joueurs à ajouter
     */
    void setAll(String[] players);

    /**
     * Redéfini le préfixe de la {@link ITeamTag}
     * @param prefix nouveau préfixe
     */
    void setPrefix(String prefix);

    /**
     * Redéfini le suffixe de la {@link ITeamTag}
     * @param suffix nouveau suffixe
     */
    void setSuffix(String suffix);

    /**
     * Récupère le préfixe
     * @return préfixe
     */
    String getPrefix();

    /**
     * Récupère le suffixe
     * @return suffixe
     */
    String getSuffix();



    /**
     * Récupère la Bukkit {@link Team}
     * @return Bukkit Team
     */
    Team getTeam();

    /**
     * Désenregistre la team bukkit
     */
    void removeTeam();

    /**
     * Récupère la priorité
     * @return la priorité
     */
    int getPriority();

    /**
     * Récupère si le name tag est caché au dessus du joueur
     * @return si le name tag est caché au dessus du joueur
     */
    boolean isNameTagHide();

    void forceNameTagHide(boolean value);

    void updateNameTagVisibility();
}
