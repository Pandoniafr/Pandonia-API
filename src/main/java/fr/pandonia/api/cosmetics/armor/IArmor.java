package fr.pandonia.api.cosmetics.armor;

import fr.pandonia.api.cosmetics.ICosmetic;
import fr.pandonia.tools.playerequiparmor.ArmorType;
import org.bukkit.inventory.ItemStack;

public interface IArmor extends ICosmetic {
    String getName(ArmorType armorType);

    ItemStack getPiece(ArmorType armorType);
}
