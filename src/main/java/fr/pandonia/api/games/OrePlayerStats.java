package fr.pandonia.api.games;

import org.bson.Document;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class OrePlayerStats {

    private int ironMined;
    private int goldMined;
    private int diamondMined;
    private int redstoneMined;
    private int lapizMined;
    private int coalMined;

    private List<OreVein> veins;

    public OrePlayerStats() {
        ironMined = 0;
        goldMined = 0;
        diamondMined = 0;
        redstoneMined = 0;
        lapizMined = 0;
        coalMined = 0;
        this.veins = new ArrayList<>();
    }

    public int getIronMined() {
        return ironMined;
    }

    public void addIronMined(int ironMined) {
        this.ironMined += ironMined;
    }

    public int getGoldMined() {
        return goldMined;
    }

    public void addGoldMined(int goldMined) {
        this.goldMined += goldMined;
    }

    public int getDiamondMined() {
        return diamondMined;
    }

    public void addDiamondMined(int diamondMined) {
        this.diamondMined += diamondMined;
    }

    public int getRedstoneMined() {
        return redstoneMined;
    }

    public void addRedstoneMined(int redstoneMined) {
        this.redstoneMined += redstoneMined;
    }

    public int getLapizMined() {
        return lapizMined;
    }

    public void addLapizMined(int lapizMined) {
        this.lapizMined += lapizMined;
    }

    public int getCoalMined() {
        return coalMined;
    }

    public void addCoalMined(int coalMined) {
        this.coalMined += coalMined;
    }

    public List<OreVein> getVeins() {
        return veins;
    }

    public OreVein getVein(Block block){
        for (OreVein vein : veins) {
            if(vein.getVeinBlocks().contains(block)){
                return vein;
            }
        }
        return null;
    }

    public int getStatMined(Material material){
        int i = 0;
        for (OreVein vein : veins) {
            if(vein.getType().equals(material)){
                i += vein.getMined();
            }
        }
        return i;
    }

    public static OrePlayerStats fromDocument(Document document){
        OrePlayerStats orePlayerStats = new OrePlayerStats();
        for (Field field : orePlayerStats.getClass().getDeclaredFields()) {
            if(document.getBoolean(field.getName()) != null){
                try {
                    field.setAccessible(true);
                    field.set(orePlayerStats, document.get(field.getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return orePlayerStats;
    }

    public Document toDocument(){
        Document document = new Document();
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                document.append(field.getName(), field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return document;
    }

    public static Ores getOre(Material material){
        for (Ores value : Ores.values()) {
            if(value.name().equals(material.name())){
                return value;
            }
        }
        return null;
    }

    public enum Ores{
        DIAMOND_ORE(Material.DIAMOND, "§b", "Diamant"),
        GOLD_ORE(Material.GOLD_INGOT, "§6", "Or"),
        IRON_ORE(Material.IRON_INGOT, "§7", "Fer"),
        LAPIS_ORE(new ItemStack(Material.INK_SACK, 1, (short) 4), "§9", "Lapis"),
        REDSTONE_ORE(Material.REDSTONE, "§c", "Redstone"),
        COAL_ORE(Material.COAL, "§8", "Charbon"),
        EMERALD_ORE(Material.EMERALD, "§a", "Emeraude")

        ;

        public Material ore;
        public ItemStack ingot;
        public String color;
        public String name;

        Ores(Material ingot, String color, String name) {
            this.ingot = new ItemStack(ingot);
            this.color = color;
            this.name = name;
            this.ore = Material.valueOf(name());
        }

        Ores(ItemStack ingot, String color, String name) {
            this.ingot = ingot;
            this.color = color;
            this.name = name;
            this.ore = Material.valueOf(name());
        }
    }

}
