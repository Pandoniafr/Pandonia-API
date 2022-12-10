package fr.pandonia.tools.playerequiparmor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum ArmorType{
    HELMET(5, "Casque"), CHESTPLATE(6, "Plastron"), LEGGINGS(7, "Pantalon"), BOOTS(8, "Botte");

    private final int slot;
    private final String name;

    ArmorType(int slot, String name){
        this.slot = slot;
        this.name = name;
    }

    /**
     * Attempts to match the ArmorType for the specified ItemStack.
     *
     * @param itemStack The ItemStack to parse the type of.
     * @return The parsed ArmorType, or null if not found.
     */
    public static ArmorType matchType(final ItemStack itemStack){
        if(itemStack == null || itemStack.getType().equals(Material.AIR)) return null;
        String type = itemStack.getType().name();
        if(type.endsWith("_HELMET") || type.endsWith("_SKULL") || type.endsWith("_HEAD")) return HELMET;
        else if(type.endsWith("_CHESTPLATE") || type.equals("ELYTRA")) return CHESTPLATE;
        else if(type.endsWith("_LEGGINGS")) return LEGGINGS;
        else if(type.endsWith("_BOOTS")) return BOOTS;
        else return null;
    }

    public int getSlot(){
        return slot;
    }

    public String getName() {
        return name;
    }
}
