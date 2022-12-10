package fr.pandonia.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.*;

public class ScoreboardUpdateEvent extends Event {

    /**
     * Cet event permet de configurer le scoreboard
     * Il est exécuté à chaque fois que le scoreboard est update pour un joueur
     */

    private String name;
    private String ip;
    private List<String> lines;
    private Map<String, Integer> scores;
    private Player player;

    public ScoreboardUpdateEvent(Player player, String ip) {
        this.ip = ip;
        this.player = player;
        this.name = "UHC";
        this.lines = new ArrayList<>();
        this.scores = new HashMap<>();
    }

    /**
     * Récupère le joueur pour lequel le scoreboard est update
     * @return le joueur pour lequel le scoreboard est update
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Récupère l'UUID du joueur pour lequel le scoreboard est update
     * @return l'UUID du joueur pour lequel le scoreboard est update
     */
    public UUID getUUID(){
        return player.getUniqueId();
    }

    private static final HandlerList handlers = new HandlerList();
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Récupère la liste des lines configurées dans l'event
     * @return
     */
    public List<String> getLines() {
        return lines;
    }

    /**
     * Ajoute une ligne au scoreboard
     * @param line la ligne à ajouter
     */
    public void addLine(String line){
        if(line.length() > 40){
            System.out.println("erreur : ligne trop long dans le scoreboard (" + line + ")");
        }else{
            getLines().add(line);
        }
    }

    /**
     * Récupère le nom du scoreboard
     * @return le nom du scoreboard
     */
    public String getName() {
        return name;
    }

    /**
     * Défini le nom du scoreboard
     * @param name le nom du scoreboard
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ajoute une ligne au scoreboard avec un score donné
     * @param i Le score
     * @param score Le texte
     */
    public void setScore(int i, String score){
        scores.put(score, i);
    }

    /**
     * Récupère la map de tous les scores
     * @return la map de tous les scores
     */
    public Map<String, Integer> getScores() {
        return scores;
    }

    /**
     * Récupère l'ip
     * @return L'ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Supprime toutes les lignes du scoreboard déjà définies (ip non comprise)
     */
    public void clearScoreboard(){
        this.lines.clear();
        this.scores.clear();
    }
}
