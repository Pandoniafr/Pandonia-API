package fr.pandonia.api.games;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class GamePlayer {

    private UUID uuid;
    private String name;
    private List<GameKill> kills;
    private List<GameKill> deaths;
    private List<GameKill> assists;
    private Double damagesInflected;
    private Double damagesReceived;

    public GamePlayer(UUID uuid, String name, List<GameKill> kills, List<GameKill> deaths, List<GameKill> assists, Double damagesInflected, Double damagesReceived) {
        this.uuid = uuid;
        this.name = name;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.damagesInflected = damagesInflected;
        this.damagesReceived = damagesReceived;
    }



    public UUID getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public List<GameKill> getKills() {
        return kills;
    }

    public List<GameKill> getDeaths() {
        return deaths;
    }

    public List<GameKill> getAssists() {
        return assists;
    }

    public double getDamagesInflected() {
        return damagesInflected;
    }

    public double getDamagesReceived() {
        return damagesReceived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GamePlayer that = (GamePlayer) o;

        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }

    public Document toDocument(){
        List<Document> kills = new ArrayList<>();
        List<Document> deaths = new ArrayList<>();
        List<Document> assists = new ArrayList<>();
        for (GameKill kill : this.kills){
            kills.add(kill.toDocument());
        }
        for (GameKill death : this.deaths){
            deaths.add(death.toDocument());
        }
        for (GameKill assist : this.assists) {
            assists.add(assist.toDocument());
        }
        return new Document("uuid", uuid.toString())
                .append("name", name)
                .append("kills", kills)
                .append("deaths", deaths)
                .append("assists", assists)
                .append("damagesInflected", damagesInflected)
                .append("damagesReceived", damagesReceived);
    }

    public static GamePlayer fromDocument(Document document){
        List<GameKill> kills = new ArrayList<>();
        List<GameKill> deaths = new ArrayList<>();
        List<GameKill> assists = new ArrayList<>();
        for (Document kill : document.getList("kills", Document.class)){
            kills.add(GameKill.fromDocument(kill));
        }
        for (Document death : document.getList("deaths", Document.class)){
            deaths.add(GameKill.fromDocument(death));
        }
        for (Document assist : document.getList("assists", Document.class)){
            assists.add(GameKill.fromDocument(assist));
        }
        return new GamePlayer(UUID.fromString(document.getString("uuid")), document.getString("name"), kills, deaths, assists, document.get("damagesInflected", 0.0), document.get("damagesReceived", 0.0));
    }
}