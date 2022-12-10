package fr.pandonia.tools.particles;

import fr.pandonia.tools.FireworkUtils;
import fr.pandonia.tools.particles.task.TaskManager;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ParticlePresets {

    public static int startCubeTask(World world, Vector start, Vector end){
        java.util.List<Object> packets = new ArrayList<>();
        ParticleBuilder particle = new ParticleBuilder(ParticleEffect.FLAME);
        for (double x = start.getBlockX(); x <= end.getBlockX(); x+=0.25) {
            for (double y = start.getBlockY(); y <= end.getBlockY(); y+=0.25) {
                for (double z = start.getBlockZ(); z <= end.getBlockZ(); z+=0.25) {
                    packets.add(particle.setLocation(new Location(world, x, y, z)).toPacket());
                }
            }
        }
        return TaskManager.startGlobalTask(packets, 5);
    }

    public static void sendExplosion(Location center, List<Player> players){
        for (Player p : players){
            p.playEffect(center, Effect.EXPLOSION_LARGE, null);
            p.playSound(center, Sound.EXPLODE, 1, 1);
        }
    }

    public static void sendFlammes(Location center, List<Player> players){
        new ParticleBuilder(ParticleEffect.FLAME).setLocation(center).setAmount(500).setSpeed(0.3f).setOffset(0.2f, 0.2f, 0.2f).display(players);
    }

    public static void sendWater(Location center, List<Player> players){
        new ParticleBuilder(ParticleEffect.WATER_WAKE).setLocation(center).setAmount(500).setSpeed(0.3f).setOffset(0.2f, 0.2f, 0.2f).display(players);
    }

    public static void sendFirework(Location center, List<Player> players){
        FireworkUtils.spawnRandomFirework(center);
    }

    public static void sendLava(Location center, List<Player> players){
        //new ParticleBuilder(ParticleEffect.BLOCK_DUST).setParticleData(new BlockTexture(Material.DIRT)).setLocation(center).setAmount(500).setSpeed(0.2f).setOffset(0.1f, 0.1f, 0.1f).display(players);
        new ParticleBuilder(ParticleEffect.LAVA).setLocation(center).setAmount(500).setSpeed(0.3f).setOffset(0.2f, 0.2f, 0.2f).display(players);
    }

    public static int startPokeballTask(Location center, List<Player> players){
        List<Object> packets = new ArrayList<>(getPokeballPackets(center, 1.5));
        return TaskManager.startSuppliedTask(packets, 5, () -> players);
    }

    public static int startHorizontalCircleTask(Location center, List<Player> players){
        List<Object> packets = new ArrayList<>(getHorizontalCircle(center, 1.5, Color.RED));
        return TaskManager.startSuppliedTask(packets, 5, () -> players);
    }

    public static List<Object> getPokeballPackets(Location center, double r){
        List<Object> packets = new ArrayList<>();
        ParticleBuilder particle = new ParticleBuilder(ParticleEffect.REDSTONE);
        for(double phi = 0; phi <= Math.PI; phi += Math.PI / 15) {
            double y = r * Math.cos(phi) + 1.5;
            for(double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 30) {
                double x = r * Math.cos(theta) * Math.sin(phi);
                double z = r * Math.sin(theta) * Math.sin(phi);

                Color color = Color.red;
                if ((y-r) < 0.25 && (y-r) > -0.25){
                    color = Color.BLACK;
                }else if (y-r < 0){
                    color = Color.WHITE;
                }

                center.add(x, y, z);
                packets.add(particle.setLocation(center).setColor(color).toPacket());
                center.subtract(x, y, z);
            }
        }
        Location cubeCenter = new Location(center.getWorld(), center.getX()+r, center.getY()+r, center.getZ());
        packets.addAll(getCubePackets(center.getWorld(), new Vector(cubeCenter.getX()-0.5, cubeCenter.getY()-0.5, cubeCenter.getZ()-0.5), new Vector(cubeCenter.getX()+0.5, cubeCenter.getY()+0.5, cubeCenter.getZ()+0.5)));
        return packets;
    }

    public static List<Object> getHorizontalCircle(Location center, double r, Color color){
        List<Object> packets = new ArrayList<>();
        ParticleBuilder particle = new ParticleBuilder(ParticleEffect.REDSTONE);
        for(double phi = 0; phi <= Math.PI; phi += Math.PI / 15) {
            for(double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 30) {
                double x = r * Math.cos(theta) * Math.sin(phi);
                double z = r * Math.sin(theta) * Math.sin(phi);

                center.add(x, 0, z);
                packets.add(particle.setLocation(center).setColor(color).toPacket());
                center.subtract(x, 0, z);
            }
        }
        return packets;
    }

    public static List<Object> getCubePackets(World world, Vector start, Vector end){
        List<Object> packets = new ArrayList<>();
        ParticleBuilder particle = new ParticleBuilder(ParticleEffect.REDSTONE);
        for (double x = start.getBlockX(); x <= end.getBlockX(); x+=0.25) {
            for (double y = start.getBlockY(); y <= end.getBlockY(); y+=0.25) {
                for (double z = start.getBlockZ(); z <= end.getBlockZ(); z+=0.25) {
                    packets.add(particle.setLocation(new Location(world, x, y, z)).setColor(Color.WHITE).toPacket());
                }
            }
        }
        return packets;
    }

}
