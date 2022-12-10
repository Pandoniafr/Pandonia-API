package fr.pandonia.api.events;

import fr.pandonia.api.rank.IRank;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerRankUpdateEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();

    private final IRank oldRank;
    private final IRank newRank;

    public PlayerRankUpdateEvent(Player player, IRank oldRank, IRank newRank) {
        super(player);
        this.oldRank = oldRank;
        this.newRank = newRank;
    }

    public IRank getOldRank() {
        return oldRank;
    }

    public IRank getNewRank() {
        return newRank;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}

