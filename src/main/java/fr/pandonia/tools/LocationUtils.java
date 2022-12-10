package fr.pandonia.tools;

import fr.pandonia.tools.menu.PandoniaMenuPreset;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class LocationUtils {

    public static char getArrowChar(Player p, Location loc){
        if (!p.getWorld().equals(loc.getWorld())){
            return '?';
        }else{
            Location ploc = p.getLocation();
            ploc.setY(loc.getY());
            Vector v = loc.subtract(ploc).toVector().normalize();
            Vector d = ploc.getDirection();
            double a = Math.toDegrees(Math.atan2(d.getX(), d.getZ()));
            a -= Math.toDegrees(Math.atan2(v.getX(), v.getZ()));
            a = ((int)(a + 22.5D) % 360);
            if(a < 0.0D){
                a += 360.0D;
            }
            return "⬆⬈➡⬊⬇⬋⬅⬉".charAt((int) a /45);
        }
    }

    public static String locToString(Location loc){
        return PandoniaMenuPreset.textColor.toString() + (int)loc.getX()+ "§7/" + PandoniaMenuPreset.textColor.toString() + (int)loc.getY()+ "§7/" + PandoniaMenuPreset.textColor.toString() + (int)loc.getZ();
    }

    public static double distance(Location playerLoc, Location Loc) {
        if (playerLoc.getWorld().equals(Loc.getWorld())) {
            return playerLoc.distance(Loc);
        } else {
            return 9999;
        }
    }

    public static void setNearbyBlocks(Location loc, int rayon, Material mat){
        for (int x = loc.getBlockX() - rayon; x < loc.getBlockX() + rayon; x++) {
            for (int z = loc.getBlockZ() - rayon; z < loc.getBlockZ() + rayon; z++) {
                for (int y = loc.getBlockY() - rayon; y < loc.getBlockY() + rayon; y++) {
                    Block block = loc.getWorld().getBlockAt(x, y, z);
                    if(!block.getType().equals(Material.AIR) && block.getLocation().distance(loc) < rayon){
                        block.setType(mat);
                    }
                }
            }
        }
    }

}
