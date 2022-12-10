package fr.pandonia.api.player.settings;

import fr.pandonia.tools.playerequiparmor.ArmorType;
import org.bson.Document;

public interface IPlayerArmorSettings {
    int getActivePieceID(ArmorType armorType);

    void setActivePieceID(ArmorType armorType, int value);

    Document toDocument();
}

