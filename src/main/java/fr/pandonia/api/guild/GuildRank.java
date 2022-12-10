package fr.pandonia.api.guild;

import org.bukkit.ChatColor;

public enum GuildRank {

    CHEF("Chef", ChatColor.RED),
    GESTIONNAIRE("Gestionnaire", ChatColor.GOLD),
    MEMBRE("Membre", ChatColor.GRAY);

    private String name;
    private ChatColor color;

    GuildRank(String name, ChatColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }
}
