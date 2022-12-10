package fr.pandonia.api.player.settings;

import org.bson.Document;

import java.util.UUID;

public interface IPlayerSettings {

    /**
     * Récupère l'UUID du joueur
     * @return l'UUID du joueur
     */
    UUID getPlayerUUID();

    /**
     * Récupère si le joueur accepte la réception des messages privés
     * @return si le joueur accepte la réception des messages privés
     */
    boolean isMP(FriendsSetting ... friendsSetting);

    /**
     * Défini si le joueur accepte la réception des messages privés
     * @param mp valeur
     */
    void setMP(FriendsSetting mp);

    FriendsSetting getMp();

    /**
     * Récupère quels joueurs voient le joueur dans le hub
     * @param showPlayerHubs condition
     * @return true si l'option du joueur fait partie de la condition
     */
    boolean isShowPlayerHub(FriendsSetting... showPlayerHubs);

    /**
     * Défini quels joueurs voient le joueur dans le hub
     * @param showPlayerHub l'option
     */
    void setShowPlayerHub(FriendsSetting showPlayerHub);

    FriendsSetting getShowPlayerHub();

    boolean isFriendsRequest();

    void setFriendsRequest(boolean friendsRequest);

    boolean isFriendsNotification();

    void setFriendsNotification(boolean friendsNotification);

    /**
     * Récupère si le joueur accepte la réception des mentions dans le chat
     * @return si le joueur accepte la réception des mentions dans le chat
     */
    boolean isMentions();

    /**
     * Défini si le joueur accepte la réception des mentions dans le chat
     * @param mentions valeur
     */
    void setMentions(boolean mentions);

    /**
     * Récupère si le joueur (staff) accepte la réception des helpops
     * @return si le joueur (staff) accepte la réception des helpops
     */
    boolean isReceiveHelpop();

    /**
     * Défini si le joueur (staff) accepte la réception des helpops
     * @param receiveHelpop valeur
     */
    void setReceiveHelpop(boolean receiveHelpop);

    /**
     * Récupère si le joueur reçoit les helpops globaux
     * @return si le joueur reçoit les helpops globaux
     */
    boolean isHelpopGlobal();

    /**
     * Défini si le joueur reçoit les helpops globaux
     * @param helpopGlobal valeur
     */
    void setHelpopGlobal(boolean helpopGlobal);

    /**
     * Récupère si le joueur (staff) reçoit les messages du channel staff
     * @return si le joueur (staff) reçoit les messages du channel staff
     */
    boolean isStaffChat();

    /**
     * Défini si le joueur (staff) reçoit les messages du channel staff
     * @param staffChat valeur
     */
    void setStaffChat(boolean staffChat);

    /**
     * Récupère l'ID du Pet actif
     * @return l'ID du Pet actif
     */
    int getActivePetID();

    /**
     * Défini si l'ID du Pet actif du joueur
     * @param activePetID valeur
     */
    void setActivePetID(int activePetID);

    /**
     * Récupère l'ID du block actif dans l'arena
     * @return l'ID du block actif dans l'arena
     */
    int getActiveArenaBlockID();

    /**
     * Défini si l'ID du block actif dans l'arena
     * @param activeArenaBlockID valeur
     */
    void setActiveArenaBlockID(int activeArenaBlockID);

    int getActiveArrowID();

    void setActiveArrowID(int activeArrowID);

    int getActiveGadgetID();

    void setActiveGadgetID(int activeGadgetID);

    int getActiveKillAnimationID();

    void setActiveKillAnimationID(int activeKillAnimationID);

    boolean isParticles();

    void setParticles(boolean particles);

    /**
     * Récupère les settings liés aux armures dans le hub
     * @return les settings
     */
    IPlayerArmorSettings getPlayerArmorSettings();

    void setVanish(boolean vanish);

    boolean isVanish();

    /**
     * Récupère le PlayerSettings sous forme de Document bson
     * @return le PlayerSettings sous forme de Document bson
     */
    Document toDocument();

    /**
     * Met à jour le PlayerSettings grâce à un document
     * @param document document
     */
    void update(Document document);

}
