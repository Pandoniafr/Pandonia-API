package fr.pandonia.api.data.mongo;

public interface IMongoCredentials {

    /**
     * l'ip de la base de donnée mongo
     * @return l'ip de la base de donnée mongo
     */
    String getIP();

    /**
     * le port de la base de donnée mongo
     * @return le port de la base de donnée mongo
     */
    int getPort();

    /**
     * le mot de passe du compte mongodb
     * @return le mot de passe du compte mongodb
     */
    String getPassword();

    /**
     * le nom d'utilisateur du compte mongodb
     * @return le nom d'utilisateur du compte mongodb
     */
    String getUsername();

    /**
     * le nom de la base de donnée mongo utilisée
     * @return le nom de la base de donnée mongo utilisée
     */
    String getDatabase();

}
