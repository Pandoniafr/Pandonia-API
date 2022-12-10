package fr.pandonia.tools.npc;

import fr.pandonia.api.PandoniaAPI;
import fr.pandonia.tools.npc.api.NPC;
import fr.pandonia.tools.npc.api.skin.MineSkinFetcher;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.List;

public abstract class PandoniaNPC implements Listener {

    private Location location;
    private int skinId;
    private String skinUUID;
    private List<String> lines;
    private NPCCreateEvent event;

    private NPC npc;

    public PandoniaNPC(Location location, int skinId, List<String> lines) {
        this.location = location;
        this.skinId = skinId;
        this.lines = lines;
    }

    public PandoniaNPC(Location location, String skinUUID, List<String> lines) {
        this.location = location;
        this.skinUUID = skinUUID;
        this.lines = lines;
    }

    public void create(){
        create(null);
    }

    public void create(NPCCreateEvent event){
        if(skinUUID != null){
            System.out.println("string uuid");
            MineSkinFetcher.fetchSkinFromUUIDAsync(skinUUID, skin -> {
                System.out.println("get skin");
                this.npc = PandoniaAPI.get().getNPCLib().createNPC(lines);
                if (location != null){
                    assert npc != null;
                    npc.setLocation(location);
                }else{
                    System.out.println("ERREUR: LOCATION NULL");
                }
                npc.setSkin(skin);
                npc.create();
                if(event != null){
                    event.npc(npc);
                }
                for (Player p : Bukkit.getOnlinePlayers()){
                    show(p);
                }
            });
        }else{
            MineSkinFetcher.fetchSkinFromIdAsync(skinId, skin -> {
                this.npc = PandoniaAPI.get().getNPCLib().createNPC(lines);
                if (location != null){
                    assert npc != null;
                    npc.setLocation(location);
                }else{
                    System.out.println("ERREUR: LOCATION NULL");
                }
                npc.setSkin(skin);
                npc.create();
                if(event != null){
                    event.npc(npc);
                }
                for (Player p : Bukkit.getOnlinePlayers()){
                    show(p);
                }
            });
        }
    }

    public abstract void onInteract(Player p);

    public abstract boolean updateLines();

    /*@EventHandler
    public void onNPCInteract(NPCInteractEvent e){
        if (e.getNPC().getEntityId() == npc.getEntityId()){
            onInteract(e.getWhoClicked());
            PacketPlayOutAnimation packet = new PacketPlayOutAnimation();
            Reflection.getField(packet.getClass(), "a", int.class).set(packet, npc.getEntityId());
            Reflection.getField(packet.getClass(), "b", int.class).set(packet, 0);
            ((CraftPlayer)e.getWhoClicked()).getHandle().playerConnection.sendPacket(packet);
        }
    }*/

    public void updateView(){
        for (Player p : Bukkit.getOnlinePlayers()){
            sendUpdatedLines(p);
        }
    }

    public void show(Player p){
        if (npc != null){
            npc.show(p);
        }
    }

    public Location getLocation() {
        return location;
    }

    public int getSkin() {
        return skinId;
    }

    public List<String> getLines() {
        return lines;
    }

    public void addLine(String line){
        this.lines.add(line);
    }

    public void removeLine(String line){
        this.lines.remove(line);
    }

    public void setLine(int index, String line){
        this.lines.set(index, line);
    }

    protected void setLines(){
        if (npc != null){
            npc.setText(lines);
        }
    }

    public NPC getNpc() {
        return npc;
    }

    private void sendUpdatedLines(Player p){
        npc.updateLines(p);
    }

    public interface NPCCreateEvent {
        void npc(NPC npc);
    }
}