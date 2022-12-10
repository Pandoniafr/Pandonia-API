package fr.pandonia.api.games.manager;

import fr.pandonia.api.PandoniaAPI;
import fr.pandonia.api.games.Game;
import fr.pandonia.api.games.uhc.UHCGame;
import fr.pandonia.api.games.uhc.role.UHCRoleGame;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class GameHistoryManager {

    private PandoniaAPI instance;

    private List<Game> games;

    public GameHistoryManager(PandoniaAPI instance) {
        this.instance = instance;

        this.games = new ArrayList<>();
    }

    public void putGame(Game game){
        instance.getMongoConnection().getMongoDatabase().getCollection("games").insertOne(game.toDocument());
    }

    public void cachePlayer(UUID uuid){
        instance.getMongoConnection().getMongoDatabase().getCollection("games").find(new Document("players", new Document("$elemMatch", new Document("uuid", uuid.toString())))).forEach((Consumer<Document>) document -> {
            int type = document.getInteger("type");
            Game game = null;
            if (type == 0){
                game = Game.fromDocument(document);
            }else if (type == 1){
                game = UHCGame.fromDocument(document);
            }else if (type == 2){
                game = UHCRoleGame.fromDocument(document);
            }
            if(game != null){
                if (!this.games.contains(game)){
                    this.games.add(game);
                }
            }
        });
    }

    public List<Game> getGames(UUID playerUUID){
        List<Game> games = new ArrayList<>();
        for (Game game : this.games){
            if(game.getPlayers() != null){
                if (game.getPlayers().stream().anyMatch(player -> player.getUUID().equals(playerUUID))){
                    games.add(game);
                }
            }
        }
        return games;
    }

    public void uncachePlayer(UUID playerUUID){
        List<UUID> uuids = new ArrayList<>();
        for(Player p : Bukkit.getOnlinePlayers()){
            uuids.add(p.getUniqueId());
        }
        uuids.remove(playerUUID);
        this.games.removeIf(game -> game == null || game.getPlayers().stream().noneMatch(player -> uuids.contains(player.getUUID())));
    }
}
