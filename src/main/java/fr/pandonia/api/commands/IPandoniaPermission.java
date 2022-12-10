package fr.pandonia.api.commands;

import org.bukkit.command.Command;

public interface IPandoniaPermission {

    /**
     * Récupère la commande liée à la permission
     * @return la commande
     */
    Command getCommand();

    /**
     * Récupère le groupe
     * @return le groupe
     */
    PandoniaCommandGroup getGroup();
}

