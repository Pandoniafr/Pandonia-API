package fr.pandonia.api.proxy;

import fr.pandonia.api.PandoniaAPI;
import fr.pandonia.api.guild.IGuild;
import fr.pandonia.api.player.IPPlayer;
import fr.pandonia.api.player.battlepass.IPlayerBattlePass;
import fr.pandonia.api.player.owning.IPlayerOwning;
import fr.pandonia.api.player.settings.IPlayerSettings;
import fr.pandonia.api.player.stats.IPlayerStats;
import fr.pandonia.api.server.GenSettings;
import fr.pandonia.api.server.IServer;
import fr.pandonia.api.server.ServerStatus;
import org.bson.Document;
import org.bukkit.Bukkit;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProxyLink {

    private PandoniaAPI instance;

    public ProxyLink(PandoniaAPI instance){
        this.instance = instance;
    }

    /**
     * Envoie une demande de récupération de compte joueur au proxy
     * @param playerUUID UUID du joueur
     * @param owning si il veut récupérer l'owning
     * @param settings si il veut récupérer les settings
     * @param stats si il veut récupérer les stats
     * @param friends si il veut récupérer les amis
     */
    public void getAccount(UUID playerUUID, boolean owning, boolean settings, boolean stats, boolean battlePass, boolean friends, boolean guilds){
        instance.getPSWriter().send("api", "getAccount", new Document("playerUUID", playerUUID.toString()).append("owning", owning).append("settings", settings).append("stats", stats).append("battlePass", battlePass).append("friends", friends).append("guilds", guilds));
    }

    /**
     * Envoie une demande de mise à jour du compte
     * @param account compte à mettre à jour
     */
    public void updateAccount(IPPlayer account){
        instance.getPSWriter().send("api", "updateAccount", new Document("playerUUID", account.getUUID().toString()).append("account", account.toDocument()));
    }

    /**
     * Envoie une demande de mise à jour du PlayerOwning
     * @param owning PlayerOwning à mettre à jour
     */
    public void updatePlayerOwning(IPlayerOwning owning){
        instance.getPSWriter().send("api", "updatePlayerOwning", new Document("playerUUID", owning.getPlayerUUID().toString()).append("owning", owning.toDocument()));
    }

    /**
     * Envoie une demande de mise à jour du PlayerSettings
     * @param settings PlayerSettings à mettre à jour
     */
    public void updatePlayerSettings(IPlayerSettings settings){
        instance.getPSWriter().send("api", "updatePlayerSettings", new Document("playerUUID", settings.getPlayerUUID().toString()).append("settings", settings.toDocument()));
    }

    /**
     * Envoie une demande de mise à jour du nick d'un joueur
     * @param player Player à mettre à jour
     */
    public void updatePlayerNick(IPPlayer player){
        instance.getPSWriter().send("api", "playerNickUpdate", new Document("playerUUID", player.getUUID().toString()).append("nick", player.getNick() == null ? null : player.getNick().toDocument()));
    }

    /**
     * Envoie une demande de mise à jour du nick d'un joueur
     * @param player Player à mettre à jour
     */
    public void updatePlayerNick(IPPlayer player, String skinValue, String skinSignature){
        instance.getPSWriter().send("api", "playerNickUpdate", new Document("playerUUID", player.getUUID().toString()).append("nick", player.getNick() == null ? null : player.getNick().toDocument()).append("value", skinValue).append("signature", skinSignature).append("reset", player.getNick() == null));
    }

    /**
     * Envoie une demande de mise à jour du PlayerStats
     * @param stats PlayerStats à mettre à jour
     */
    public void updatePlayerStats(IPlayerStats stats){
        instance.getPSWriter().send("api", "updatePlayerStats", new Document("playerUUID", stats.getPlayerUUID().toString()).append("stats", stats.toDocument()));
    }

    /**
     * Envoie une demande de mise à jour de la guilde
     * @param guild Guild à mettre à jour
     */
    public void updateGuild(IGuild guild){
        instance.getPSWriter().send("proxy", "updateGuild", new Document("guild", guild.toDocument()));
    }

    /**
     * Envoie une demande de mise à jour sur toutes les informations joueur
     * @param playerUUID UUID du joueur
     */
    public void updateAllPlayer(UUID playerUUID){
        IPPlayer player = instance.getPlayerManager().getPlayer(playerUUID);
        IPlayerOwning owning = instance.getPlayerOwningManager().getPlayerOwning(playerUUID);
        IPlayerSettings settings = instance.getPlayerSettingsManager().getPlayerSettings(playerUUID);
        IPlayerStats stats = instance.getPlayerStatsManager().getPlayerStats(playerUUID);
        IPlayerBattlePass battlePass = instance.getPlayerBattlePassManager().getPlayerBattlePass(playerUUID);
        Document document = new Document("playerUUID", playerUUID.toString());
        if (player != null){
            document.append("account", player.toDocument());
        }
        if (owning != null){
            document.append("owning", owning.toDocument());
        }
        if (settings != null){
            document.append("settings", settings.toDocument());
            System.out.println(settings.isVanish());
        }
        if (stats != null){
            document.append("stats", stats.toDocument());
        }
        if (battlePass != null){
            document.append("battlePass", battlePass.toDocument());
        }
        instance.getPSWriter().send("api", "updateAllPlayer", document);
    }

    /**
     * Envoie une demande de modification de status de cette instance
     * @param status Nouveau status
     */
    public void setServerStatus(ServerStatus status){
        setServerStatus(instance.getInstanceInfo().getName(), status);
    }

    /**
     * Envoie une demande de modification de status d'un serveur
     * @param serverName Nom du serveur que l'on veut modifier
     * @param status Nouveau status
     */
    public void setServerStatus(String serverName, ServerStatus status){
        instance.getPSWriter().send("api", "setServerStatus", new Document("serverName", serverName).append("status", status.getName()));
    }

    /**
     * Envoie une demande de changement de serveur
     * @param playerUUID UUID du joueur
     * @param serverName serveur destination
     */
    public void changeServer(UUID playerUUID, String serverName){
        instance.getPSWriter().send("api", "changeServer", new Document("target", serverName).append("playerUUID", playerUUID.toString()));
    }

    /**
     * Envoie une demande d'ajout à une file d'attente
     * @param playerUUID UUID du joueur à ajouter à la file
     * @param serverName Nom du serveur ou ajouter
     */
    public void addToQueue(UUID playerUUID, String serverName){
        instance.getPSWriter().send("api", "addToQueue", new Document("server", serverName).append("playerUUID", playerUUID.toString()));
    }

    /**
     * Envoie une demande de modification des slots
     * @param slots Nouveau nombre de slots
     */
    public void setServerSlots(int slots){
        instance.getPSWriter().send("api", "setSlots", new Document("serverName", PandoniaAPI.get().getInstanceInfo().getName()).append("slots", slots));
    }

    /**
     * Envoie une demande de modification de nombre de specateurs
     * @param specs Nouveau nombre de spectateurs
     */
    public void setSpecatorsNumber(int specs){
        System.out.println(specs + " specs");
        instance.getPSWriter().send("api", "setSpectatorsNumber", new Document("serverName", PandoniaAPI.get().getInstanceInfo().getName()).append("specs", specs));
    }

    /**
     * Envoie une demande de modification du status de la whitelist de cette instance
     * @param bool Nouvelle valeur
     */
    public void setWhitelistStatus(boolean bool){
        instance.getPSWriter().send("api", "setWhitelistStatus", new Document("serverName", instance.getInstanceInfo().getName()).append("whitelistStatus", bool));
    }

    /**
     * Envoie une demande de modification du status de la file d'attente de cette instance
     * @param bool Nouvelle valeur
     */
    public void setQueueStatus(boolean bool){
        instance.getPSWriter().send("api", "setQueueStatus", new Document("serverName", instance.getInstanceInfo().getName()).append("queueStatus", bool));
    }

    /**
     * Envoie une demande pour ajouter un scénario
     * @param scenario Scenario à ajouter
     */
    public void addScenario(String scenario){
        instance.getPSWriter().send("api", "addScenario", new Document("serverName", instance.getInstanceInfo().getName()).append("scenario", scenario));
    }

    /**
     * Envoie une demande pour retirer un scénario
     * @param scenario Scenario à retirer
     */
    public void removeScenario(String scenario){
        instance.getPSWriter().send("api", "removeScenario", new Document("serverName", instance.getInstanceInfo().getName()).append("scenario", scenario));
    }

    /**
     * Envoie une demande d'ajout d'un joueur à la whitelist de cette instance
     * @param name Nom du joueur à ajouter
     */
    public void addPlayerToWhitelist(String name){
        instance.getPSWriter().send("api", "addPlayerToWhitelist", new Document("serverName", instance.getInstanceInfo().getName()).append("player", name));
    }

    /**
     * Envoie une demande d'ajout d'une liste de joueurs à la whitelist de cette instance
     * @param players Liste des joueurs
     */
    public void addPlayerListToWhitelist(List<String> players){
        instance.getPSWriter().send("api", "addPlayerListToWhitelist", new Document("serverName", instance.getInstanceInfo().getName()).append("players", players));
    }

    /**
     * Envoie une demande pour retirer d'un joueur à la whitelist de cette instance
     * @param name Nom du joueur à retirer
     */
    public void removePlayerToWhitelist(String name){
        instance.getPSWriter().send("api", "removePlayerToWhitelist", new Document("serverName", instance.getInstanceInfo().getName()).append("player", name));
    }

    public void addPlayersToServer(List<UUID> uuids){
        instance.getPSWriter().send("api", "addPlayersToServer", new Document("uuids", uuids.stream().map(UUID::toString).collect(Collectors.toList())).append("serverName", instance.getInstanceInfo().getServer().getName()));
    }

    public void removePlayersToServer(List<UUID> uuids){
        instance.getPSWriter().send("api", "removePlayersToServer", new Document("uuids", uuids.stream().map(UUID::toString).collect(Collectors.toList())).append("serverName", instance.getInstanceInfo().getServer().getName()));
    }

    /**
     *
     *
     * ANCIENS
     *
     *
     */


    /**
     * Envoie une annonce de serveur dans les lobbies
     * @param serverName Nom du serveur à annoncer
     */
    public void annonceServer(String serverName, IServer server){
        instance.getPSWriter().send("proxy", "annonceServer", new Document("serverName", serverName).append("server", server.toDocument()));
    }

    /**
     * Envoie un message dans les lobbies
     * @param message Message à envoyer
     */
    public void sendMessageInLobbies(String message){
        instance.getPSWriter().send("api", "sendMessageInLobbies", new Document("message", message));
    }

    /**
     * Envoie un message de récompense de casino
     * @param player Joueur qui a remporté le lot
     * @param reward Lot gagne
     * @param hover Message en hover
     */
    public void sendCasinoWinMessage(String player, String reward, String hover){
        instance.getPSWriter().send("api", "sendCasinoWinMessage", new Document("reward", reward).append("hover", hover).append("player", player));
    }

    /**
     * Envoie une demande de création de serveur
     * @param player Joueur qui demande la création
     * @param serverType Type de serveur à créer
     */
    public void createServer(IPPlayer player, String serverType){
        instance.getPSWriter().send("api", "createServer", new Document("type", serverType).append("player", player.getUUID().toString()));
    }

    /**
     * Envoie une demande de création de serveur
     * @param player Joueur qui demande la création
     * @param serverType Type de serveur à créer
     * @param genSettings Les paramètres de génération
     */
    public void createServer(IPPlayer player, String serverType, GenSettings genSettings){
        instance.getPSWriter().send("api", "createServer", new Document("type", serverType).append("player", player.getUUID().toString()).append("genSettings", genSettings.toDocument()));
    }

    public void updateAlivePlayers(String update, UUID ... uuids){
        instance.getPSWriter().send("api", "updateAlivePlayers", new Document("update", update).append("serverName", PandoniaAPI.get().getInstanceInfo().getServer().getName()).append("alivePlayers", Arrays.stream(uuids).map(UUID::toString).collect(Collectors.toList())));
    }

    /**
     * Envoie une demande pour retirer un host
     * @param player Joueur à qui retirer l'host
     */
    public void removeHost(UUID player){
        instance.getPSWriter().send("api", "removeHost", new Document("player", player.toString()));
    }

    /**
     * Envoie une demande de fermeture et de suppression d'un serveur/instance
     * @param serverName Nom du server à fermer
     * @param player Joueur qui demande la suppression
     */
    public void deleteServer(String serverName, UUID player){
        instance.getPSWriter().send("api", "deleteServer", new Document("serverName", serverName).append("player", player.toString()));
        Bukkit.getScheduler().runTaskLater(instance.getPlugin(), Bukkit::shutdown, 20L);
    }

    /**
     * Envoie une demande de fermeture et de suppression d'un serveur/instance
     * @param serverName Nom du server à fermer
     */
    public void deleteServer(String serverName){
        instance.getPSWriter().send("api", "deleteServer", new Document("serverName", serverName));
        Bukkit.getScheduler().runTaskLater(instance.getPlugin(), Bukkit::shutdown, 20L);
    }

    /**
     * Envoie une demande de modification de nom de serveur
     * @param customName Nouveau nom du serveur
     */
    public void setCustomName(String customName){
        instance.getPSWriter().send("api", "setServerCustomName", new Document("serverName", PandoniaAPI.get().getInstanceInfo().getName()).append("customName", customName));
    }

    /**
     * Envoie une demande pour changer le status de partie officielle
     */
    public void toggleOfficial(){
        instance.getInstanceInfo().setOfficialLocal(!instance.getInstanceInfo().isOfficial());
        instance.getPSWriter().send("api", "toggleOfficial", new Document("serverName", instance.getInstanceInfo().getName()));
    }

    /**
     * Envoie une demande pour envoyer un joueur au lobby
     * @param uuid UUID du joueur à renvoyer au lobby
     */
    public void sendToLobby(UUID uuid){
        instance.getPSWriter().send("api", "sendToLobby", new Document("uuid", uuid.toString()));
    }

    /**
     * Envoie une demande d'éxécution de commande Proxy par un joueur
     * @param uuid UUID du joueur qui éxécute la commande
     * @param command Commande à éxécuter
     */
    public void sendCommand(UUID uuid, String command){
        instance.getPSWriter().send("api", "sendCommand", new Document("player", uuid.toString()).append("command", command));
    }

    /**
     * Envoie une demande pour modifier l'host principal de la partie
     * @param serverName Nom du serveur ou modifier l'hsot de la partie
     * @param newPlayer UUID du nouvel host
     */
    public void setGameHost(String serverName, UUID newPlayer){
        instance.getPSWriter().send("api", "setGameHost", new Document("server", serverName).append("newHost", newPlayer.toString()));
    }

    /**
     * Envoie une demande pour rejoindre la file d'attente d'un mini-jeu
     * @param serverType Nom du servertype à rejoindre
     * @param playerUUID UUID du joueur
     */
    public void addToMiniGameQueue(String serverType, UUID playerUUID){
        instance.getPSWriter().send("api", "addToMiniGameQueue", new Document("serverType", serverType).append("playerUUID", playerUUID.toString()));
    }

    public void giveDiscordRank(UUID playerUUID, String discordRank){
        instance.getPSWriter().send("api", "giveDiscordRank", new Document("playerUUID", playerUUID.toString()).append("discordRank", discordRank));
    }

    public void setServerLinkNeeded(String serverName, boolean status){
        instance.getPSWriter().send("api", "setServerLinkNeeded", new Document("serverName", serverName).append("status", status));
    }

}
