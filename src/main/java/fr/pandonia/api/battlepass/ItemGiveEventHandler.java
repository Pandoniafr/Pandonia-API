package fr.pandonia.api.battlepass;

public interface ItemGiveEventHandler {
    void onItemGive(ItemGiveEvent event) throws BPException;
}