package fr.pandonia.tools.particles.data.texture;

import org.bukkit.Material;
import fr.pandonia.tools.particles.ParticleConstants;
import fr.pandonia.tools.particles.PropertyType;
import fr.pandonia.tools.particles.data.ParticleData;
import fr.pandonia.tools.particles.utils.ReflectionUtils;

import java.lang.reflect.Field;

import static fr.pandonia.tools.particles.ParticleConstants.BLOCK_REGISTRY;
import static fr.pandonia.tools.particles.ParticleConstants.REGISTRY_GET_METHOD;

/**
 * A implementation of the {@link ParticleTexture} object to support block texture particles.
 *
 * @author ByteZ
 * @see PropertyType#REQUIRES_BLOCK
 * @since 11.06.2019
 */
public final class BlockTexture extends ParticleTexture {

    /**
     * Initializes a new {@link ParticleData} object.
     *
     * @param material the {@link Material} the particle should display.
     */
    public BlockTexture(Material material) {
        super(material, (byte) 0);
    }

    /**
     * Initializes a new {@link ParticleData} Object.
     *
     * @param material the {@link Material} the particle should display.
     * @param data     the damage value that should influence the texture.
     */
    public BlockTexture(Material material, byte data) {
        super(material, data);
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
        if (getMaterial() == null || !getMaterial().isBlock() || getEffect() == null || !getEffect().hasProperty(PropertyType.REQUIRES_BLOCK))
            return null;
        if (ReflectionUtils.MINECRAFT_VERSION < 13)
            return super.toNMSData();
        Object block = getBlockData(getMaterial());
        if (block == null)
            return null;
        try {
            return ParticleConstants.PARTICLE_PARAM_BLOCK_CONSTRUCTOR.newInstance(getEffect().getNMSObject(), block);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Gets the nms block data of the given bukkit {@link Material}.
     *
     * @param material the {@link Material}
     *                 whose data should be
     *                 getted.
     * @return the block data of the specified {@link Material} or {@code null} when an error occurs.
     */
    public Object getBlockData(Material material) { // FIXME
        try {
            Object block;
            if (ReflectionUtils.MINECRAFT_VERSION < 17) {
                Field blockField = ReflectionUtils.getFieldOrNull(ParticleConstants.BLOCKS_CLASS, material.name(), false);
                if (blockField == null)
                    return null;
                block = ReflectionUtils.readField(blockField, null);
            } else
                block = REGISTRY_GET_METHOD.invoke(BLOCK_REGISTRY, ReflectionUtils.getMinecraftKey(material.name().toLowerCase()));

            return ParticleConstants.BLOCK_GET_BLOCK_DATA_METHOD.invoke(block);
        } catch (Exception ex) {
            return null;
        }
    }

}
