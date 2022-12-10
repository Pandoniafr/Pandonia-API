package fr.pandonia.api.data.redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public interface IPSReader {

    /**
     * Démarre le thread d'écoute
     */
    void register();

    /**
     * A executer à la fermeture du programme
     */
    void close();

    /**
     * Ajoute une liste de channel au {@link IPSReader}
     * @param channels les channels à ajouter
     */
    void addChannels(String... channels);

    /**
     * Ajoute un channel au {@link IPSReader}
     * @param channel le channel à ajouter
     */
    void addChannel(String channel);

    /**
     * Récupère la connexion jedis
     * @return la connexion jedis
     */
    Jedis getJedis();

    /**
     * Récupère la connexion Jedis PubSub
     * @return la connexion Jedis PubSub
     */
    JedisPubSub getJedisPubSub();

    /**
     * Récupère la liste des channels
     * @return la liste des channels
     */
    String[] getChannels();

}

