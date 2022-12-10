package fr.pandonia.api.battlepass;

import fr.pandonia.api.player.IPPlayer;
import fr.pandonia.api.player.battlepass.IPlayerBattlePass;
import fr.pandonia.api.player.owning.IPlayerOwning;

public class ItemGiveEvent {
    private IPPlayer player;
    private IPlayerOwning owning;
    private IPlayerBattlePass battlePass;

    public ItemGiveEvent(IPPlayer player, IPlayerOwning owning, IPlayerBattlePass battlePass) {
        this.player = player;
        this.owning = owning;
        this.battlePass = battlePass;
    }

    public IPPlayer getPlayer() {
        return player;
    }

    public IPlayerOwning getOwning() {
        return owning;
    }

    public IPlayerBattlePass getBattlePass() {
        return battlePass;
    }
}
