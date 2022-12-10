package fr.pandonia.api.data.redis.pubsub;

import org.bson.Document;
import redis.clients.jedis.Jedis;

public interface IPSWriter {

    /**
     * Envoi un message PubSub
     * @param channel channel dans lequel sera envoyé le message
     * @param subChannel sous channel qui sera vérifié au niveau de la réception
     * @param msg Message en JSON ({@link Document})
     */
    void send(String channel, String subChannel, Document msg);

}
