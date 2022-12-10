package fr.pandonia.api.pubsub;

import org.bson.Document;

public abstract class MessageReceiver{

    private Document message;

    public MessageReceiver(Document message) {
        this.message = message;
    }

    /**
     * Exécute le {@link MessageReceiver}
     */
    public abstract void execute();

    /**
     * Récupère le message du {@link MessageReceiver}
     * @return message du {@link MessageReceiver}
     */
    public Document getMessage(){
        return message;
    }

}
