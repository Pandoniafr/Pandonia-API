package fr.pandonia.tools.hologram;

import fr.pandonia.tools.npc.internal.MinecraftVersion;
import fr.pandonia.tools.npc.utils.Reflection;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Hologram {

    private final List<Object> armorStands = new ArrayList<>();
    private final List<Object> showPackets = new ArrayList<>();
    private final List<Object> hidePackets = new ArrayList<>();

    private static final double DELTA = 0.3;

    // Classes:
    private static final Class<?> CHAT_COMPONENT_TEXT_CLAZZ = Reflection.getMinecraftClass("ChatComponentText");
    private static final Class<?> CHAT_BASE_COMPONENT_CLAZZ = Reflection.getMinecraftClass("IChatBaseComponent");
    private static final Class<?> ENTITY_ARMOR_STAND_CLAZZ = Reflection.getMinecraftClass("EntityArmorStand");
    private static final Class<?> ENTITY_LIVING_CLAZZ = Reflection.getMinecraftClass("EntityLiving");
    private static final Class<?> ENTITY_CLAZZ = Reflection.getMinecraftClass("Entity");
    private static final Class<?> CRAFT_BUKKIT_CLASS = Reflection.getCraftBukkitClass("CraftWorld");
    private static final Class<?> CRAFT_PLAYER_CLAZZ = Reflection.getCraftBukkitClass("entity.CraftPlayer");
    private static final Class<?> PACKET_PLAY_OUT_SPAWN_ENTITY_LIVING_CLAZZ = Reflection.getMinecraftClass(
            "PacketPlayOutSpawnEntityLiving");
    private static final Class<?> PACKET_PLAY_OUT_ENTITY_DESTROY_CLAZZ = Reflection.getMinecraftClass(
            "PacketPlayOutEntityDestroy");
    private static final Class<?> PACKET_PLAY_OUT_ENTITY_METADATA_CLAZZ = Reflection.getMinecraftClass(
            "PacketPlayOutEntityMetadata");
    private static final Class<?> DATAWATCHER_CLAZZ = Reflection.getMinecraftClass("DataWatcher");
    private static final Class<?> ENTITY_PLAYER_CLAZZ = Reflection.getMinecraftClass("EntityPlayer");
    private static final Class<?> PLAYER_CONNECTION_CLAZZ = Reflection.getMinecraftClass("PlayerConnection");
    private static final Class<?> PACKET_CLAZZ = Reflection.getMinecraftClass("Packet");

    // Constructors:
    private static final Reflection.ConstructorInvoker CHAT_COMPONENT_TEXT_CONSTRUCTOR = Reflection
            .getConstructor(CHAT_COMPONENT_TEXT_CLAZZ, String.class);
    private static final Reflection.ConstructorInvoker PACKET_PLAY_OUT_SPAWN_ENTITY_LIVING_CONSTRUCTOR = Reflection
            .getConstructor(PACKET_PLAY_OUT_SPAWN_ENTITY_LIVING_CLAZZ, ENTITY_LIVING_CLAZZ);
    private static final Reflection.ConstructorInvoker PACKET_PLAY_OUT_ENTITY_DESTROY_CONSTRUCTOR = Reflection
            .getConstructor(PACKET_PLAY_OUT_ENTITY_DESTROY_CLAZZ, int[].class);
    private static final Reflection.ConstructorInvoker PACKET_PLAY_OUT_ENTITY_METADATA_CONSTRUCTOR = Reflection
            .getConstructor(PACKET_PLAY_OUT_ENTITY_METADATA_CLAZZ, int.class, DATAWATCHER_CLAZZ, boolean.class);

    // Fields:
    private static final Reflection.FieldAccessor playerConnectionField = Reflection.getField(ENTITY_PLAYER_CLAZZ,
            "playerConnection", PLAYER_CONNECTION_CLAZZ);

    // Methods:
    private static final Reflection.MethodInvoker SET_LOCATION_METHOD = Reflection.getMethod(ENTITY_ARMOR_STAND_CLAZZ,
            "setLocation", double.class, double.class, double.class, float.class, float.class);
    private static final Reflection.MethodInvoker SET_SMALL_METHOD = Reflection.getMethod(ENTITY_ARMOR_STAND_CLAZZ,
            "setSmall", boolean.class);
    private static final Reflection.MethodInvoker SET_INVISIBLE_METHOD = Reflection.getMethod(ENTITY_ARMOR_STAND_CLAZZ,
            "setInvisible", boolean.class);
    private static final Reflection.MethodInvoker SET_BASE_PLATE_METHOD = Reflection.getMethod(ENTITY_ARMOR_STAND_CLAZZ,
            "setBasePlate", boolean.class);
    private static final Reflection.MethodInvoker SET_ARMS_METHOD = Reflection.getMethod(ENTITY_ARMOR_STAND_CLAZZ,
            "setArms", boolean.class);
    private static final Reflection.MethodInvoker PLAYER_GET_HANDLE_METHOD = Reflection.getMethod(CRAFT_PLAYER_CLAZZ,
            "getHandle");
    private static final Reflection.MethodInvoker SEND_PACKET_METHOD = Reflection.getMethod(PLAYER_CONNECTION_CLAZZ,
            "sendPacket", PACKET_CLAZZ);
    private static final Reflection.MethodInvoker GET_ID_METHOD = Reflection.getMethod(ENTITY_ARMOR_STAND_CLAZZ,
            "getId");
    private static final Reflection.MethodInvoker GET_DATAWATCHER_METHOD = Reflection.getMethod(ENTITY_CLAZZ,
            "getDataWatcher");

    private final MinecraftVersion version;
    private final Location start;
    private final Object worldServer;

    private List<String> text;

    public Hologram(MinecraftVersion version, Location location, List<String> text) {
        this.version = version;
        this.start = location;
        this.text = text;

        this.worldServer = Reflection.getMethod(CRAFT_BUKKIT_CLASS, "getHandle")
                .invoke(CRAFT_BUKKIT_CLASS.cast(location.getWorld()));

        createPackets();
    }

    private void createPackets() {
        Reflection.MethodInvoker gravityMethod = (version.isAboveOrEqual(MinecraftVersion.V1_9_R2) ?
                Reflection.getMethod(ENTITY_CLAZZ, "setNoGravity", boolean.class) :
                Reflection.getMethod(ENTITY_ARMOR_STAND_CLAZZ, "setGravity", boolean.class));

        Reflection.MethodInvoker customNameMethod = (version.isAboveOrEqual(MinecraftVersion.V1_12_R1)
                ? Reflection.getMethod(ENTITY_CLAZZ, "setCustomName", version.isAboveOrEqual(MinecraftVersion.V1_13_R1) ? CHAT_BASE_COMPONENT_CLAZZ : String.class)
                : Reflection.getMethod(ENTITY_ARMOR_STAND_CLAZZ, "setCustomName", String.class));

        Reflection.MethodInvoker customNameVisibilityMethod = (version.isAboveOrEqual(MinecraftVersion.V1_12_R1) ?
                Reflection.getMethod(ENTITY_CLAZZ, "setCustomNameVisible", boolean.class) :
                Reflection.getMethod(ENTITY_ARMOR_STAND_CLAZZ, "setCustomNameVisible", boolean.class));

        Location location = start.clone().add(0, DELTA * text.size(), 0);
        Class<?> worldClass = worldServer.getClass().getSuperclass();

        if (start.getWorld().getEnvironment() != World.Environment.NORMAL) {
            worldClass = worldClass.getSuperclass();
        }

        Reflection.ConstructorInvoker entityArmorStandConstructor = (version.isAboveOrEqual(MinecraftVersion.V1_14_R1) ?
                Reflection.getConstructor(ENTITY_ARMOR_STAND_CLAZZ, worldClass, double.class, double.class, double.class) :
                Reflection.getConstructor(ENTITY_ARMOR_STAND_CLAZZ, worldClass));

        for (String line : text) {
            Object entityArmorStand = (version.isAboveOrEqual(MinecraftVersion.V1_14_R1) ?
                    entityArmorStandConstructor.invoke(worldServer, location.getX(), location.getY(), location.getZ()) :
                    entityArmorStandConstructor.invoke(worldServer));

            if (!version.isAboveOrEqual(MinecraftVersion.V1_14_R1)) {
                SET_LOCATION_METHOD.invoke(entityArmorStand, location.getX(), location.getY(), location.getZ(), 0, 0);
            }

            customNameMethod.invoke(entityArmorStand, version.isAboveOrEqual(MinecraftVersion.V1_13_R1) ?
                    CHAT_COMPONENT_TEXT_CONSTRUCTOR.invoke(line) : line);
            customNameVisibilityMethod.invoke(entityArmorStand, true);
            gravityMethod.invoke(entityArmorStand, version.isAboveOrEqual(MinecraftVersion.V1_9_R2));
            SET_SMALL_METHOD.invoke(entityArmorStand, true);
            SET_INVISIBLE_METHOD.invoke(entityArmorStand, true);
            SET_BASE_PLATE_METHOD.invoke(entityArmorStand, false);
            SET_ARMS_METHOD.invoke(entityArmorStand, false);

            armorStands.add(entityArmorStand);

            // Create and add the associated show and hide packets.
            showPackets.add(PACKET_PLAY_OUT_SPAWN_ENTITY_LIVING_CONSTRUCTOR.invoke(entityArmorStand));
            hidePackets.add(PACKET_PLAY_OUT_ENTITY_DESTROY_CONSTRUCTOR
                    .invoke(new int[]{(int) GET_ID_METHOD.invoke(entityArmorStand)}));

            location.subtract(0, DELTA, 0);
        }
    }

    public List<Object> getUpdatePackets(List<String> text) {
        List<Object> updatePackets = new ArrayList<>();

        if (this.text.size() != text.size()) {
            throw new IllegalArgumentException("When updating the text, the old and new text should have the same amount of lines");
        }

        Reflection.MethodInvoker customNameMethod = (version.isAboveOrEqual(MinecraftVersion.V1_12_R1)
                ? Reflection.getMethod(ENTITY_CLAZZ, "setCustomName", version.isAboveOrEqual(MinecraftVersion.V1_13_R1) ? CHAT_BASE_COMPONENT_CLAZZ : String.class)
                : Reflection.getMethod(ENTITY_ARMOR_STAND_CLAZZ, "setCustomName", String.class));

        for (int i = 0; i < text.size(); i++) {
            Object entityArmorStand = armorStands.get(i);
            String oldLine = this.text.get(i);
            String newLine = text.get(i);

            customNameMethod.invoke(entityArmorStand, version.isAboveOrEqual(MinecraftVersion.V1_13_R1) ?
                    CHAT_COMPONENT_TEXT_CONSTRUCTOR.invoke(newLine) : newLine); // Update the DataWatcher object.
            showPackets.set(i, PACKET_PLAY_OUT_SPAWN_ENTITY_LIVING_CONSTRUCTOR.invoke(entityArmorStand));

            if (newLine.isEmpty() && !oldLine.isEmpty()) {
                updatePackets.add(hidePackets.get(i));
            } else if (!newLine.isEmpty() && oldLine.isEmpty()) {
                updatePackets.add(showPackets.get(i));
            } else if (!oldLine.equals(newLine)) {
                // Update the line for all players using a Metadata packet.
                updatePackets.add(PACKET_PLAY_OUT_ENTITY_METADATA_CONSTRUCTOR.invoke(
                        GET_ID_METHOD.invoke(entityArmorStand),
                        GET_DATAWATCHER_METHOD.invoke(entityArmorStand),
                        true
                ));
            }
        }

        this.text = text;

        return updatePackets;
    }

    public void update(Player player, List<Object> updatePackets) {
        Object playerConnection = playerConnectionField.get(PLAYER_GET_HANDLE_METHOD
                .invoke(CRAFT_PLAYER_CLAZZ.cast(player)));

        for (Object packet : updatePackets) {
            SEND_PACKET_METHOD.invoke(playerConnection, packet);
        }
    }

    public void show(Player player) {
        Object playerConnection = playerConnectionField.get(PLAYER_GET_HANDLE_METHOD
                .invoke(CRAFT_PLAYER_CLAZZ.cast(player)));

        for (int i = 0; i < text.size(); i++) {
            if (text.get(i).isEmpty()) continue; // No need to spawn the line.
            SEND_PACKET_METHOD.invoke(playerConnection, showPackets.get(i));
        }
    }

    public void hide(Player player) {
        Object playerConnection = playerConnectionField.get(PLAYER_GET_HANDLE_METHOD
                .invoke(CRAFT_PLAYER_CLAZZ.cast(player)));

        for (int i = 0; i < text.size(); i++) {
            if (text.get(i).isEmpty()) continue; // No need to hide the line (as it was never spawned).
            SEND_PACKET_METHOD.invoke(playerConnection, hidePackets.get(i));
        }
    }
}