package fr.pandonia.api.player.friends;

import org.bson.Document;

import java.util.List;
import java.util.UUID;

public interface IPlayerFriends {


    UUID getPlayerUUID();

    List<IFriend> getFriends();

    boolean isFriendWith(UUID uuid);

    IFriend getFriend(UUID uuid);

    IFriendRequest getFriendRequest(UUID from);

    void sendFriendRequest(UUID from);

    void sendFriendAccept(UUID from, String name);

    Document toDocument();

    List<UUID> getAsks();
}
