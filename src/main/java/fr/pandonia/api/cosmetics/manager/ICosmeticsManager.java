package fr.pandonia.api.cosmetics.manager;

import fr.pandonia.api.cosmetics.ICosmetic;
import fr.pandonia.api.cosmetics.arena.IArenaBlock;
import fr.pandonia.api.cosmetics.armor.IArmor;
import fr.pandonia.api.cosmetics.arrow.IArrow;
import fr.pandonia.api.cosmetics.gadget.IGadget;
import fr.pandonia.api.cosmetics.killanimation.IKillAnimation;
import fr.pandonia.api.cosmetics.pet.IPet;
import fr.pandonia.api.cosmetics.pet.IPetArmorStand;
import fr.pandonia.api.player.IPPlayer;
import fr.pandonia.tools.menu.PandoniaMenu;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public interface ICosmeticsManager {

    /**
     * Récupère si les cosmétiques sont activés sur cette instance
     * @return
     */
    boolean isEnabled();

    /**
     * Défini si les cosmétiques sont activés sur cette instance
     */
    void setEnabled(boolean enabled);

    /**
     * Charge les {@link ICosmetic} en cache
     */
    void registerCosmetics();

    /**
     * Méthode éxécutée à la connexion d'un joueur à l'instance pour charger ses cosmétiques
     * @param pp
     */
    void onJoin(IPPlayer pp);

    /**
     * Méthode éxécutée à la déconnexion d'un joueur à l'instance pour décharger ses cosmétiques
     * @param uuid
     */
    void onQuit(UUID uuid);

    /**
     * Démarre la task qui actualise les positions des Pets
     */
    void startUpdateAllPets();

    /**
     * Actualise les potions des Pets
     */
    void updateAllPets();

    /**
     * Défini le Pet d'un joueur: Faire disparraître son ancien pet et fait apparâitre le nouveau
     * @param pet Nouveau Pet du joueur
     * @param player joueur
     */
    void setPet(IPet pet, Player player);

    /**
     * Fais disparaître les Pets liés à un joueur (via son UUID)
     * @param uuid UUID du joueur
     */
    void removePet(UUID uuid);

    /**
     * Fais disparaître tout les Pets
     */
    void removeAllPets();

    /**
     * Récupère un Pet chargé en cache grâce à son ID
     * @param id id du Pet à chercher
     * @return Pet trouvé (ou null)
     */
    IPet getPet(int id);

    /**
     * Récupère un Pet chargé en cache grâce à son nom
     * @param name nom du Pet à chercher
     * @return Pet trouvé (ou null)
     */
    IPet getPet(String name);

    /**
     * Récupère le "Pet à son effigie" d'un joueur
     * @param p joueur
     * @return le Pet ) l'effigie du joueur
     */
    IPet getOwnPet(Player p);

    /**
     * Récupère la liste des Pets appartenants à une catégorie
     * @param category catégorie
     * @return la liste des Pets
     */
    List<IPet> getPetsFromCategory(String category);

    /**
     * Récupère l'arena block en fonction de son blockID et data
     * @param id le block id
     * @param data la data
     * @return l'arena block
     */
    IArenaBlock getArenaBlock(int id, int data);

    /**
     * Récupère l'arena block en fonction de son id
     * @param id l'id
     * @return l'arena block
     */
    IArenaBlock getArenaBlock(int id);

    /**
     * Récupère la liste de tous les cosmetics "arrow"
     * @return la liste de tous les cosmetics "arrow"
     */
    List<IArrow> getArrows();

    /**
     * Récupère l'arrow grâce à l'id
     * @param id l'id
     * @return l'arrow
     */
    IArrow getArrow(int id);

    /**
     * Récupère l'arrow grâce à son nom
     * @param name le nom
     * @return l'arrow
     */
    IArrow getArrow(String name);

    /**
     * Récupère le gadget grâce à l'id
     * @param id l'id
     * @return le gadget
     */
    IGadget getGadget(int id);

    IGadget getGadget(String name);

    /**
     * Récupère la liste de tous les cosmetics "Gadgets"
     * @return la liste de tous les cosmetics "Gadgets"
     */
    List<IGadget> getGadgets();

    IGadget getGadget(ItemStack is);

    /**
     * Récupère le killanimation grâce à l'id
     * @param id l'id
     * @return le killanimation
     */
    IKillAnimation getKillAnimation(int id);

    IKillAnimation getKillAnimation(String name);

    /**
     * Récupère la liste de tous les cosmetics "Kill Animation"
     * @return la liste de tous les cosmetics "Kill Animation"
     */
    List<IKillAnimation> getKillAnimations();

    IArmor getArmor(int id);

    /**
     * Récupère un cosmetic "Armor" en fonction de l'itemstack donné
     * @param itemStack l'itemstack
     * @return l'armor
     */
    IArmor getArmor(ItemStack itemStack);

    /**
     * Récupère la liste de tous les cosmetics "Armor"
     * @return la liste de tous les cosmetics "Armor"
     */
    List<IArmor> getArmors();

    /**
     * Récupère la liste des Pets chargés en cache
     * @return la liste des Pets chargés en cache
     */
    List<IPet> getPets();

    /**
     * Récupère la liste des Pets chargés en cache
     * @return la liste des Pets chargés en cache
     */
    List<IArenaBlock> getArenaBlocks();

    /**
     * Récupère la liste des PetArmorStands
     * @return la liste des PetArmorStands
     */
    List<IPetArmorStand> getPetArmorStands();

    /**
     * Récupère le menu pour les block de l'arena
     * @param p Le joueur
     * @return Le menu du joueur pour les blocks de l'arena
     */
    PandoniaMenu getArenaBlockMenu(PandoniaMenu back, Player p);
}
