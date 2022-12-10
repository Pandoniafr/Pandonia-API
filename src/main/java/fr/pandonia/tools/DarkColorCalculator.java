package fr.pandonia.tools;

import org.bukkit.ChatColor;

public class DarkColorCalculator {

    public static ChatColor getDarkColor(ChatColor color){
        switch (color){
            case RED:
                return ChatColor.DARK_RED;
            case AQUA:
                return ChatColor.DARK_AQUA;
            case DARK_AQUA:
                return ChatColor.BLUE;
            case BLUE:
                return ChatColor.DARK_BLUE;
            case GRAY:
                return ChatColor.DARK_GRAY;
            case GREEN:
                return ChatColor.DARK_GREEN;
            case LIGHT_PURPLE:
                return ChatColor.DARK_PURPLE;
            case YELLOW:
                return ChatColor.GOLD;
            case WHITE:
                return ChatColor.GRAY;
            default:
                return color;
        }
    }

    public static ChatColor getLightColor(ChatColor color){
        switch (color){
            case DARK_RED:
                return ChatColor.RED;
            case DARK_AQUA:
                return ChatColor.AQUA;
            case DARK_BLUE:
                return ChatColor.BLUE;
            case DARK_GRAY:
                return ChatColor.GRAY;
            case DARK_GREEN:
                return ChatColor.GREEN;
            case DARK_PURPLE:
                return ChatColor.LIGHT_PURPLE;
            case GOLD:
                return ChatColor.YELLOW;
            case GRAY:
                return ChatColor.WHITE;
            default:
                return color;
        }
    }

}