package fr.pandonia.api.events;

import fr.pandonia.api.player.IPPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * Evenement déclenché au chargement du compte joueur (à utiliser à la place du {@link org.bukkit.event.player.PlayerJoinEvent})
 */
public class PlayerGetDisplayNameEvent extends PlayerEvent {

    private IPPlayer player;
    private IPPlayer target;
    private String displayName;

    private static final HandlerList handlers = new HandlerList();

    public PlayerGetDisplayNameEvent(Player who, IPPlayer player, IPPlayer target) {
        super(who);
        this.player = player;
        this.target = target;
        this.displayName = player.getNickDisplayName(target);
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public IPPlayer getPPlayer() {
        return player;
    }

    public IPPlayer getTarget() {
        return target;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}