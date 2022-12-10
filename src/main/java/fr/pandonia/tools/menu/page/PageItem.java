package fr.pandonia.tools.menu.page;

import fr.pandonia.tools.menu.PandoniaMenu;
import org.bukkit.inventory.ItemStack;

public class PageItem {
    private ItemStack it;
    private PandoniaMenu.ItemClickEvent e;
    private int slot;

    public PageItem(ItemStack it, PandoniaMenu.ItemClickEvent e) {
        this.it = it;
        this.e = e;
        this.slot = -1;
    }

    public ItemStack getItem() {
        return it;
    }

    public PandoniaMenu.ItemClickEvent getEvent() {
        return e;
    }

    public boolean isOnPage() {
        return slot != -1;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
