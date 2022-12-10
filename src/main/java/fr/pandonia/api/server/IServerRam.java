package fr.pandonia.api.server;

import org.bson.Document;

public interface IServerRam {

    /**
     * Récupère la RAM allouée à l'instance
     * @return la RAM allouée à l'instance
     */
    int getAllocatedRam();

    /**
     * Récupère la RAM maximum allouée à l'instance
     * @return la RAM maximum allouée à l'instance
     */
    int getMaxRam();

    /**
     * Récupère le ServerRam sous forme de Document bson
     * @return le ServerRam sous forme de Document bson
     */
    Document toDocument();

}
