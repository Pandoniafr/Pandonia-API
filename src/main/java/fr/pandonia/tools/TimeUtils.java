package fr.pandonia.tools;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TimeUtils {

    public static String timeToString(long timer) {
        long hour = timer/3600;
        long minutes = (timer/60)%60;
        long secondes = timer%60;

        String hourString = (hour > 0 ? hour + "h" : "");
        String minutesString = (minutes > 0 || hour > 0 ? (minutes < 10 ? "0" + minutes : minutes) + "m" : "");
        String secondesString = (secondes < 10 ? "0" + secondes : secondes) + "s";

        return (timer < 0 ? "§aActivé" : hourString + minutesString + secondesString);
    }

    public static long stringTimeToTimer(String timeString){
        if (timeString.endsWith("s")){
            return Integer.parseInt(timeString.split("s")[0]);
        }else if (timeString.endsWith("min")){
            return Integer.parseInt(timeString.split("min")[0])* 60L;
        }else if (timeString.endsWith("h")){
            return (long) Integer.parseInt(timeString.split("h")[0]) *60*60;
        }else if (timeString.endsWith("j")){
            return (long) Integer.parseInt(timeString.split("j")[0]) *60*60*24;
        }else if (timeString.endsWith("m")){
            return (long) Integer.parseInt(timeString.split("m")[0]) *60*60*24*30;
        }else if (timeString.endsWith("a")){
            return (long) Integer.parseInt(timeString.split("a")[0]) *60*60*24*365;
        }else{
            return -1;
        }
    }

    public static String dayToString(long timer){
        long d = timer / (3600*24);
        return d > 0 ? (d + " jour" + (d > 1 ? "s" : "")) : timeToString(timer);
    }

    public static String timeToStringDouble(double timer) {
        int hour = (int) (timer/3600);
        int minutes = (int) ((timer/60)%60);
        double secondes = (timer%60);

        NumberFormat formatter = new DecimalFormat("#0.00");

        String hourString = (hour > 0 ? hour + "h" : "");
        String minutesString = (minutes > 0 || hour > 0 ? (minutes < 10 ? "0" + minutes : minutes) + "m" : "");
        String secondesString = (secondes < 10 ? "0" + formatter.format(secondes) : formatter.format(secondes)) + "s";

        return hourString + minutesString + secondesString;
    }

    public static String timeToStringAll(long seconde){
        long d = seconde / (3600*24);
        long h = (seconde % (3600*24)) / 3600;
        long m = (seconde % 3600) / 60;
        long s = seconde % 60;

        if(s == 0 && m == 0 && h == 0 && d > 0){
            return d + " jour" + (d > 1 ?"s":"");
        }else if(d == 0 && s == 0 && m == 0 && h > 0){
            return h + " heure" + (h > 1 ?"s":"");
        }
        if(h < 1 && m < 1 && d < 1){
            return s +"s";
        }else if(h < 1 && d < 1){
            return m+"m "+ s +"s";
        }else if (d < 1){
            return h + "h " + m+ "m "+ s +"s";
        }else{
            return d + "j " + h +"h "+m+"m "+s+"s";
        }
    }

    public static String ticksToTime(int ticks) {
        int secondes = ticks / 20;
        int minutes = 0;
        int heures = 0;
        while (secondes >= 60) {
            secondes -= 60;
            minutes++;
        }
        while (minutes >= 60) {
            minutes -= 60;
            heures++;
        }
        return (heures != 0 ? heures + " heure(s) " : "") + (minutes != 0 ? minutes + " minute(s) " : "") + secondes + " seconde(s)";

    }

    public static String timerFormat(int timer){
        int hour = timer/3600;
        int minutes = (timer/60)%60;
        int secondes = timer%60;

        String hourString = (hour > 0 ? hour + "h" : "");
        String minutesString = (minutes > 0 || hour > 0 ? (minutes < 10 ? "0" + minutes : minutes) + "m" : "");
        String secondesString = (secondes < 10 ? "0" + secondes : secondes) + "s";

        return (timer < 0 ? "§aActivé" : hourString + minutesString + secondesString);
    }

}
