package fr.pandonia.api.pubsub;

public class Way {

    private String channel;
    private String subChannel;

    public Way(String channel, String subChannel) {
        this.channel = channel;
        this.subChannel = subChannel;
    }

    /**
     * Récupère le channel d'un message pubsub
     * @return le channel d'un message pubsub
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Récupère le subchannel d'un message pubsub
     * @return le subchannel d'un message pubsub
     */
    public String getSubChannel() {
        return subChannel;
    }

}


