package fr.pandonia.api.sanction;

import org.bson.Document;

import java.util.Date;
import java.util.UUID;

public interface ISanction {

    /**
     * Récupère l'UUID du joueur sanctionné
     * @return l'UUID du joueur sanctionné
     */
    UUID getPlayerUUID();

    /**
     * Récupère le type de sanction
     * @return le type de sanction
     */
    SanctionType getType();

    /**
     * Récupère la date à laquelle la sanction à été appliquée
     * @return la date à laquelle la sanction à été appliquée
     */
    Date getWhen();

    /**
     * Récupère la durée de la sanction (en secondes)
     * @return la durée de la sanction (en secondes)
     */
    long getDuration();

    /**
     * Récupère le pseudo du modérateur qui a appliqué la sanction
     * @return le pseudo du modérateur qui a appliqué la sanction
     */
    String getBy();

    /**
     * Récupère la raison de la sanction
     * @return la raison de la sanction
     */
    String getReason();

    /**
     * Récupère si la sanction a été retirée
     * @return si la sanction a été retirée
     */
    boolean isRemoved();

    /**
     * Récupère la sanction sous forme de Document bson
     * @return la sanction sous forme de Document bson
     */
    Document toDocument();

}

