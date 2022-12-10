package fr.pandonia.tools.particles.data;

import fr.pandonia.tools.particles.ParticleEffect;

/**
 * A Object to easier hold data of a particle.
 *
 * @author ByteZ
 * @since 10.06.2019
 */
public abstract class ParticleData {

    /**
     * The {@link ParticleEffect} the current {@link ParticleData} instance is
     * assigned to.
     */
    private ParticleEffect effect;

    /**
     * Sets the {@link ParticleEffect}.
     *
     * @param effect the {@link ParticleEffect} that should be displayed.
     */
    public void setEffect(ParticleEffect effect) {
        this.effect = effect;
    }

    /**
     * Converts the current {@link ParticleData} instance into nms data. If the current
     * minecraft version was released before 1.13 a int array should be returned. If the
     * version was released after 1.12 a nms "ParticleParam" has to be returned.
     *
     * @return the nms data.
     */
    public abstract Object toNMSData();

    /**
     * Gets the {@link ParticleEffect} the current {@link ParticleData} is assigned to.
     *
     * @return the current {@link ParticleEffect}
     */
    public ParticleEffect getEffect() {
        return effect;
    }
}
