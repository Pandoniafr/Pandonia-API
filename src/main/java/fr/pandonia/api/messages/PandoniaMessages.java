package fr.pandonia.api.messages;

import fr.pandonia.api.PandoniaAPI;

import java.util.Date;

public abstract class PandoniaMessages {

    private static boolean debug = true;

    private static String PREFIX = "§3§lPANDONIA §8» §r";
    private static String CASINO = "§6§lCASINO §8» §r";
    private static String ERREUR = "§3Erreur §8» ";

    private static String NOPERMS = "§3Erreur §8» §fVous ne pouvez pas §3effectuer§f cette §3commande§f.";

    public static String getPrefix() {
        return PREFIX;
    }

    public static String getErreur() {
        return ERREUR;
    }

    public static String getNoPerms() {
        return NOPERMS;
    }

    public static String getCasino() {
        return CASINO;
    }

    public static void log(String message){
        PandoniaAPI.get().getPlugin().getServer().getConsoleSender().sendMessage(message);
    }
    public static void debug(String message){
        if (debug){
            PandoniaAPI.get().getPlugin().getServer().getConsoleSender().sendMessage("§e" + message);
        }
    }

    public static void error(String message){
        PandoniaAPI.get().getPlugin().getServer().getConsoleSender().sendMessage("§c" + message);
    }

    public static String getActualDate(){
        return new Date(System.currentTimeMillis()).toString();
    }

}

