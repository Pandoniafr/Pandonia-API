package fr.pandonia.api;

import fr.pandonia.api.application.PandoniaApplication;
import fr.pandonia.api.battlepass.manager.IBPItemManager;
import fr.pandonia.api.commands.ICommandsManager;
import fr.pandonia.api.config.PandoniaConfiguration;
import fr.pandonia.api.cosmetics.manager.ICosmeticsManager;
import fr.pandonia.api.data.mongo.IMongoConnection;
import fr.pandonia.api.data.redis.IRedisConnection;
import fr.pandonia.api.data.redis.pubsub.IPSReader;
import fr.pandonia.api.data.redis.pubsub.IPSWriter;
import fr.pandonia.api.games.manager.GameHistoryManager;
import fr.pandonia.api.guild.manager.IGuildManager;
import fr.pandonia.api.images.manager.IImageMapManager;
import fr.pandonia.api.npc.manager.INPCManager;
import fr.pandonia.api.player.battlepass.manager.IPlayerBattlePassManager;
import fr.pandonia.api.player.friends.manager.IFriendsManager;
import fr.pandonia.api.player.manager.IPlayerManager;
import fr.pandonia.api.player.owning.manager.IPlayerOwningManager;
import fr.pandonia.api.player.settings.manager.IPlayerSettingsManager;
import fr.pandonia.api.player.stats.manager.IPlayerStatsManager;
import fr.pandonia.api.proxy.ProxyLink;
import fr.pandonia.api.pubsub.manager.IMessageReceiverManager;
import fr.pandonia.api.rank.manager.IRankManager;
import fr.pandonia.api.sanction.infos.loader.ISanctionsInfosLoader;
import fr.pandonia.api.server.IInstanceInfo;
import fr.pandonia.api.server.manager.IServerManager;
import fr.pandonia.api.tablist.manager.ITeamTagManager;
import fr.pandonia.tools.npc.NPCLib;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class PandoniaAPI implements PandoniaApplication {

    /**
     * Instance principale de la class {@link PandoniaAPI}
     */
    private static PandoniaAPI instance;

    /**
     * Instance du plugin Bukkit
     */
    private final JavaPlugin plugin;

    /**
     * Constructeur principal
     * @param plugin plugin Bukkit
     */
    public PandoniaAPI(JavaPlugin plugin){
        this.plugin = plugin;
    }

    /**
     * Récupère l'instance de la class principale {@link PandoniaAPI}
     * @return l'instance de la class principale {@link PandoniaAPI}
     */
    public static PandoniaAPI get(){
        return PandoniaAPI.instance;
    }

    /**
     * Change l'instane de la class principale de {@link PandoniaAPI}
     *
     * <p><b>Attention:</b> Cette méthode ne peut être appelée qu'avec le core de l'API</p>
     *
     * @param instance La nouvelle instance de la classe principale de {@link PandoniaAPI}
     */
    public static void setPandora(PandoniaAPI instance){
        if(PandoniaAPI.instance != null) {
            throw new IllegalArgumentException("Cannot set new instance of PandoraAPI !");
        }
        PandoniaAPI.instance = instance;
    }

    /**
     * Récupère l'instance du plugin Bukkit
     * @return l'instance du plugin Bukkit
     */
    public JavaPlugin getPlugin(){
        return plugin;
    }

    /**
     * Exécuté au load du plugin
     */
    public abstract void onLoad();

    /**
     * Exécuté au démarrage du plugin
     */
    public abstract void onEnable();

    /**
     * Exécuté à la désactivation du plugin
     */
    public abstract void onDisable();

    /**
     * Initialise la librairie pour les NPCs (method à éxécuter dans le onEnable si besoin des NPCs)
     */
    public abstract void enableNPCs();

    public abstract PandoniaConfiguration getConfiguration();

    /**
     * Récupère la connexion redis initialisée
     * @return la connexion redis initialisée
     */
    public abstract IRedisConnection getRedisConnection();

    /**
     * Récupère la connexion mongo initialisée
     * @return la connexion mongo initialisée
     */
    public abstract IMongoConnection getMongoConnection();

    /**
     * Récupère le gestionnaire de ranks
     * @return le gestionnaire de ranks
     */
    public abstract IRankManager getRankManager();

    /**
     * Récupère le gestionnaire des infos sanctions
     * @return le gestionnaire des infos sanctions
     */
    public abstract ISanctionsInfosLoader getSanctionsInfosLoader();

    /**
     * Récupère le gestionnaire de joueurs
     * @return le gestionnaire de joueurs
     */
    public abstract IPlayerManager getPlayerManager();

    /**
     * Récupère le gestionnaire de PlayerSettings
     * @return le gestionnaire de PlayerSettings
     */
    public abstract IPlayerSettingsManager getPlayerSettingsManager();

    /**
     * Récupère le gestionnaire de PlayerOwning
     * @return le gestionnaire de PlayerOwning
     */
    public abstract IPlayerOwningManager getPlayerOwningManager();

    /**
     * Récupère le gestionnaire de PlayerStats
     * @return le gestionnaire de PlayerStats
     */
    public abstract IPlayerStatsManager getPlayerStatsManager();

    /**
     * Récupère le gestionnaire d'items du battle pass
     * @return le gestionnaire d'items du battle pass
     */
    public abstract IBPItemManager getBattlePassItemsManager();

    /**
     * Récupère le gestionnaire de PlayerBattlePass
     * @return le gestionnaire de PlayerBattlePass
     */
    public abstract IPlayerBattlePassManager getPlayerBattlePassManager();

    /**
     * Récupère le gestionnaire de cosmétiaues
     * @return le gestionnaire de cosmétiaues
     */
    public abstract ICosmeticsManager getCosmeticsManager();

    /**
     * Récupère le gestionnaire de friends
     * @return le gestionnaire de friends
     */
    public abstract IFriendsManager getFriendsManager();

    /**
     * Récupère le créateur d'images
     * @return le créateur d'images
     */
    public abstract IImageMapManager getImageMapManager();

    /**
     * Récupère le gestionnaire de serveurs
     * @return le gestionnaire de serveurs
     */
    public abstract IServerManager getServerManager();

    /**
     * Récupère le gestionnaire du TabList
     * @return le gestionnaire du TabList
     */
    public abstract ITeamTagManager getTeamTagManager();

    /**
     * Récupère le gestionnaire d'historique de games
     * @return le gestionnaire d'historique de games
     */
    public abstract GameHistoryManager getGameHistoryManager();

    /**
     * Récupère le gestionnaire des entrées message pubsub
     * @return le gestionnaire des entrées message pubsub
     */
    public abstract IMessageReceiverManager getMessageReceiverManager();

    /**
     * Récupère l'instance de la librairie NPC
     * @return l'instance de la librairie NPC
     */
    public abstract NPCLib getNPCLib();

    /**
     * Récupère l'instance du PSWriter
     * @return l'instance du PSWriter
     */
    public abstract IPSWriter getPSWriter();

    /**
     * Récupère l'instance du PSReader
     * @return l'instance du PSReader
     */
    public abstract IPSReader getPSReader();

    /**
     * Récupère l'instance de la class singleton qui permet d'envoyer des informations au Proxy
     * @return l'instance de ProxyLink
     */
    public abstract ProxyLink getProxyLink();

    /**
     * Récupère l'instance de la class singleton qui contient les informations sur l'instance
     * @return l'instance de InstanceInfo
     */
    public abstract IInstanceInfo getInstanceInfo();

    /**
     * Récupère le gestionnaire de commandes
     * @return le gestionnaire de commandes
     */
    public abstract ICommandsManager getCommandsManager();

    /**
     * Récupère le gestionnaire de guilds
     * @return le gestionnaire de guilds
     */
    public abstract IGuildManager getGuildManager();

    /**
     * Récupère le gestionnaire de NPCs
     * @return le gestionnaire de NPCs
     */
    public abstract INPCManager getNPCManager();
}
