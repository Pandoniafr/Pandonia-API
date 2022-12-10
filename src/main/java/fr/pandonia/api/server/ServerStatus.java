package fr.pandonia.api.server;

import org.bukkit.DyeColor;

public enum ServerStatus {

    //0

    NO_STATUS("§3Aucun status", DyeColor.RED, "§3", false),
    STARTING("§aDémarrage", DyeColor.ORANGE, "§a", false),
    WAITING_PLAYERS("§3En attente de joueurs", DyeColor.GREEN, "§3", true),
    GAME_STARTING("§3Démarrage de la partie", DyeColor.ORANGE, "§3", true),
    GAME_PLAYING("§3Partie en cours", DyeColor.CYAN, "§3", true),
    GAME_ENDING("§3Fin de la partie", DyeColor.RED, "§3", true),
    RESTARTING("§aRedémarrage", DyeColor.RED, "§a", false),
    STOPPING("§3Arrêt", DyeColor.RED, "§3", false),
    STARTED("§aDémarré", DyeColor.GREEN, "§a", true);

    private String name;
    private DyeColor dyeColor;
    private String color;
    private boolean joinable;

    ServerStatus(String name, DyeColor dyeColor, String color, boolean joinable){
        this.name = name;
        this.dyeColor = dyeColor;
        this.color = color;
        this.joinable = joinable;
    }

    /**
     * Récupère le ServerStatus grâce à la propriété "name"
     * @param name Nom du ServerStatus à trouver
     * @return ServerStatus trouvé (ou null)
     */
    public static ServerStatus getServerStatus(String name){
        for (ServerStatus status : ServerStatus.values()){
            if (status.getName().equalsIgnoreCase(name)){
                return status;
            }
        }
        return null;
    }

    /**
     * Récupère le Nom (coloré) du ServerStatus
     * @return le nom du ServerStatus
     */
    public String getName() {
        return name;
    }

    /**
     * Récupère la couleur du ServerStatus
     * @return la couleur
     */
    public DyeColor getDyeColor() {
        return dyeColor;
    }

    /**
     * Récupère la couleur du ServerStatus
     * @return la couleur du ServerStatus
     */
    public String getColor() {
        return color;
    }

    /**
     * Récupère si ce ServerStatus est un status rejoignable
     * @return si ce ServerStatus est un status rejoignable
     */
    public boolean isJoinable() {
        return joinable;
    }

}
