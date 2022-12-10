package fr.pandonia.api.player.stats;

import fr.pandonia.api.player.stats.uhc.IPlayerUHCStats;
import org.bson.Document;

import java.util.UUID;

public interface IPlayerStats {

    /**
     * Récupère les stats du mode donné
     * @return les stats du mode donné ou les stats par défaut
     */
    IPlayerUHCStats getStats(String mode);

    /**
     * Récupère l'UUID du joueur
     * @return l'UUID du joueur
     */
    UUID getPlayerUUID();

    /**
     * Récupère le PlayerStats sous forme de Document bson
     * @return le PlayerStats sous forme de Document bson
     */
    Document toDocument();

    /**
     * Met à jour le PlayerStats grâce à un document
     * @param document document
     */
    void update(Document document);

}
