package fr.pandonia.tools;

import com.google.common.base.Strings;
import org.bukkit.ChatColor;

public class ProgressBar {
    public static String getProgressBar(int current, int max, int totalBars, String symbol, ChatColor completedColor, ChatColor notCompletedColor) {
        float percent = (float) current / max;
        int progressBars = (int) (totalBars * percent);
        return completedColor + Strings.repeat("" + symbol, progressBars) + notCompletedColor + Strings.repeat("" + symbol, totalBars - progressBars);
    }
}
