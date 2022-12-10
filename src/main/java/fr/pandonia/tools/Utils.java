package fr.pandonia.tools;

import fr.pandonia.api.server.IServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class Utils {

    public static BaseComponent[] getServerComponent(IServer server){
        return new ComponentBuilder(" §8┃ §3" + server.getUserFriendlyName() + "\n\n   §8» §fStatus §f: §3" + server.getServerStatus().getColor() + server.getServerStatus().getName() + "\n   §8» §fWhitelist §f: §3" + (server.isWhitelist() ? "§3Fermé" : "§aOuvert") + "\n\n  §8┃ §fHost §f: §3" + server.getHost().getName() + "\n  §8┃ §fJoueurs §f: §3" + server.getPlayers().size() + "\n\n  §8┃ §fSlots §f: §3" + server.getSlots()).create();
    }

    public static String toS(boolean S){
        return S ? "s" : "";
    }
}

