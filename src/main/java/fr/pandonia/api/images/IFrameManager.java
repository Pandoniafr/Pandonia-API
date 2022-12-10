package fr.pandonia.api.images;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;

import java.awt.image.BufferedImage;

public interface IFrameManager {
    void drawImage(String url, Location topLeftCorner, BlockFace blockFace);

    void drawImage(BufferedImage image, Location topLeftCorner, BlockFace blockFace);
}

