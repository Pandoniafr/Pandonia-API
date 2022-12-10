package fr.pandonia.api.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public interface ICommandsManager {

    /**
     * Enregistre toutes les commandes du Core
     */
    void register();

    /**
     * Récupère la liste des commandes autorisé pour un joueur
     * @param p Le joueur
     * @return La liste des commandes
     */
    List<String> getPlayerAllowedCommandLabels(CommandSender p);

    List<IPandoniaPermission> getPermissions();

    List<IPandoniaPermission> getPlayerAllowedCommands(CommandSender p);

    List<IPandoniaPermission> getPlayerSeeCommands(CommandSender s);

    List<PandoniaCommandGroup> getGroups();

    PandoniaCommandGroup getGroup(String name);

    IPandoniaPermission getPermission(String label);

    boolean playerHasPermission(Player p, String label);

    boolean playerCanSee(Player p, String label);

    /**
     * Ajoute un nouveau groupe de permission
     * @param group Le groupe
     */
    void registerGroup(PandoniaCommandGroup group);
}
