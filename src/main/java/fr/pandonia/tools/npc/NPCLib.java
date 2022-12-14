package fr.pandonia.tools.npc;

import fr.pandonia.tools.npc.api.NPC;
import fr.pandonia.tools.npc.api.utilities.Logger;
import fr.pandonia.tools.npc.listeners.ChunkListener;
import fr.pandonia.tools.npc.listeners.PacketListener;
import fr.pandonia.tools.npc.listeners.PlayerListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class NPCLib {

    private final JavaPlugin plugin;
    private final Logger logger;
    private final Class<?> npcClass;

    private double autoHideDistance = 50.0;

    public NPCLib(JavaPlugin plugin) {
        this.plugin = plugin;
        this.logger = new Logger("NPCLib");

        String versionName = plugin.getServer().getClass().getPackage().getName().split("\\.")[3];

        Class<?> npcClass = null;

        try {
            npcClass = Class.forName("fr.pandorauhc.tools.npc.nms." + versionName + ".NPC_" + versionName);
        } catch (ClassNotFoundException exception) {
            // Version not supported, error below.
        }

        this.npcClass = npcClass;

        if (npcClass == null) {
            logger.severe("Failed to initiate. Your server's version ("
                    + versionName + ") is not supported");
            return;
        }

        PluginManager pluginManager = plugin.getServer().getPluginManager();

        pluginManager.registerEvents(new PlayerListener(this), plugin);
        pluginManager.registerEvents(new ChunkListener(this), plugin);

        // Boot the according packet listener.
        new PacketListener().start(this);

        logger.info("Enabled for Minecraft " + versionName);
    }

    /**
     * @return The JavaPlugin instance.
     */
    public JavaPlugin getPlugin() {
        return plugin;
    }

    /**
     * Set a new value for the auto-hide distance.
     * A recommended value (and default) is 50 blocks.
     *
     * @param autoHideDistance The new value.
     */
    public void setAutoHideDistance(double autoHideDistance) {
        this.autoHideDistance = autoHideDistance;
    }

    /**
     * @return The auto-hide distance.
     */
    public double getAutoHideDistance() {
        return autoHideDistance;
    }

    /**
     * @return The logger NPCLib uses.
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Create a new non-player character (NPC).
     *
     * @param text The text you want to sendShowPackets above the NPC (null = no text).
     * @return The NPC object you may use to sendShowPackets it to players.
     */
    public NPC createNPC(List<String> text) {
        try {
            return (NPC) npcClass.getConstructors()[0].newInstance(this, text);
        } catch (Exception exception) {
            logger.warning("Failed to create NPC. Please report the following stacktrace message: " + exception.getMessage());
        }

        return null;
    }

    /**
     * Create a new non-player character (NPC).
     *
     * @return The NPC object you may use to sendShowPackets it to players.
     */
    public NPC createNPC() {
        return createNPC(null);
    }
}
