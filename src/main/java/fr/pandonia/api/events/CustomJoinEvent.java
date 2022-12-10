package fr.pandonia.api.events;

import fr.pandonia.api.player.IPPlayer;
import fr.pandonia.api.player.owning.IPlayerOwning;
import fr.pandonia.api.player.settings.IPlayerSettings;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * Evenement déclenché au chargement du compte joueur (à utiliser à la place du {@link org.bukkit.event.player.PlayerJoinEvent})
 */
public class CustomJoinEvent extends PlayerEvent {

    private IPPlayer player;
    private IPlayerSettings settings;
    private IPlayerOwning playerOwning;

    public CustomJoinEvent(Player who, IPPlayer player, IPlayerSettings settings, IPlayerOwning playerOwning) {
        super(who);
        this.player = player;
        this.settings = settings;
        this.playerOwning = playerOwning;
    }

    public IPPlayer getPPlayer() {
        return player;
    }

    public IPlayerSettings getSettings() {
        return settings;
    }

    public IPlayerOwning getPlayerOwning() {
        return playerOwning;
    }

    private static final HandlerList handlers = new HandlerList();

    public CustomJoinEvent(Player playerJoined) {
        super(playerJoined);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}
