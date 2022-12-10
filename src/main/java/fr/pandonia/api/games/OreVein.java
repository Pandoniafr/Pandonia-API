package fr.pandonia.api.games;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.List;

public class OreVein {

    private int timer;
    private Material type;
    private int mined;
    private List<Block> veinBlocks;
    private int goldTransformed;

    public OreVein(int timer, Material type, List<Block> blocks) {
        this.timer = timer;
        this.type = type;
        this.veinBlocks = blocks;
        this.mined = 0;
        this.goldTransformed = 0;
    }

    public int getTimer() {
        return timer;
    }

    public void addBlockMined(Block block){
        if(veinBlocks.contains(block)){
            mined++;
        }
    }

    public void addGoldTransformed() {
        this.goldTransformed++;
    }

    public int getGoldTransformed() {
        return goldTransformed;
    }

    public int getMined() {
        return mined;
    }

    public List<Block> getVeinBlocks() {
        return veinBlocks;
    }

    public Material getType() {
        return type;
    }
}
