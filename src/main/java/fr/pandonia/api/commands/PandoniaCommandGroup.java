package fr.pandonia.api.commands;

import org.bukkit.command.CommandSender;

public abstract class PandoniaCommandGroup {

    private final String name;
    private final int strength;
    private String customName;

    public PandoniaCommandGroup(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public PandoniaCommandGroup(String name, int strength, String customName) {
        this.name = name;
        this.strength = strength;
        this.customName = customName;
    }

    public String getCustomName() {
        return customName;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public abstract boolean hasPermission(CommandSender s);

    public boolean canSee(CommandSender s){
        return hasPermission(s);
    }

}
