package fr.pandonia.api.application;

import fr.pandonia.api.data.mongo.IMongoConnection;
import fr.pandonia.api.data.redis.IRedisConnection;

public interface PandoniaApplication {
    IRedisConnection getRedisConnection();

    IMongoConnection getMongoConnection();
}
