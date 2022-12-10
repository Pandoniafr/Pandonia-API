package fr.pandonia.tools.menu;

import fr.pandonia.api.PandoniaAPI;
import org.bukkit.DyeColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ConfirmationMenu extends PandoniaMenu {
    BukkitRunnable runnable;
    HumanEntity p;
    PandoniaMenu menu;
    String name;
    private DyeColor dyeColor;

    public ConfirmationMenu(HumanEntity p, PandoniaMenu menu, String name, BukkitRunnable runnable) {
        this.runnable = runnable;
        this.p = p;
        this.menu = menu;
        this.name = name;
        super.init();
        open(p);
    }

    @Override
    public String getNamePattern() {
        return "§7" + getMenuName();
    }

    public ConfirmationMenu(HumanEntity p, PandoniaMenu menu, String name, DyeColor dyeColor, BukkitRunnable runnable) {
        this.runnable = runnable;
        this.p = p;
        this.menu = menu;
        this.name = name;
        this.dyeColor = dyeColor;
        super.init();
        open(p);
    }

    @Override
    public void init() {
    }

    @Override
    public String getMenuName() {
        return name;
    }

    @Override
    public int getLines() {
        return 3;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        switch (e.getSlot()){
            case 12:
                menu.open(p);
                break;
            case 14:
                runnable.runTask(PandoniaAPI.get().getPlugin());
                menu.open(p);
        }
    }

    @Override
    public void setMenuItems() {
        inventory.setItem(12, PandoniaMenuPreset.getCancelItem());
        inventory.setItem(14, PandoniaMenuPreset.getValiderItem());
        setCornerGlass(dyeColor == null ? DyeColor.GRAY : dyeColor);
    }
}
