package fr.pandonia.tools.menu;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CraftGUIMenu extends PandoniaMenu {
    private final ShapedRecipe shapedRecipe;
    private final PandoniaMenu menu;

    public CraftGUIMenu(PandoniaMenu menu, ShapedRecipe shapedRecipe) {
        this.menu = menu;
        this.shapedRecipe = shapedRecipe;
        inventory = Bukkit.createInventory(this, getSlots(), shapedRecipe.getResult().getItemMeta().getDisplayName() == null ? "Craft" : shapedRecipe.getResult().getItemMeta().getDisplayName());
        setMenuItems();
    }

    @Override
    public void init() {

    }

    @Override
    public String getMenuName() {
        return "Craft";
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        checkBack(e, this.menu);
    }

    @Override
    public void setMenuItems() {
        int i = 1;
        for(String s : shapedRecipe.getShape()) {
            for(Character c : s.toCharArray()){
                if(c != ' '){
                    inventory.setItem(i, new ItemStack(shapedRecipe.getIngredientMap().get(c)));
                }
                i++;
            }
            i+=6;
        }
        inventory.setItem(15, new ItemStack(shapedRecipe.getResult()));
        setBack();
        setFillerGlass(1,2,3, 10,11,12, 19,20,21);
    }

    @Override
    public int getLines() {
        return 3;
    }
}
