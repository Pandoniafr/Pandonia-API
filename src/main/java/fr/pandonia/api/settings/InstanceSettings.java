package fr.pandonia.api.settings;

import org.bson.Document;

import java.lang.reflect.Field;

public class InstanceSettings {

    private boolean getOwning;
    private boolean getSettings;
    private boolean getStats;
    private boolean getBattlePass;
    private boolean getFriends;
    private boolean getGuilds;

    public InstanceSettings() {
        this.getOwning = false;
        this.getSettings = false;
        this.getStats = false;
        this.getBattlePass = false;
        this.getFriends = false;
        this.getGuilds = false;
    }

    public boolean isGetOwning() {
        return getOwning;
    }

    public boolean isGetSettings() {
        return getSettings;
    }

    public boolean isGetStats() {
        return getStats;
    }

    public boolean isGetBattlePass() {
        return getBattlePass;
    }

    public boolean isGetFriends() {
        return getFriends;
    }

    public boolean isGetGuilds() {
        return getGuilds;
    }

    public void setWhatToGet(boolean owning, boolean settings, boolean stats, boolean battlePass, boolean friends, boolean guilds){
        this.getOwning = owning;
        this.getSettings = settings;
        this.getStats = stats;
        this.getBattlePass = battlePass;
        this.getFriends = friends;
        this.getGuilds = guilds;
    }

    public static InstanceSettings fromDocument(Document document){
        InstanceSettings instanceSettings = new InstanceSettings();
        for (Field field : instanceSettings.getClass().getDeclaredFields()) {
            if(document.getBoolean(field.getName()) != null){
                try {
                    field.set(instanceSettings, document.getBoolean(field.getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return instanceSettings;
    }

}