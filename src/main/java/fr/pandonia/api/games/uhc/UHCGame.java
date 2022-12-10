package fr.pandonia.api.games.uhc;

import fr.pandonia.api.PandoniaAPI;
import fr.pandonia.api.games.Game;
import fr.pandonia.api.games.GamePlayer;
import fr.pandonia.api.player.ISimplePlayer;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UHCGame extends Game {

    //Type: 1
    public UHCGame(UUID uuid, String name, String mode, ISimplePlayer host, int type, Date endDate, int duration, List<String> winners, List<GamePlayer> players, List<String> scenarios) {
        super(uuid, name, mode, host, type, endDate, duration, winners, players, scenarios);
    }

    public static UHCGame fromDocument(Document document){
        List<GamePlayer> players = new ArrayList<>();
        document.getList("players", Document.class).forEach(player -> players.add(UHCGamePlayer.fromDocument(player)));
        List<String> scenarios = new ArrayList<>();
        if(document.getList("scenarios", String.class) != null){
            scenarios.addAll(document.getList("scenarios", String.class));
        }
        ISimplePlayer host = null;
        if(document.get("host", Document.class) != null){
            host = PandoniaAPI.get().getPlayerManager().SimplePlayerFromDocument(document.get("host", Document.class));
        }
        return new UHCGame(UUID.fromString(document.getString("uuid")), document.getString("name"), document.getString("mode"), host, document.getInteger("type"), document.getDate("endDate"), document.getInteger("duration"), document.getList("winners", String.class), players, scenarios);
    }

}
