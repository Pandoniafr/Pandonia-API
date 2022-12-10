package fr.pandonia.api.games.uhc.role;

import fr.pandonia.api.PandoniaAPI;
import fr.pandonia.api.games.GamePlayer;
import fr.pandonia.api.games.uhc.UHCGame;
import fr.pandonia.api.player.ISimplePlayer;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UHCRoleGame extends UHCGame {

    private String winnerCamp;

    //Type: 2
    public UHCRoleGame(UUID uuid, String name, String mode, ISimplePlayer host, int type, Date endDate, int duration, List<String> winners, List<GamePlayer> players, List<String> scenarios, String winnerCamp) {
        super(uuid, name, mode, host, type, endDate, duration, winners, players, scenarios);
        this.winnerCamp = winnerCamp;
    }

    public String getWinnerCamp() {
        return winnerCamp;
    }

    @Override
    public Document toDocument() {
        return super.toDocument().append("winnerCamp", winnerCamp);
    }

    public static UHCRoleGame fromDocument(Document document){
        List<GamePlayer> players = new ArrayList<>();
        document.getList("players", Document.class).forEach(player -> players.add(UHCRoleGamePlayer.fromDocument(player)));
        List<String> scenarios = new ArrayList<>();
        if(document.getList("scenarios", String.class) != null){
            scenarios.addAll(document.getList("scenarios", String.class));
        }
        ISimplePlayer host = null;
        if(document.get("host", Document.class) != null){
            host = PandoniaAPI.get().getPlayerManager().SimplePlayerFromDocument(document.get("host", Document.class));
        }
        return new UHCRoleGame(UUID.fromString(document.getString("uuid")), document.getString("name"), document.getString("mode"), host, document.getInteger("type"), document.getDate("endDate"), document.getInteger("duration"), document.getList("winners", String.class), players, scenarios, document.getString("winnerCamp"));
    }

}