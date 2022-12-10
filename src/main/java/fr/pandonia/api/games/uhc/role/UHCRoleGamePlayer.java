package fr.pandonia.api.games.uhc.role;

import fr.pandonia.api.games.GameKill;
import fr.pandonia.api.games.uhc.UHCGamePlayer;
import org.bson.Document;

import java.util.List;
import java.util.UUID;

public class UHCRoleGamePlayer extends UHCGamePlayer {

    private String role;
    private String camp;

    public UHCRoleGamePlayer(UUID uuid, String name, List<GameKill> kills, List<GameKill> deaths, List<GameKill> assists, double damagesInflected, double damagesReceived, int lifeDuration, String teamName, String role, String camp) {
        super(uuid, name, kills, deaths, assists, damagesInflected, damagesReceived, lifeDuration, teamName);
        this.role = role;
        this.camp = camp;
    }

    public UHCRoleGamePlayer(UHCGamePlayer ugp, String role, String camp) {
        super(ugp.getUUID(), ugp.getName(), ugp.getKills(), ugp.getDeaths(), ugp.getAssists(), ugp.getDamagesInflected(), ugp.getDamagesReceived(), ugp.getLifeDuration(), ugp.getTeamName());
        this.role = role;
        this.camp = camp;
    }

    public String getRole() {
        return role;
    }

    public String getCamp() {
        return camp;
    }

    @Override
    public Document toDocument(){
        return super.toDocument().append("role", role).append("camp", camp);
    }

    public static UHCRoleGamePlayer fromDocument(Document document){
        UHCGamePlayer ugp = UHCGamePlayer.fromDocument(document);
        return new UHCRoleGamePlayer(ugp, document.getString("role"), document.getString("camp"));
    }

}
