package fr.pandonia.tools;

import fr.pandonia.api.PandoniaAPI;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ActionBar {
    private final String message;

    public ActionBar(String message){
        this.message = message;
    }

    /**
     * Affiche un texte sur l'action bar d'un joueur donné
     *
     *
     * @param player
     *            Le joueur pour l'action bar
     */
    public void sendActionBar(Player player){
        CraftPlayer p = (CraftPlayer) player;
        IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc,(byte) 2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
    }
    /**
     * Affiche un texte sur l'action bar d'un joueur donné
     *
     *
     * @param player
     *            Le joueur pour l'action bar.
     * @param time
     *            Le temps d'affichage du message.
     */
    public void sendActionBar(Player player, int time){
        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                i++;
                sendActionBar(player);
                if(i==time)
                    cancel();
            }
        }.runTaskTimer(PandoniaAPI.get().getPlugin(), 0, 20);
    }
    /**
     * Affiche un texte sur l'action bar pour tous les joueurs
     *
     */
    public void broadcastActionBar(){
        Bukkit.getOnlinePlayers().forEach(this::sendActionBar);
    }

    /**
     * Affiche un texte sur l'action bar d'un joueur donné
     *
     * @param time
     *            Le temps d'affichage du message.
     */

    public void broadcastActionBar(int time){
        for(Player p : Bukkit.getOnlinePlayers())
            sendActionBar(p, time);
    }
}
