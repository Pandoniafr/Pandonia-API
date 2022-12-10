package fr.pandonia.api.player.friends;

import net.minecraft.server.v1_8_R3.ItemStack;
import org.bson.Document;

import java.util.Date;
import java.util.UUID;

public interface IFriend {
    void setName(String name);

    UUID getUuid();

    String getName();

    Date getDate();

    void setOnline(boolean online);

    void loadHead();

    Document toDocument();

    ItemStack getHead();
}
