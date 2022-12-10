package fr.pandonia.api.events.tablist;

import fr.pandonia.api.tablist.ITeamTagView;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class TeamTagViewSetToPlayer extends PlayerEvent {

    private ITeamTagView view;
    private boolean cancelled;

    public TeamTagViewSetToPlayer(Player who, ITeamTagView view) {
        super(who);
        this.view = view;
        this.cancelled = false;
    }

    public ITeamTagView getView() {
        return view;
    }

    public void setView(ITeamTagView view) {
        this.view = view;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}

