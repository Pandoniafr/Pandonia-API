package fr.pandonia.api.events.packets;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PacketWriteEvent extends Event implements Cancellable {

    /**
     * Cet event est appelé à chaque début de jour
     */

    private Object packet;
    private Player player;
    private boolean cancelled;

    public PacketWriteEvent(Object packet, Player player) {
        this.packet = packet;
        this.player = player;
        this.cancelled = false;
    }

    public Object getPacket() {
        return packet;
    }

    public void setPacket(Object packet) {
        this.packet = packet;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    private static final HandlerList handlers = new HandlerList();
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
