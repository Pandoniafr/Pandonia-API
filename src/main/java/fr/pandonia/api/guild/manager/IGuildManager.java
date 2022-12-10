package fr.pandonia.api.guild.manager;

import fr.pandonia.api.guild.IGuild;

import java.util.List;
import java.util.UUID;

public interface IGuildManager {
    void startTask();

    List<IGuild> getGuilds();

    IGuild getGuild(String name);

    IGuild getGuildByUUID(UUID guildUUID);

    IGuild getGuild(UUID playerUUID);

    boolean uncachePlayer(UUID playerUUID, List<UUID> onlinePlayers);

    void addGuild(IGuild guild);

    void removeGuild(String name);

    void removeGuild(UUID uuid);
}
