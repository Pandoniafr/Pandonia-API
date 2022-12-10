package fr.pandonia.api.player.owning.cosmetics;

import org.bson.Document;

import java.util.List;

public interface IPlayerCosmeticsOwning {

    /**
     * Récupère la liste des ID des pets que possède le joueur
     * @return la liste des ID des pets que possède le joueur
     */
    List<Integer> getCosmetics();

    /**
     * Ajoute un ID de pet à la liste des possédés
     * @param id id du pet à ajouter
     */
    void addCosmetic(int id);

    /**
     * Retire un ID de pet à la liste des possédés
     * @param id id du pet à retirer
     */
    void removeCosmetic(int id);

    /**
     * Récupère si le pet est possédé
     * @param id id du pet à vérifier
     * @return si le pet est possédé
     */
    boolean isOwningCosmetic(int id);

    /**
     * Récupère le PlayerCosmeticsOwning sous forme de Document bson
     * @return le PlayerCosmeticsOwning sous forme de Document bson
     */
    Document toDocument();

    /**
     * Met à jour le PlayerCosmeticsOwning grâce à un document
     * @param document document
     */
    void update(Document document);

}