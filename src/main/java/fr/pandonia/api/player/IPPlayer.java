package fr.pandonia.api.player;

import org.bson.Document;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Date;

public interface IPPlayer extends ISimplePlayer {

    /**
     * Récupère le joueur Bukkit
     * @return le joueur Bukkit (null si pas trouvé)
     */
    Player getBukkitPlayer();

    /**
     * Envoi le/les message(s) au joueur
     * @param messages messages à envoyer
     */
    void sendMessage(String... messages);

    /**
     * Récupère la date de la première connexion
     * @return la date de la première connexion
     */
    Date getFirstLogin();

    /**
     * Récupère la date de la dernière connexion
     * @return la date de la dernière connexion
     */
    Date getLastLogin();

    /**
     * Récupère la date d'expiration du grade
     * @return la date d'expiration du grade (null si grade permanent)
     */
    Date getRankEnd();

    /**
     * Défini la date d'expiration du grade
     * @param rankEnd date d'expiration du grade
     */
    void setRankEnd(Date rankEnd);

    /**
     * Récupère le nombre de saphirs
     * @return le nombre de saphirs
     */
    int getSaphirs();

    /**
     * Donne des saphirs au joueur
     * @param saphirs saphirs à donner
     */
    void addSaphirs(int saphirs);

    /**
     * Retire des saphirs au joueur
     * @param saphirs saphirs à retirer
     */
    void removeSaphirs(int saphirs);

    /**
     * Donne des saphirs au joueur avec une raison
     * (qu'il recevra sous forme de message dans son chat)
     * @param saphirs saphirs à donner
     * @param reason raison
     */
    void addSaphirsWithReason(int saphirs, String reason);

    /**
     * Récupère le nombre d'hosts
     * @return  le nombre d'hosts
     */
    int getHosts();

    /**
     * Ajoute des hosts au joueur
     * @param hosts le nombre d'host
     */
    void addHosts(int hosts);

    void removeLoobox(int lootboxes);

    void removeHosts(int hosts);

    /**
     * Récupère le nombre de Boîtes de Pandore
     * @return le nombre de Boîtes de Pandore
     */
    int getLootboxes();

    /**
     * Ajoute des Boîtes de Pandore au joueur
     * @param lootboxes nombre de boîtes de Pandore à donner au joueur
     */
    void addLootbox(int lootboxes);

    /**
     * Retire une Boîte de Pandore au joueur
     */
    void removeLootbox();

    /**
     * Récupère le temps joué sur le serveur (en seconde)
     * @return le temps joué sur le serveur
     */
    int getPlayingTime();

    boolean canSeeNick(IPPlayer cpp);

    String getNickPrefix(IPPlayer cpp);

    String getNickDisplayName(IPPlayer cpp);

    /**
     * Récupère si le joueur à déjà été sauvegardé au niveau du proxy
     * @return si le joueur à déjà été sauvegardé au niveau du proxy
     */
    boolean isSaved();

    /**
     * Défini si le joueur à été sauvegardé au niveau du proxy
     * @param saved valeur
     */
    void setSaved(boolean saved);

    /**
     * Récupère la tête du joueur avec ses informations
     * @return la tête du joueur avec ses informations
     */
    ItemStack getProfileHead();

    /**
     * Retourne le compte joueur sous forme de Document bson
     * @return
     */
    Document toDocument();

}

