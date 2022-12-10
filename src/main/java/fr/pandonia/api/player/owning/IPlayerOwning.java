package fr.pandonia.api.player.owning;

import fr.pandonia.api.player.owning.cosmetics.IPlayerCosmeticsOwning;
import org.bson.Document;

import java.util.UUID;

public interface IPlayerOwning {

    /**
     * Récupère l'UUID du joueur
     * @return l'UUID du joueur
     */
    UUID getPlayerUUID();

    /**
     * Récupère le PlayerCosmeticsOwning du joueur (Stockage des cosmétiques possédés)
     * @return le PlayerCosmeticsOwning du joueur (Stockage des cosmétiques possédés)
     */
    IPlayerCosmeticsOwning getPlayerCosmeticsOwning();

    /**
     * Défini le PlayerCosmeticsOwning
     * @param playerCosmeticsOwning le player cosmetics owning à définir
     */
    void setPlayerCosmeticsOwning(IPlayerCosmeticsOwning playerCosmeticsOwning);

    /**
     * Récupère le PlayerOwning sous forme de Document bson
     * @return le PlayerOwning sous forme de Document bson
     */
    Document toDocument();

    /**
     * Met à jour le PlayerOwning grâce à un document
     * @param document document
     */
    void update(Document document);

}

