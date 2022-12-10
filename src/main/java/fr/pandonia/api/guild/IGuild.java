package fr.pandonia.api.guild;

import org.bson.Document;

import java.util.List;
import java.util.UUID;

public interface IGuild {

    /**
     * Récupère l'UUID de la guilde
     * @return l'UUID de la guilde
     */
    UUID getUUID();

    /**
     * Récupère le nom de la guilde
     * @return le nom de la guilde
     */
    String getName();

    /**
     * Récupère le tag de la guilde
     * @return le tag de la guilde
     */
    String getTag();

    /**
     * Récupère le chef de guilde
     * @return le chef de guilde
     */
    IGuildMember getOwner();

    /**
     * Récupère un membre
     * @param playerUUID UUID du membre
     * @return membre trouvé ou null
     */
    IGuildMember getMember(UUID playerUUID);

    /**
     * Récupère un membre
     * @param name UUID du membre
     * @return membre trouvé ou null
     */
    IGuildMember getMember(String name);

    /**
     * Récupère la liste des membres
     * @return la liste des membres
     */
    List<IGuildMember> getMembers();

    /**
     * Récupère la liste des membres connectés
     * @return la liste des membres connectés
     * @param onlineMembers liste des joueurs connectés
     */
    List<IGuildMember> getOnlineMembers(List<UUID> onlineMembers);

    /**
     * Récupère la liste des membres avec un certain rank
     * @param rank rank à chercher
     * @return liste des membres
     */
    List<IGuildMember> getMembersOfRank(GuildRank rank);

    /**
     * Récupère les saphirs de la guilde
     * @return les saphirs de la guilde
     */
    int getSaphirs();

    List<IGuildInvitation> getInvitations();

    IGuildInvitation getInvitation(UUID playerUUID);

    void addInvitation(IGuildInvitation invit);

    IGuildInvitation getInvitation(String name);

    void removeInvitation(UUID playerUUID);

    /**
     * Récupère la guilde sous forme de Document bson
     * @return la guilde sous forme de Document bson
     */
    Document toDocument();

    Document toMongoDocument();
}
