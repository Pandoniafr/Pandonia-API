package fr.pandonia.api.games;

import org.bson.Document;

import java.lang.reflect.Field;

public class GameKill {

    private String player;
    private int time;

    public GameKill(String player, int time) {
        this.player = player;
        this.time = time;
    }

    public String getPlayer() {
        return player;
    }

    public int getTime() {
        return time;
    }

    public Document toDocument(){
        Document document = new Document();
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                document.append(field.getName(), field.get(this));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static GameKill getDefault(){
        return new GameKill("null", 0);
    }

    public static GameKill fromDocument(Document document){
        try {
            GameKill gameKill = GameKill.getDefault();
            for (Field field : gameKill.getClass().getDeclaredFields()) {
                if(document.get(field.getName()) != null){
                    field.setAccessible(true);
                    field.set(gameKill, document.get(field.getName()));
                }
            }
            return gameKill;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
