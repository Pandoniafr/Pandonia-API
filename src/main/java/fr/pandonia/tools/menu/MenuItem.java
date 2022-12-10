package fr.pandonia.tools.menu;

public class MenuItem {
    private int ligne;
    private int colonne;
    private PandoniaMenu.ItemClickEvent event;

    public MenuItem(int ligne, int colonne, PandoniaMenu.ItemClickEvent event) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.event = event;
    }

    public MenuItem(int slot, PandoniaMenu.ItemClickEvent event) {
        this.ligne = (slot/9) + 1;
        this.colonne = (slot%9) + 1;
        this.event = event;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public PandoniaMenu.ItemClickEvent getEvent() {
        return event;
    }
}
