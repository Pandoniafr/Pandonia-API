package fr.pandonia.tools;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import fr.pandonia.tools.menu.PandoniaMenuPreset;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.material.Dye;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;

import java.lang.reflect.Field;
import java.util.*;

public class ItemBuilder {
    private ItemStack is;

    public ItemBuilder(Material m) {
        this(m, 1);
    }

    public ItemBuilder(ItemStack is) {
        this.is = is;
    }

    public ItemBuilder(Material m, int amount) {
        is = new ItemStack(m, amount);
    }

    public ItemBuilder(Material m, int amount, int meta){
        is = new ItemStack(m, amount, (short) meta);
    }

    public ItemBuilder(Material m, int amount, short meta){
        is = new ItemStack(m, amount, meta);
    }

    public ItemBuilder getSkull(String paramString1) {
        if (paramString1 != null){
            SkullMeta localSkullMeta = (SkullMeta)is.getItemMeta();

            GameProfile localGameProfile = new GameProfile(UUID.randomUUID(), null);
            PropertyMap localPropertyMap = localGameProfile.getProperties();
            localPropertyMap.put("textures", new Property("textures", paramString1));
            try {
                Field localField = localSkullMeta.getClass().getDeclaredField("profile");
                localField.setAccessible(true);
                localField.set(localSkullMeta, localGameProfile);
            } catch (NoSuchFieldException|IllegalAccessException localNoSuchFieldException) {
                localNoSuchFieldException.printStackTrace();
            }
            is.setItemMeta(localSkullMeta);
        }
        return this;
    }

    public ItemBuilder clone() {
        return new ItemBuilder(is);
    }

    public ItemBuilder setDurability(int dur) {
        is.setDurability((short) dur);
        return this;
    }

    public ItemBuilder setDyeColor(DyeColor color){
        Dye dye = new Dye();
        dye.setColor(color);
        is.setData(dye);
        return this;
    }

    public ItemBuilder addBookEnchant(Enchantment enchantment, int level){
        ItemMeta im = is.getItemMeta();
        if (im instanceof EnchantmentStorageMeta){
            EnchantmentStorageMeta esm = (EnchantmentStorageMeta) im;
            esm.addStoredEnchant(enchantment, level, false);
            is.setItemMeta(esm);
        }
        return this;
    }

    public ItemBuilder addPotionEffect(PotionEffect potionEffect){
        if(is.getType().equals(Material.POTION)){
            PotionMeta meta = (PotionMeta) is.getItemMeta();
            meta.addCustomEffect(potionEffect, true);
            is.setItemMeta(meta);
        }
        return this;
    }

    public ItemBuilder setSplashPotion(){
        if(is.getType().equals(Material.POTION)){
            Potion potion = Potion.fromItemStack(is);
            potion.setSplash(true);
            potion.apply(is);
        }
        return this;
    }

    public ItemBuilder setRightLeftClickLore(String name){
        this.setLore("", " §8┃ §f" + name + " §f:", " §8┃ " + PandoniaMenuPreset.textColor + "Clic-Droit §fou " + PandoniaMenuPreset.textColor + "Clic-Gauche", "");
        return this;
    }

    public ItemBuilder addRightLeftClickLore(String name){
        return addRightLeftClickLore(name, PandoniaMenuPreset.textColor.toString());
    }

    public ItemBuilder addRightLeftClickLore(String name, String color){
        this.addLore("", " §8┃ §f" + name + " §f:", " §8┃ " + color + "Clic-Droit §fou " + color + "Clic-Gauche", "");
        return this;
    }

    public ItemBuilder addCustumClickLore(String name, String click){
        this.addLore(" §8┃ §f" + name + " §f:", " §8┃ " + PandoniaMenuPreset.textColor + click);
        return this;
    }

