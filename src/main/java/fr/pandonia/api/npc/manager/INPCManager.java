package fr.pandonia.api.npc.manager;

import fr.pandonia.tools.npc.PandoniaNPC;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.List;

public interface INPCManager extends Listener {

    /**
     * Active la librairie des NPC
     */
    void enableNPCs();

    /**
     * Méthode à éxecuter lors de la connexion d'un joueur
     * @param p
     */
    void onJoin(Player p);

    /**
     * Ajoute un NPC
     * @param npc npc à ajouter
     */
    void addNPC(PandoniaNPC npc);

    /**
     * Récupère la liste des NPC enregistrés
     * @return la liste des NPC enregistrés
     */
    List<PandoniaNPC> getNPCs();

    /**
     * Recupère si les NPCs sont activés
     * @return si les NPCs sont activés
     */
    boolean isEnabled();

}
