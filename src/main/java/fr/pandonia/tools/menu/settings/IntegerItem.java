package fr.pandonia.tools.menu.settings;

import fr.pandonia.tools.menu.PandoniaMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class IntegerItem {
    public int slot;
    public PandoniaMenu menu;
    public ItemStack it;
    public Material m;
    public String name;
    public String unite;
    public double setting;
    public ChangeEventHandler handler;
    public double[] toChange;
    public boolean timer;
    public double min;
    public double max;

    public IntegerItem(int slot, PandoniaMenu menu, ItemStack it, String name, String unite, double setting, ChangeEventHandler handler, double min, double max, double ... toChange) {
        this.timer = false;
        this.slot = slot;
        this.menu = menu;
        this.it = new ItemStack(it);
        this.m = m;
        this.name = name;
        this.unite = unite;
        this.setting = setting;
        this.handler = handler;
        this.toChange = toChange;
        this.min = min;
        this.max = max;
    }

    public interface ChangeEventHandler{
        void onClick(ChangeEvent change);
    }

    public static class ChangeEvent{
        private double change;

        public ChangeEvent(double change) {
            this.change = change;
        }

        public double getNewValue() {
            return change;
        }
    }

    public boolean isTimer() {
        return timer;
    }

    public IntegerItem setTimer(boolean timer) {
        this.timer = timer;
        return this;
    }
}