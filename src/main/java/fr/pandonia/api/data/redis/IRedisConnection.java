package fr.pandonia.api.data.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public interface IRedisConnection {

    /**
     * Créé la connexion jedis
     * @param redisCredentials les credentials de la connexion
     * @param database le numéro de la base de donnée
     * @return le jedis pool créé
     */
    JedisPool setupJedis(IRedisCredentials redisCredentials, int database);

    /**
     * Initialise la connexion jedis
     */
    void init();

    /**
     * Ferme la connexion jedis
     */
    void close();

    /**
     * Récupère le JedisPool
     * @return jedis pool
     */
    JedisPool getJedisPool();

    /**
     * Récupère l'instance Jedis et la reconstruit si détruite
     * @return l'instance Jedis
     */
    Jedis getResource();
}

