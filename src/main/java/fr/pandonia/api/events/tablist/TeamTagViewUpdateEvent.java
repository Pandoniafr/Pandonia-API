package fr.pandonia.api.events.tablist;

import fr.pandonia.api.tablist.ITeamTag;
import fr.pandonia.api.tablist.ITeamTagView;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TeamTagViewUpdateEvent extends Event {

    private ITeamTagView view;
    private String player;
    private String prefix;
    private String suffix;
    private int priority;
    private boolean hideNameTag;
    private boolean cancelled;
    private TeamSetEvent event;

    public TeamTagViewUpdateEvent(ITeamTagView view, String player, String prefix, String suffix, int priority, boolean hideNameTag) {
        this.view = view;
        this.player = player;
        this.prefix = prefix;
        this.suffix = suffix;
        this.priority = priority;
        this.hideNameTag = hideNameTag;
        this.cancelled = false;
    }

    public TeamSetEvent getTeamSetEvent() {
        return event;
    }

    public void setTeamSetEvent(TeamSetEvent event) {
        this.event = event;
    }

    public ITeamTagView getView() {
        return view;
    }

    public String getPlayer() {
        return player;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isHideNameTag() {
        return hideNameTag;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setHideNameTag(boolean hideNameTag) {
        this.hideNameTag = hideNameTag;
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

    public interface TeamSetEvent{
        void onTeamSet(ITeamTag teamTag);
    }

}
