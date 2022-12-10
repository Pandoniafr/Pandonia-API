package fr.pandonia.api.player.battlepass;

public class PlayerBattlePassUtils {

    public static int getLevelFromXP(int xp){
        int level = 0;
        while (getAllNeededXPForALevel(level) <= xp){
            level++;
        }
        level--;
        return level;
    }

    public static int getNeededXPForALevel(int level){
        if (level == 0){
            return 0;
        }else{
            return (int) (Math.ceil(((getNeededXPForALevel(level-1)*0.8)+10*level)/10.0) * 10) + 190;
        }
    }

    public static int getOldNeededXPForALevel(int level){
        if (level == 0){
            return 0;
        }else{
            return (int) (Math.ceil(((getOldNeededXPForALevel(level-1)*0.8)+20*level)/10.0) * 10) + 480;
        }
    }

    public static int getAllNeededXPForALevel(int level){
        int r = 0;
        if (level == 0){
            return 0;
        }else{
            for (int i = 0; i <= level; i++){
                r += getNeededXPForALevel(i);
            }
            return r;
        }
    }

    public static int getOldAllNeededXPForALevel(int level){
        int r = 0;
        if (level == 0){
            return 0;
        }else{
            for (int i = 0; i <= level; i++){
                r += getOldNeededXPForALevel(i);
            }
            return r;
        }
    }

    public static void main(String[] args) {
        int var = 50;
        //System.out.println(getNeededXPForALevel(var));
        //System.out.println(getOldNeededXPForALevel(var));
        System.out.println(getAllNeededXPForALevel(var));
        System.out.println(getOldAllNeededXPForALevel(var));
    }

}
