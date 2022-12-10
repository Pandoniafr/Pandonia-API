package fr.pandonia.api.games.uhc;

import fr.pandonia.api.games.GameKill;
import fr.pandonia.api.games.GamePlayer;
import org.bson.Document;

import java.util.List;
import java.util.UUID;

public class UHCGamePlayer extends GamePlayer {

    private int lifeDuration;
    private String teamName;

    public UHCGamePlayer(UUID uuid, String name, List<GameKill> kills, List<GameKill> deaths, List<GameKill> assists, double damagesInflected, double damagesReceived, int lifeDuration, String teamName) {
        super(uuid, name, kills, deaths, assists, damagesInflected, damagesReceived);
        this.lifeDuration = lifeDuration;
        this.teamName = teamName;
    }

    public UHCGamePlayer(GamePlayer gp, int lifeDuration, String teamName) {
        super(gp.getUUID(), gp.getName(), gp.getKills(), gp.getDeaths(), gp.getAssists(), gp.getDamagesInflected(), gp.getDamagesReceived());
        this.lifeDuration = lifeDuration;
        this.teamName = teamName;
    }

    public int getLifeDuration() {
        return lifeDuration;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public Document toDocument(){
        return super.toDocument().append("lifeDuration", lifeDuration).append("teamName", teamName);
    }

    public static UHCGamePlayer fromDocument(Document document){
        GamePlayer gp = GamePlayer.fromDocument(document);
        return new UHCGamePlayer(gp, document.getInteger("lifeDuration"), document.getString("teamName"));
    }

}