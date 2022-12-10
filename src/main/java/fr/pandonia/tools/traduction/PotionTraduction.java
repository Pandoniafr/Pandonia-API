package fr.pandonia.tools.traduction;

import org.bukkit.potion.PotionEffectType;

public enum PotionTraduction {
    SPEED(1, "Speed"),
    SLOW(2, "Slowness"),
    FAST_DIGGING(3, "Haste"),
    SLOW_DIGGING(4, "Mining Fatigue"),
    INCREASE_DAMAGE(5, "Force"),
    HEAL(6, "Instant Health"),
    HARM(7, ""),
    JUMP(8, "Jump"),
    CONFUSION(9, "Nausée"),
    REGENERATION(10, "Régénération"),
    DAMAGE_RESISTANCE(11, "Résistance"),
    FIRE_RESISTANCE(12, "Résistance au feu"),
    WATER_BREATHING(13, "Respiration"),
    INVISIBILITY(14, "Invisibilité"),
    BLINDNESS(15, "Blindness"),
    NIGHT_VISION(16, "Night Vision"),
    HUNGER(17, "Faim"),
    WEAKNESS(18, "Faiblesse"),
    POISON(19, "Poison"),
    WITHER(20, "Wither"),
    HEALTH_BOOST(21, "Health Boost"),
    ABSORPTION(22, "Absorption"),
    SATURATION(23, "Saturation");

    private final int id;
    private final String name;

    PotionTraduction(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @SuppressWarnings("deprecation")
    public static String traduction(PotionEffectType potionEffectType){
        for(PotionTraduction potionTraduction : PotionTraduction.values()){
            if(potionEffectType.getId() == potionTraduction.id){
                return potionTraduction.name;
            }
        }
        return null;
    }
}
