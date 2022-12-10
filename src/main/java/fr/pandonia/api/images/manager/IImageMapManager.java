package fr.pandonia.api.images.manager;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;

import java.awt.image.BufferedImage;

public interface IImageMapManager {

    /**
     * Crée et lance la task de rendu de l'image
     * @param path Chemin ou URL de l'image
     * @param topLeftCorner Location du block en haut à gauche de là ou doit être mise l'image
     * @param blockFace Face du block vers laquelle se trouve l'image
     */
    void drawImage(String path, Location topLeftCorner, BlockFace blockFace);

    void drawImage(BufferedImage image, Location topLeftCorner, BlockFace blockFace);
}
