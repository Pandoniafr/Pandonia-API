package fr.pandonia.tools.menu;

import fr.pandonia.tools.Heads;
import fr.pandonia.tools.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PandoniaMenuPreset {
    public static DyeColor menuColor = DyeColor.CYAN;
    public static ChatColor textColor = ChatColor.DARK_AQUA;
    public static ChatColor scoreboardColor;

    public static ItemStack getCancelItem(){
        return new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).getSkull(Heads.RED_CROSS).setName("§8» §cAnnuler").toItemStack();
    }

    public static ItemStack getValiderItem(){
        return new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).getSkull(Heads.GREEN_CHECK).setName("§8» §aValider").toItemStack();
    }
}
