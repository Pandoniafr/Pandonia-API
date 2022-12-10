package fr.pandonia.api.player.friends;

import java.util.UUID;

public interface IFriendRequest {
    UUID getFrom();

    long getTime();
}
