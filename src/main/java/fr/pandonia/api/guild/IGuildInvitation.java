package fr.pandonia.api.guild;

import fr.pandonia.api.player.ISimplePlayer;
import org.bson.Document;

import java.util.Date;
import java.util.UUID;

public interface IGuildInvitation {

    /**
     * Récupère l'UUID de la guilde
     * @return l'UUID de la guilde
     */
    UUID getGuild();

    /**
     * Récupère le joueur qui a envoyé l'invitation
     * @return le joueur qui a envoyé l'invitation
     */
    ISimplePlayer getSender();

    /**
     * Récupère le joueur qui a été invité
     * @return le joueur qui a été invité
     */
    ISimplePlayer getReceiver();

    /**
     * Récupère quand l'invitation a été envoyée
     * @return quand l'invitation a été envoyée
     */
    Date getWhen();

    /**
     * Récupère l'invitation sous forme de Document bson
     * @return l'invitation sous forme de Document bson
     */
    Document toDocument();

}
