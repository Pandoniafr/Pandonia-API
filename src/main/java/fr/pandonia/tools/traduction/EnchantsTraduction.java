package fr.pandonia.tools.traduction;

import org.bukkit.enchantments.Enchantment;

public enum EnchantsTraduction {
    PROTECTION_ENVIRONMENTAL(Enchantment.PROTECTION_ENVIRONMENTAL, "Protection"),
    FIRE_PROTECTION(Enchantment.PROTECTION_FIRE, "Fire Protection"),
    FEATHER_FALLING(Enchantment.PROTECTION_FALL, "Feather Falling"),
    BLAST_PROTECTION(Enchantment.PROTECTION_EXPLOSIONS, "Blast Protection"),
    PROJECTILE_PROTECTION(Enchantment.PROTECTION_PROJECTILE, "Projectile Protection"),
    RESPIRATION(Enchantment.OXYGEN, "Respiration"),
    AQUA_AFFINITY(Enchantment.WATER_WORKER, "Aqua Affinity"),
    THORNS(Enchantment.THORNS, "Thorns"),
    DEPTH_STRIDERS(Enchantment.DEPTH_STRIDER, "Depth Strider"),
    SHARPNESS(Enchantment.DAMAGE_ALL, "Sharpness"),
    SMITE(Enchantment.DAMAGE_UNDEAD, "Smite"),
    BANE_OF_ARTHROPODS(Enchantment.DAMAGE_ARTHROPODS, "Bane of Arthropods"),
    KNOCKBACK(Enchantment.KNOCKBACK, "Knockback"),
    FIRE_ASPECT(Enchantment.FIRE_ASPECT, "Fire Aspect"),
    LOOTING(Enchantment.LOOT_BONUS_MOBS, "Looting"),
    POWER(Enchantment.ARROW_DAMAGE, "Power"),
    PUNCH(Enchantment.ARROW_KNOCKBACK, "Punch"),
    FLAME(Enchantment.ARROW_FIRE, "Flame"),
    INFINITY(Enchantment.ARROW_INFINITE, "Infinity"),
    EFFICIENCY(Enchantment.DIG_SPEED, "Efficiency"),
    SILK_TOUCH(Enchantment.SILK_TOUCH, "Silk Touch"),
    UNBREAKING(Enchantment.DURABILITY, "Unbreaking"),
    FORTUNE(Enchantment.LOOT_BONUS_BLOCKS, "Fortune"),
    LUCK_OF_THE_SEA(Enchantment.LUCK, "Luck of the Sea"),
    LURE(Enchantment.LURE, "Lure")
    ;

    private Enchantment enchantment;
    private String name;

    EnchantsTraduction(Enchantment enchantment, String name) {
        this.enchantment = enchantment;
        this.name = name;
    }


    public static String getEnchantName(Enchantment enchantment){
        for (EnchantsTraduction enchant : EnchantsTraduction.values()) {
            if(enchant.enchantment.equals(enchantment)){
                return enchant.name;
            }
        }
        return "";
    }

    public static Enchantment getEnchant(String name){
        for (EnchantsTraduction enchant : EnchantsTraduction.values()) {
            if(enchant.name.equals(name)){
                return enchant.enchantment;
            }
        }
        return null;
    }

    public static String getLevel(int level){
        switch (level){
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            default:
                return "enchantment.level." + level;
        }
    }
}
