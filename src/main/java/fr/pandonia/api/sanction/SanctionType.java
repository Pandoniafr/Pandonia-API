package fr.pandonia.api.sanction;

import java.awt.*;

public enum SanctionType {

    KICK(Color.YELLOW, ":arrow_upper_right:"),
    MUTE(new Color(38, 99, 145), ":microphone2:"),
    BAN(new Color(204, 0, 0), "<a:ban:752429646846361621>"),
    WARN(new Color(255, 128, 0), ":warning:");

    private Color color;
    private String emoji;

    SanctionType(Color color, String emoji) {
        this.color = color;
        this.emoji = emoji;
    }

    public Color getColor() {
        return color;
    }

    public String getEmoji() {
        return emoji;
    }
}

