package US.Siiant.Forgery.Listeners;

import US.Siiant.Forgery.GUI.Forge.ForgeGUI;
import US.Siiant.Forgery.GUI.Infuser.InfuserGUI;
import US.Siiant.Forgery.Listeners.Extras.LavaData;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

import static US.Siiant.Forgery.Data.JSONData.forgeExists;
import static US.Siiant.Forgery.Data.JSONData.infuserExists;

public class ForgeClick implements Listener {

    private static ForgeGUI forge;
    private static InfuserGUI infuser;

    @EventHandler
    public void onForgeClick(InventoryOpenEvent e){// Happens when a player clicks on something that opens an inventory
        if(e.getInventory().getType() == InventoryType.ANVIL){ // Check to see if a player is clicking on an anvil
            if(forgeExists(e.getInventory().getLocation())){// Check to see if the forge exists
                e.setCancelled(true); // Cancel the anvil GUI
                if(e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.LAVA_BUCKET)) { // See if a player is holding a lava bucket
                    if(LavaData.lavaCheck("Forges", e)) {
                        LavaData.addLava("Forges", e);
                    } else {
                        e.getPlayer().sendMessage("You have too much lava already.");
                    }
                } else if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BUCKET) || e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.WATER_BUCKET)){
                    e.getPlayer().sendMessage("You need to get lava chief.");
                } else {
                    forge = new ForgeGUI(e.getInventory().getLocation());
                    e.getPlayer().openInventory(forge.getInventory());
                }
            }
        }else if(e.getInventory().getType() == InventoryType.BREWING && infuserExists(e.getInventory().getLocation())){
                e.setCancelled(true);
                if(e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.LAVA_BUCKET)) { // See if a player is holding a lava bucket
                    if(LavaData.lavaCheck("Infusers", e)) {
                      LavaData.addLava("Infusers", e);
                    } else {
                        e.getPlayer().sendMessage("You have too much lava already.");
                    }
                } else if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BUCKET) || e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.WATER_BUCKET)) {
                    e.getPlayer().sendMessage("You need to get lava chief.");
                } else {
                    infuser = new InfuserGUI(e.getInventory().getLocation());
                    e.getPlayer().openInventory(infuser.getInventory());
                }
            }
    }


    public static ForgeGUI getForge() { return forge; }

    public static InfuserGUI getInfuser(){return infuser;}


}
