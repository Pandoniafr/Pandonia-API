package fr.pandonia.tools.menu;

import fr.pandonia.tools.Heads;
import fr.pandonia.tools.ItemBuilder;
import fr.pandonia.tools.menu.page.PageItem;
import fr.pandonia.tools.menu.settings.IntSettingMenu;
import fr.pandonia.tools.menu.settings.IntegerItem;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public abstract class PandoniaMenu implements IPandoniaMenu, InventoryHolder {

    protected Inventory inventory;
    protected ItemStack FILLER_GLASS;
    protected ItemStack COLORED_GLASS;
    protected List<IntegerItem> intSettings;
    protected List<MenuItem> items;

    public PandoniaMenu() {
        FILLER_GLASS = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 7).setName(" ").toItemStack();
        COLORED_GLASS = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, PandoniaMenuPreset.menuColor.getWoolData()).setName(" ").toItemStack();
        this.intSettings = new ArrayList<>();
        this.items = new ArrayList<>();
        this.init();
    }

    /**
     * Création du menu en fonction du nombre de lignes et du nom du menu
     * Place les items
     */
    public void init() {
        inventory = Bukkit.createInventory(this, getSlots(), "§7" + getNamePattern());
        //this.setMenuItems();
    }

    public void onClose(InventoryCloseEvent e){

    }

    public void checkIntSettings(InventoryClickEvent e){
        for (IntegerItem integerItem : this.intSettings) {
            if(e.getSlot() == integerItem.slot && integerItem.toChange.length > 0){
                if(e.isShiftClick() || integerItem.toChange.length == 1){
                    if(e.isLeftClick()){
                        integerItem.setting = Math.min(integerItem.max, integerItem.setting + (integerItem.isTimer() ? integerItem.toChange[0]*60 : integerItem.toChange[0]));
                    }else if(e.isRightClick()){
                        integerItem.setting = Math.max(integerItem.min, integerItem.setting - (integerItem.isTimer() ? integerItem.toChange[0]*60 : integerItem.toChange[0]));
                    }
                    integerItem.handler.onClick(new IntegerItem.ChangeEvent(integerItem.setting));
                    setMenuItems();
                }else{
                    new IntSettingMenu(integerItem).open(e.getWhoClicked());
                    return;
                }
            }
        }
    }

    public void checkMenuItems(InventoryClickEvent e){
        if(e.getClickedInventory().equals(this.inventory)){
            for (MenuItem item : items) {
                if(getSlot(item.getLigne(), item.getColonne()) == e.getSlot()){
                    item.getEvent().onClick(e);
                    return;
                }
            }
        }
    }

    /**
     * Défini le pattern du titre du menu
     * @return le pattern du titre du menu
     */
    public String getNamePattern(){
        return "§f➤ " + PandoniaMenuPreset.textColor + getMenuName();
    }

    /**
     * Nom du menu
     * @return le nom du menu
     */
    public abstract String getMenuName();

    /**
     * Effectué à chaque cliques dans le menu
     * @param e InventoryClickEvent du click
     */
    public abstract void handleMenu(InventoryClickEvent e);

    /**
     * Places les items dans le menu (exécuté à la création de l'instance)
     */
    public abstract void setMenuItems();

    /**
     * Nombre de ligne(s)
     * @return Le nombre de ligne(s)
     */
    public abstract int getLines();

    /**
     * Nombre de slots
     * @return Le nombre de slot du menu
     */
    public int getSlots(){
        return getLines() * 9;
    }

    /**
     * Ouvre le menu à un joueur
     * @param p Le joueur
     */
    public void open(HumanEntity p) {
        setMenuItems();
        p.openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Place un item en fonction d'une ligne et une colonne
     * @param ligne La ligne
     * @param colonne La colonne
     * @param it L'item qui sera placé.
     */
    public void set(int ligne, int colonne, ItemStack it){
        inventory.setItem(9*(ligne - 1) + (colonne - 1), it);
    }

    /**
     * Place un item en fonction d'une ligne et une colonne
     * @param ligne La ligne
     * @param colonne La colonne
     * @param it L'item qui sera placé.
     * @param click Ce qu'il se passe lorsqu'on clique sur l'item.
     */
    public void set(int ligne, int colonne, ItemStack it, ItemClickEvent click){
        set(ligne, colonne, it);
        items.removeIf(menuItem -> menuItem.getLigne() == ligne && menuItem.getColonne() == colonne);
        items.add(new MenuItem(ligne, colonne, click));
    }

    public interface ItemClickEvent {
        void onClick(InventoryClickEvent e);
    }

    /**
     * Donne le slot en fonction d'une ligne et une colonne
     * @param ligne La ligne
     * @param colonne La colonne
     */
    public int getSlot(int ligne, int colonne){
        return 9*(ligne - 1) + (colonne - 1);
    }

    /**
     * Place dans l'inventaire des "Glass Pane" dans les coins de l'inventaire
     * Doit être appelé dans la fonction setMenuItems()
     */
    public void setCornerGlass(DyeColor dyeColor){
        ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, dyeColor.getData()).setName(" ").toItemStack();

        inventory.setItem(0, glass);
        inventory.setItem(1, glass);
        inventory.setItem(7, glass);
        inventory.setItem(8, glass);
        inventory.setItem(9, glass);
        inventory.setItem(17, glass);

        inventory.setItem(inventory.getSize() - 18, glass);
        inventory.setItem(inventory.getSize() - 9, glass);
        inventory.setItem(inventory.getSize() - 8, glass);
        inventory.setItem(inventory.getSize() - 2, glass);
        inventory.setItem(inventory.getSize() - 10, glass);
        inventory.setItem(inventory.getSize() - 1, glass);
    }

    public void setCornerGlass(){
        setCornerGlass(PandoniaMenuPreset.menuColor);
    }

    public void playSound(HumanEntity p, Sound sound){
        if(p instanceof Player){
            ((Player) p).playSound(p.getLocation(), sound, 1, 1);
        }
    }

    public void playSound(HumanEntity p, String sound){
        if(p instanceof Player){
            ((Player) p).playSound(p.getLocation(), sound, 1, 1);
        }
    }

    /**
     * Remplace dans un inventaire tous les slots vides par des "Glass Pane"
     * @param inventory L'inventaire dans lequel seront placés les items
     * @param exception Les slots où ne seront pas placés les items
     */
    public void setFillerGlass(Inventory inventory, int ... exception){
        List<Integer> list = new ArrayList<>();
        for(int n : exception) list.add(n);
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null && !list.contains(i)){
                inventory.setItem(i, FILLER_GLASS);
            }
        }
    }

    public void setContourGlass(){
        setContourGlass(PandoniaMenuPreset.menuColor);
    }

    public void setContourGlass(DyeColor dyeColor){
        setContourGlass(dyeColor, 0, getSlots()-1);
    }

    public void setContourGlass(DyeColor dyeColor, int start, int end){
        ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, dyeColor.getData()).setName(" ").toItemStack();
        int itemPerLine = (end%9 - start%9);
        for (int i = start; i < end; i+=9) {
            for (int j = i; j <= i + itemPerLine; j++) {
                if(i == start || i == j || j == i +itemPerLine || i+9 > end){
                    inventory.setItem(j, glass);
                }
            }
        }
    }

    public void centerItemsOnLine(List<ItemStack> items, int line){
        int centerSlot = getSlot(line, 5);
        int slot = centerSlot - (items.size()/2);
        for (ItemStack item : items) {
            inventory.setItem(slot++, item);
            if(slot == centerSlot && items.size()%2 == 0){
                slot++;
            }
        }
    }

    public void centerItemsMenuOnLine(List<PageItem> items, int line, int size){
        int u = 0;
        for (int i = 0; i < size; i++) {
            List<PageItem> list = items.subList(u, Math.min(items.size(), ((items.size()+1)/size)*(i+1)));
            int centerSlot = getSlot(i + line, 5);
            int slot = centerSlot - (list.size()/2);
            for (PageItem item : list) {
                this.items.add(new MenuItem(slot, item.getEvent()));
                inventory.setItem(slot++, item.getItem());
                if(slot == centerSlot && list.size()%2 == 0){
                    slot++;
                }
                u++;
            }

        }
    }

    /**
     * Remplace dans l'inventaire tous les slots vides par des "Glass Pane"
     * @param exception Les slots où ne seront pas placés les "Glass Pane"
     */
    public void setFillerGlass(int ... exception){
        setFillerGlass(inventory, exception);
    }

    /**
     * Update les items de tous les menus ouvert par des joueurs
     */
    public static void updateAllOpenMenu(){
        updateAllOpenMenu(PandoniaMenu.class);
    }

    /**
     * Update les items de tous les menus ouvert d'un menu défini par des joueurs
     * @param pandoraMenu Le menu
     */
    public static void updateAllOpenMenu(PandoniaMenu pandoraMenu){
        updateAllOpenMenu(pandoraMenu.getClass());
    }

    /**
     * Update les items de tous les menus ouvert d'un menu défini par des joueurs
     * @param pandoraMenu La class du menu
     */
    public static void updateAllOpenMenu(Class<? extends PandoniaMenu> pandoraMenu){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(p.getOpenInventory() != null){
                InventoryHolder inv = p.getOpenInventory().getTopInventory().getHolder();
                if(pandoraMenu.isInstance(inv)){
                    PandoniaMenu menu = (PandoniaMenu) inv;
                    menu.setMenuItems();
                }
            }
        }
    }

    /**
     * Place l'item de retour
     */
    public void setBack(){
        inventory.setItem(inventory.getSize() - 1, new ItemBuilder(Material.SKULL_ITEM, 1, (byte) 3).getSkull(Heads.BACK).setName("§cRetour").toItemStack());
    }

    /**
     * Vérifie si l'item de retour a été cliqué et retourne vers le menu indiqué
     * @param e L'InventoryClickEvent
     * @param menu Le menu de retour
     * @return true si l'item de retour a été cliqué et retourne vers le menu indiqué
     */
    public boolean checkBack(InventoryClickEvent e, PandoniaMenu menu){
        if(e.getSlot() == inventory.getSize() - 1){
            if(menu != null){
                menu.open(e.getWhoClicked());
            }else{
                e.getWhoClicked().closeInventory();
            }
            return true;
        }
        return false;
    }

    /**
     * Vérifie si l'item de retour a été cliqué et ferme le menu si il est cliqué.
     * @param e L'InventoryClickEvent
     * @return true si l'item de retour a été cliqué et retourne vers le menu indiqué
     */
    public boolean checkBack(InventoryClickEvent e){
        if(e.getSlot() == inventory.getSize() - 1){
            e.getWhoClicked().closeInventory();
            return true;
        }
        return false;
    }

    /**
     *
     * @param slot Le slot où sera placé l'item dans l'inventaire
     * @param menu Le menu qui sera ouvert lors du retour
     * @param material Le material utilisé pour l'item
     * @param name Le nom du paramètre
     * @param unite L'unité indiquée après la valeur du paramètre
     * @param setting La valeur du paramètre
     * @param handler Ce qui se passe lorsque le paramètre est modifier
     * @param min La valeur minimum
     * @param max La valeur maximum
     * @param toChange Les différentes valeurs modifiables
     */
    public void addIntegerItem(int slot, PandoniaMenu menu, ItemStack material, String name, String unite, double setting, IntegerItem.ChangeEventHandler handler, double min, double max, double ... toChange){
        DecimalFormat format = new DecimalFormat("0.#");
        String u = unite;
        double set = u.contains("minute") ? setting/60 : setting;
        if(unite.contains("-s")){
            u = u.replace("-s", (set < 2 ? "" : "s"));
        }
        String prefix = "";
        if(unite.contains("_")){
            prefix = u.split("_")[0];
            u = u.split("_")[1];
        }
        ItemBuilder it = new ItemBuilder(material).setName("§8» §f" + name).setLore("","§f" + format.format(set) + " §7" + prefix + u).addFlag(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        IntegerItem integerItem = new IntegerItem(slot, menu, it.toItemStack(), name, unite, setting, handler, min, max, toChange).setTimer(unite.contains("minute"));
        this.intSettings.add(integerItem);
        if(toChange.length > 0){
            if(toChange.length > 1){
                it.addLore(
                        "",
                        " §8┃ §fConfigurer §f:",
                        " §8┃ "+PandoniaMenuPreset.textColor+"Clic-Droit §fou "+PandoniaMenuPreset.textColor+"Clic-Gauche");
            }
            it.addLore(
                    "",
                    " §8┃ §f" + (toChange.length == 1 ? "Configurer" : "Modification Rapide") + " §f:",
                    " §8┃ "+PandoniaMenuPreset.textColor+"" + (toChange.length == 1 ? "" : "Shift+") + "Clic-Gauche §8» §a+" + format.format(toChange[0]),
                    " §8┃ "+PandoniaMenuPreset.textColor+"" + (toChange.length == 1 ? "" : "Shift+") + "Clic-Droit §8» §c-" + format.format(toChange[0]),
                    "");
        }
        this.inventory.setItem(integerItem.slot, it.toItemStack());
    }
}
