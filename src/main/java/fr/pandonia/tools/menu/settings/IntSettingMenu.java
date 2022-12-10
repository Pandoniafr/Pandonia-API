package fr.pandonia.tools.menu.settings;

import fr.pandonia.tools.Heads;
import fr.pandonia.tools.ItemBuilder;
import fr.pandonia.tools.menu.PandoniaMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.text.DecimalFormat;

public class IntSettingMenu extends PandoniaMenu {

    private IntegerItem integerItem;

    public IntSettingMenu(IntegerItem integerItem) {
        this.integerItem = integerItem;
        inventory = Bukkit.createInventory(this, getSlots(), getNamePattern());
        setMenuItems();
    }

    @Override
    public void init() {
    }

    @Override
    public String getMenuName() {
        return integerItem.name;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        checkBack(e, this.integerItem.menu);
        int i = 2;
        for (double change : integerItem.toChange) {
            if(e.getSlot() == 4-i){
                integerItem.setting = Math.max(integerItem.min, integerItem.setting - (integerItem.isTimer() ? change*60 : change));
            }
            else if(e.getSlot() == 4+i){
                integerItem.setting = Math.min(integerItem.max, integerItem.setting + (integerItem.isTimer() ? change*60 : change));
            }
            i++;
        }
        integerItem.handler.onClick(new IntegerItem.ChangeEvent(integerItem.setting));
        updateAllOpenMenu();
    }

    @Override
    public void setMenuItems() {
        String unite = integerItem.unite;
        double set = integerItem.isTimer() ? integerItem.setting/60 : integerItem.setting;
        if(unite.contains("-s")){
            unite = unite.replace("-s", (set < 2 ? "" : "s"));
        }
        String prefix = "";
        if(unite.contains("_")){
            prefix = unite.split("_")[0];
            unite = unite.split("_")[1];
        }
        DecimalFormat format = new DecimalFormat("0.#");
        set(1, 5, new ItemBuilder(integerItem.it).setLore("", "§f" + format.format(set) + " §7" + prefix + unite).toItemStack());
        int i = 2;
        for (double change : integerItem.toChange) {
            ItemBuilder it = new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setLore("", "§f" + format.format(set) + " §7" + unite);
            set(1, 5 - i, it.getSkull(Heads.MINUS[i-2]).setName("§c-" + format.format(change)).toItemStack());
            set(1, 5 + i, it.getSkull(Heads.PLUS[i-2]).setName("§a+" + format.format(change)).toItemStack());
            i++;
        }
        setFillerGlass(0,1,3,5,7,8);
        setBack();
    }

    @Override
    public int getLines() {
        return 2;
    }
}
