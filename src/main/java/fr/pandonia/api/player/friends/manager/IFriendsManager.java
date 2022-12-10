package fr.pandonia.api.player.friends.manager;

import fr.pandonia.api.player.friends.IPlayerFriends;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface IFriendsManager {
    void addPlayerFriends(IPlayerFriends playerFriend);

    void removePlayerFriends(UUID uuid);

    IPlayerFriends getPlayersFriends(UUID playerUUID);

    void onQuit(Player p);
}
