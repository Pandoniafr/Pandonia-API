package fr.pandonia.api.guild;

import fr.pandonia.api.player.ISimplePlayer;
import net.minecraft.server.v1_8_R3.ItemStack;
import org.bson.Document;

import java.util.Date;

public interface IGuildMember extends ISimplePlayer {

    /**
     * Récupère le rank du joueur dans la guilde
     * @return le rank du joueur dans la guilde
     */
    GuildRank getGuildRank();

    /**
     * Récupère l'XP qu'a apporté le joueur à la guilde
     * @return l'XP qu'a apporté le joueur à la guilde
     */
    int getXPGathered();

    /**
     * Récupère les saphirs qu'a apporté le joueur à la guilde
     * @return les saphirs qu'a apporté le joueur à la guilde
     */
    int getSaphirsGiven();

    /**
     * Récupère la date à laquelle un joueur a rejoint la team
     * @return la date à laquelle un joueur a rejoint la team
     */
    Date getJoin();

    void loadHead();

    /**
     * Récupère la tête du joueur
     * @return la tête du joueur
     */
    ItemStack getHead();

    /**
     * Récupère la guilde sous format Document
     * @return la guilde sous format Document
     */
    Document toDocument();
}