    public ItemBuilder setGlow(Boolean glow) {
        if (glow) {
            net.minecraft.server.v1_8_R3.ItemStack minecraftitemstack = CraftItemStack.asNMSCopy(is);
            NBTTagCompound tag = null;
            if (!minecraftitemstack.hasTag()) {
                tag = new NBTTagCompound();
                minecraftitemstack.setTag(new NBTTagCompound());
            } else {
                tag = minecraftitemstack.getTag();
            }
            NBTTagList ench = new NBTTagList();
            tag.set("ench", ench);
            minecraftitemstack.setTag(tag);
            is = CraftItemStack.asCraftMirror(minecraftitemstack);
        } else {
            net.minecraft.server.v1_8_R3.ItemStack minecraftitemstack = CraftItemStack.asNMSCopy(is);
            NBTTagCompound tag = null;
            if (minecraftitemstack.hasTag()) {
                tag = minecraftitemstack.getTag();
                if (tag.hasKey("ench")) {
                    tag.remove("ench");
                    minecraftitemstack.setTag(tag);
                    is = CraftItemStack.asCraftMirror(minecraftitemstack);
                }
            }
        }
        return this;
    }

    public ItemBuilder setName(String name) {
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder addUnsafeEnchantment(Enchantment ench, int level) {
        is.addUnsafeEnchantment(ench, level);
        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment ench) {
        is.removeEnchantment(ench);
        return this;
    }

    public ItemBuilder setSkullOwner(String owner) {
        if (owner != null){
            try {
                SkullMeta im = (SkullMeta) is.getItemMeta();
                im.setOwner(owner);
                is.setItemMeta(im);
            } catch (ClassCastException expected) {
            }
        }
        return this;
    }

    public ItemBuilder addEnchant(Enchantment ench, int level) {
        ItemMeta im = is.getItemMeta();
        im.addEnchant(ench, level, true);
        is.setItemMeta(im);
        return this;
    }

    public Map<Enchantment, Integer> getEnchants(){
        ItemMeta im = is.getItemMeta();
        return im.getEnchants();
    }

    public ItemBuilder setInfinityDurability() {
        ItemMeta itemMeta = is.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        is.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder addLore(String... lore) {
        ItemMeta meta = is.getItemMeta();
        List<String> current = meta.getLore();
        if (current == null) {
            current = new ArrayList<String>();
        }
        current.addAll(Arrays.asList(lore));
        meta.setLore(current);
        is.setItemMeta(meta);
        return this;
    }

    public ItemBuilder switchLore(boolean setting){
        setAmount(setting ? 1 : 0);
        return this.addLore("", " §8┃ " + (setting ? "§aActivé" : "§cDésactivé"));
    }

    public ItemBuilder switchLore(boolean setting, String name){
        setAmount(setting ? 1 : 0);
        return this.addLore("", " §8┃ §f" + name + " §8» " + (setting ? "§aActivé" : "§cDésactivé"));
    }

    public ItemBuilder setLore(String... lore) {
        ItemMeta im = is.getItemMeta();
        im.setLore(Arrays.asList(lore));
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        ItemMeta im = is.getItemMeta();
        im.setLore(lore);
        is.setItemMeta(im);
        return this;
    }

    public List<String> getLore(){
        return is.getItemMeta().getLore();
    }

    public ItemBuilder setAmount(int amount){
        is.setAmount(amount);
        return this;
    }

    public ItemBuilder setLeatherArmorColor(Color color) {
        try {
            LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
            im.setColor(color);
            is.setItemMeta(im);
        } catch (ClassCastException expected) {
        }
        return this;
    }

    public ItemBuilder addFlag(ItemFlag... flag) {
        ItemMeta im = is.getItemMeta();
        im.addItemFlags(flag);
        is.setItemMeta(im);
        return this;
    }

    public ItemStack toItemStack() {
        return is;
    }

    public ItemBuilder setBannerColor(DyeColor colour) {
        if (!is.getType().equals(Material.BANNER)) {
            return this;
        }
        BannerMeta meta = (BannerMeta) this.is.getItemMeta();
        meta.setBaseColor(colour);
        this.is.setItemMeta(meta);
        return this;
    }
    public ItemBuilder addBannerPattern(DyeColor colour, PatternType type) {
        if (!is.getType().equals(Material.BANNER)) {
            return this;
        }
        BannerMeta meta = (BannerMeta) this.is.getItemMeta();
        meta.addPattern(new Pattern(colour, type));
        this.is.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setWoolColour(DyeColor colour) {
        if (!is.getType().equals(Material.WOOL) && !is.getType().equals(Material.STAINED_CLAY)) {
            return this;
        }
        this.is.setDurability(colour.getData());
        return this;
    }

}
