package fr.pandonia.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerVanishEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancelled;
    private boolean enabled;

    public PlayerVanishEvent(Player who, boolean enabled) {
        super(who);
        this.cancelled = false;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}