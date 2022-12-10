package fr.pandonia.api.games;

import fr.pandonia.api.PandoniaAPI;
import fr.pandonia.api.player.ISimplePlayer;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Game {

    private UUID uuid;
    private String name;
    private String mode;
    private ISimplePlayer host;
    private int type;
    private Date endDate;
    private int duration;
    private List<String> winners;
    private List<GamePlayer> players;
    private List<String> scenarios;

    //Type: 0
    public Game(UUID uuid, String name, String mode, ISimplePlayer host, int type, Date endDate, int duration, List<String> winners, List<GamePlayer> players, List<String> scenarios) {
        this.uuid = uuid;
        this.name = name;
        this.mode = mode;
        this.host = host;
        this.type = type;
        this.endDate = endDate;
        this.duration = duration;
        this.winners = winners;
        this.players = players;
        this.scenarios = scenarios;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getMode() {
        return mode;
    }

    public ISimplePlayer getHost() {
        return host;
    }

    public int getType() {
        return type;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getDuration() {
        return duration;
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<GamePlayer> getPlayers() {
        return players;
    }

    public List<String> getScenarios() {
        return scenarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return uuid.equals(game.uuid);
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }

    public Document toDocument(){
        List<Document> players = new ArrayList<>();
        this.players.forEach(gamePlayer -> players.add(gamePlayer.toDocument()));
        return new Document("uuid", uuid.toString())
                .append("name", name)
                .append("mode", mode)
                .append("host", host == null ? null : host.toDocument())
                .append("type", type)
                .append("endDate", endDate)
                .append("duration", duration)
                .append("winners", winners)
                .append("players", players)
                .append("scenarios", scenarios);
    }

    public static Game fromDocument(Document document){
        List<GamePlayer> players = new ArrayList<>();
        document.getList("players", Document.class).forEach(player -> players.add(GamePlayer.fromDocument(player)));
        List<String> scenarios = new ArrayList<>();
        if(document.getList("scenarios", String.class) != null){
            scenarios.addAll(document.getList("scenarios", String.class));
        }
        ISimplePlayer host = null;
        if(document.get("host", Document.class) != null){
            host = PandoniaAPI.get().getPlayerManager().SimplePlayerFromDocument(document.get("host", Document.class));
        }
        return new Game(UUID.fromString(document.getString("uuid")), document.getString("name"), document.getString("mode"), host, document.getInteger("type"), document.getDate("endDate"), document.getInteger("duration"), document.getList("winners", String.class), players, scenarios);
    }
}
