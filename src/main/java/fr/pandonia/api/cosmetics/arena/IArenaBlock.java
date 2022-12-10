package fr.pandonia.api.cosmetics.arena;

import fr.pandonia.api.cosmetics.ICosmetic;

public interface IArenaBlock extends ICosmetic {

    /**
     * Récupère l'id du block
     * @return l'id du block
     */
    int getBlockID();

    /**
     * Récupère la data du block
     * @return la data du block
     */
    short getBlockData();

}
