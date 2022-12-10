package fr.pandonia.api.events;

import org.bson.Document;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Evenement déclenché à la réception d'un message pubsub redis
 */
public class PubSubMessageEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private String channel;
    private String subChannel;
    private Document message;

    public PubSubMessageEvent(String channel, String subChannel, Document message){
        this.channel = channel;
        this.subChannel = subChannel;
        this.message = message;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    /**
     * Récupère le channel dans lequel le message est envoyé
     * @return le channel dans lequel le message est envoyé
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Récupère le sous channel dans lequel le message est envoyé
     * @return le sous channel dans lequel le message est envoyé
     */
    public String getSubChannel() {
        return subChannel;
    }

    /**
     * Récupère le message envoyé
     * @return le message envoyé
     */
    public Document getMessage() {
        return message;
    }

}
