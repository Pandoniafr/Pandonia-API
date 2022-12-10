package fr.pandonia.api.player.nick;

import org.bson.Document;

import java.util.UUID;

public interface ISkinNickInfo {
    UUID getPlayerUUID();

    void setValue(String value);

    void setSignature(String signature);

    String getValue();

    String getSignature();

    void setReset(boolean reset);

    boolean isReset();

    Document toDocument();
}

