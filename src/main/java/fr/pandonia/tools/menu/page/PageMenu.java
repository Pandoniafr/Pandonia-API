package fr.pandonia.tools.menu.page;

import fr.pandonia.tools.Heads;
import fr.pandonia.tools.ItemBuilder;
import fr.pandonia.tools.menu.PandoniaMenu;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class PageMenu extends PandoniaMenu {
    public int page = 0;
    public List<ItemStack> list = new ArrayList<>();

    /**
     * La liste des items qui seront placés dans les différentes pages du menu.
     * @return La liste des items
     */
    public abstract List<ItemStack> getItemList();

    /**
     * Le slot de départ pour tous les items placés dans une pages
     * @return Le slot de départ
     */
    public int getStartSlot(){
        return getSlot(2, 2);
    }

    /**
     * Le slot de fin pour tous les items placé dans une pages
     * @return Le slot de fin
     */
    public int getEndSlot(){
        return getSlot(getLines() - 1, 8);
    }

    /**
     * Effectué à chaque cliques dans le menu
     * @param e
     *            InventoryClickEvent du click
     * @param index
     *            Si il s'agit d'un item contenu dans une page, l'index de cette item par rapport à la page actuelle (-1 si il s'agit d'un autre item)
     */
    public abstract void handle(InventoryClickEvent e, int index);

    public void handleMenu(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) return;
        if(e.getCurrentItem().getType().equals(getNextItem().getType())){
            if(e.getCurrentItem().getItemMeta().getDisplayName() != null && e.getCurrentItem().getItemMeta().getDisplayName().equals(getNextItem().getItemMeta().getDisplayName())
                    && getItemList().size() > (page * getItemNumber()) + getItemNumber()){
                page++;
            }else if(page != 0){
                page--;
            }
            setMenuItems();
        }
        handle(e, getIndex(e.getSlot()));
    }

    public void setPageItems(){
        setPageItems(getSlot(getLines(), 4), getSlot(getLines(), 6));
    }

    public void setPageItems(int prev, int next){
        if(getItemList().size() > (page * getItemNumber()) + getItemNumber()){
            inventory.setItem(next, getNextItem());
        }
        if(page != 0){
            inventory.setItem(prev, getPreviousItem());
        }
    }

    public ItemStack getNextItem(){
        return new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).getSkull(Heads.RIGHT_ARROW_WHITE).setName("§8» §7Page suivante").toItemStack();
    }

    public ItemStack getPreviousItem(){
        return new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).getSkull(Heads.LEFT_ARROW_WHITE).setName("§8» §7Page précédente").toItemStack();
    }

    /**
     * Si cela est possible, affiche la page suivante
     */
    public void nextPage(){
        if(getItemList().size() > (page * getItemNumber()) + getItemNumber()){
            page++;
            setItemOnPage();
        }
    }

    /**
     * Si cela est possible, affiche la page précédente
     *
     */
    public void previousPage(){
        if(page > 0){
            page--;
            setItemOnPage();
        }
    }

    /**
     * Si cela est possible, affiche la page suivante
     * @param slot
     *            Le slot du click
     * @return L'index
     */
    public int getIndex(int slot){
        int h = page * getItemNumber();
        for(int i = getStartSlot(); i < getEndSlot(); i+=9){
            for(int j = i; j < i + getItemPerLine(); j++, h++){
                if(j == slot) return h < getItemList().size() ? h : -1;
            }
        }
        return -1;
    }

    /**
     * Calcule le nombre d'item par ligne(s)
     *
     * @return Le nombre d'item par ligne(s)
     */
    public int getItemPerLine(){
        return getEndSlot()%9 - getStartSlot()%9 + 1;
    }

    /**
     * Calcule le nombre d'item(s) par colonne(s)
     *
     * @return Le nombre d'item(s) par colonne(s)
     */
    public int getItemPerCol(){
        return getEndSlot()/9 - (getStartSlot() == 0 ? 0 : getStartSlot()/9) + 1;
    }

    /**
     * Calcule le nombre d'item(s) par page(s)
     *
     * @return Le nombre d'item(s) par page(s)
     */
    public int getItemNumber(){
        return getItemPerLine() * getItemPerCol();
    }

    /**
     * Place les items dans le menu en fonction de tous les paramètres précédents
     * Doit être appelé dans la fonction setMenuItems() ou handle()
     */
    public void setItemOnPage(){
        if(getEndSlot() > inventory.getSize()) return;
        List<ItemStack> list = getItemList();
        int h = page * getItemNumber();
        for(int i = getStartSlot(); i < getEndSlot(); i+=9){
            for(int j = i; j < i + getItemPerLine(); j++, h++){
                if(h < list.size()){
                    inventory.setItem(j, list.get(h));
                }else{
                    inventory.setItem(j, new ItemStack(Material.AIR));
                }
            }
        }

    }
}
