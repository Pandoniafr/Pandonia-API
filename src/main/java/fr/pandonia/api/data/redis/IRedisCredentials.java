package fr.pandonia.api.data.redis;

public interface IRedisCredentials {

    /**
     * Récupère l'ip pour la connexion redis
     * @return l'ip pour la connexion redis
     */
    String getIP();

    /**
     * Récupère le port pour la connexion redis
     * @return le port de la connexion redis
     */
    int getPort();

    /**
     * Récupère le mot de passe pour la connexion redis
     * @return le mot de passe pour la connexion redis
     */
    String getPassword();

    /**
     * Récupère le nom d'utilisateur pour la connexion redis
     * @return le nom d'utilisateur pour la connexion redis
     */
    String getClientName();

}

