package fr.pandonia.api.player.friends;

import org.bson.Document;

import java.util.Date;
import java.util.UUID;

public interface IFriendShip {
    UUID getUuid1();

    UUID getUuid2();

    Date getDate();

    Document toDocument();
}
