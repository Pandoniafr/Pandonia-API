package fr.pandonia.tools.traduction;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;

public enum ColorTraduction {
    WHITE(DyeColor.WHITE, ChatColor.WHITE),
    ORANGE(DyeColor.ORANGE, ChatColor.GOLD),
    MAGENTA(DyeColor.MAGENTA, ChatColor.LIGHT_PURPLE),
    BLUE(DyeColor.BLUE, ChatColor.BLUE),
    LIGHT_BLUE(DyeColor.LIGHT_BLUE, ChatColor.BLUE),
    YELLOW(DyeColor.YELLOW, ChatColor.YELLOW),
    LIME(DyeColor.LIME, ChatColor.GREEN),
    PINK(DyeColor.PINK, ChatColor.LIGHT_PURPLE),
    GRAY(DyeColor.GRAY, ChatColor.DARK_GRAY),
    SILVER(DyeColor.SILVER, ChatColor.GRAY),
    CYAN(DyeColor.CYAN, ChatColor.DARK_AQUA),
    PURPLE(DyeColor.PURPLE, ChatColor.DARK_PURPLE),
    BROWN(DyeColor.BROWN, ChatColor.GOLD),
    GREEN(DyeColor.GREEN, ChatColor.DARK_GREEN),
    RED(DyeColor.RED, ChatColor.RED),
    BLACK(DyeColor.BLACK, ChatColor.BLACK);

    private DyeColor dyeColor;
    private ChatColor chatColor;

    ColorTraduction(DyeColor dyeColor, ChatColor chatColor) {
        this.dyeColor = dyeColor;
        this.chatColor = chatColor;
    }

    public static ChatColor getChatColorFromDyeColor(DyeColor dyeColor){
        for (ColorTraduction value : ColorTraduction.values()) {
            if(value.dyeColor.equals(dyeColor)){
                return value.chatColor;
            }
        }
        return ChatColor.WHITE;
    }

    public static DyeColor getDyeColorFromChatColor(ChatColor chatColor){
        for (ColorTraduction value : ColorTraduction.values()) {
            if(value.chatColor.equals(chatColor)){
                return value.dyeColor;
            }
        }
        return DyeColor.WHITE;
    }
}
