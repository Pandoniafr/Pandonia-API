package fr.pandonia.tools.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface IPandoniaMenu {
    /**
     * Création du menu en fonction du nombre de lignes et du nom du menu
     * Place les items
     */
    void init();

    /**
     * Nom du menu
     * @return le nom du menu
     */
    String getMenuName();

    /**
     * Effectué à chaque cliques dans le menu
     * @param e InventoryClickEvent du click
     */
    void handleMenu(InventoryClickEvent e);

    /**
     * Places les items dans le menu (exécuté à la création de l'instance)
     */
    void setMenuItems();

    /**
     * Nombre de ligne(s)
     * @return Le nombre de ligne(s)
     */
    int getLines();

    /**
     * Nombre de slots
     * @return Le nombre de slot du menu
     */
    int getSlots();

    /**
     * Ouvre le menu à un joueur
     * @param p Le joueur
     */
    void open(HumanEntity p);

    Inventory getInventory();

    /**
     * Place un item en fonction d'une ligne et une colonne
     * @param ligne La ligne
     * @param colonne La colonne
     * @param it L'item qui sera placé.
     */
    void set(int ligne, int colonne, ItemStack it);

    /**
     * Donne le slot en fonction d'une ligne et une colonne
     * @param ligne La ligne
     * @param colonne La colonne
     * @return le slot en fonction d'une ligne et une colonne
     */
    int getSlot(int ligne, int colonne);

    /**
     * Place dans l'inventaire des "Glass Pane" dans les coins de l'inventaire
     * Doit être appelé dans la fonction setMenuItems()
     */
    void setCornerGlass();

    /**
     * Remplace dans un inventaire tous les slots vides par des "Glass Pane"
     * @param inventory L'inventaire dans lequel seront placés les items
     * @param exception Les slots où ne seront pas placés les items
     */
    void setFillerGlass(Inventory inventory, int ... exception);

    /**
     * Remplace dans l'inventaire tous les slots vides par des "Glass Pane"
     * @param exception Les slots où ne seront pas placés les "Glass Pane"
     */
    void setFillerGlass(int ... exception);

    /**
     * Place l'item de retour
     */
    void setBack();

    /**
     * Vérifie si l'item de retour a été cliqué
     * @param e {@link InventoryClickEvent} lié
     * @param menu PandoraMenu
     * @return
     */
    boolean checkBack(InventoryClickEvent e, PandoniaMenu menu);

    /**
     * Update les items de tous les menus ouvert par des joueurs
     */
    public static void updateAllOpenMenu(){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(p.getOpenInventory() != null){
                InventoryHolder inv = p.getOpenInventory().getTopInventory().getHolder();
                if(inv instanceof PandoniaMenu){
                    PandoniaMenu menu = (PandoniaMenu) inv;
                    menu.setMenuItems();
                }
            }
        }
    }
}
