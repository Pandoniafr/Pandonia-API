package fr.pandonia.api.player.nick;

import org.bson.Document;

public interface INick {
    String getNick();

    void setNick(String nick);

    String getRankNick();

    void setRankNick(String rankNick);

    String getSkinName();

    void setSkinName(String skinName);

    Document toDocument();
}
