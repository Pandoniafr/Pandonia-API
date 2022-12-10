package fr.pandonia.tools.particles.data.texture;

import org.bukkit.Material;
import fr.pandonia.tools.particles.PropertyType;
import fr.pandonia.tools.particles.data.ParticleData;

/**
 * A implementation of {@link ParticleData} to support particles that require a texture
 * to function properly.
 *
 * @author ByteZ
 * @see PropertyType#REQUIRES_BLOCK
 * @see PropertyType#REQUIRES_ITEM
 * @since 11.06.2019
 */
public class ParticleTexture extends ParticleData {

    /**
     * The {@link Material} that should be displayed by the particle.
     */
    private final Material material;
    /**
     * The damage data to be displayed by the given texture.
     */
    private final byte data;

    /**
     * Initializes a new {@link ParticleData} object.
     *
     * @param material the {@link Material} the particle should display.
     * @param data     the damage value that should influence the texture.
     */
    ParticleTexture(Material material, byte data) {
        this.material = material;
        this.data = data;
    }

    /**
     * Gets the {@link Material} that will be displayed b the particle.
     *
     * @return the {@link Material} the current data is assigned to
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Gets the damage value that will be displayed by the client.
     *
     * @return the damage value of the current texture.
     */
    public byte getData() {
        return data;
    }

    /**
     * Converts the current {@link ParticleData} instance into nms data. If the current
     * minecraft version was released before 1.13 a int array should be returned. If the
     * version was released after 1.12 a nms "ParticleParam" has to be returned.
     *
     * @return the nms data.
     */
    @Override
    public Object toNMSData() {
        return new int[] {getMaterial().ordinal(), getData()};
    }
}
