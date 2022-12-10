package fr.pandonia.api.player;

import java.util.UUID;

public interface ITempPlayer {

    /**
     * Récupère le UUID du joueur temporaire
     * @return le UUID du joueur temporaire
     */
    UUID getUUID();

    /**
     * Récupère si le joueur temporaire est chargé
     * @return si le joueur temporaire est chargé
     */
    boolean isLoaded();

    /**
     * Définit si le joueur temporaire est chargé
     * @param loaded valeur
     */
    void setLoaded(boolean loaded);

}
