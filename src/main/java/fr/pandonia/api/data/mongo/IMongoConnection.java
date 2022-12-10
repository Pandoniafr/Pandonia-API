package fr.pandonia.api.data.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public interface IMongoConnection {

    /**
     * Initialise la connexion à la base de donnée MongoDB
     */
    void init();

    /**
     * Le client initialisé dans la méthode init()
     * @return client initialisé dans la méthode init
     */
    MongoClient getMongoClient();

    /**
     * La base de donnée stockée dans le {@link IMongoCredentials} récupérée grade au {@link MongoClient}
     * @return la base de donnée MongoDB
     */
    MongoDatabase getMongoDatabase();

}


