package US.Siiant.Forgery.Listeners;

import US.Siiant.Forgery.GUI.GUIS;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;


public class ForgeInventoryClose implements Listener {

    @EventHandler
    public void forgeInventoryClose(InventoryCloseEvent e) { // Checks to see if any of the players items are in the GUI, and returns them.
            if (GUIS.myGUIS(e)) {
                if(GUIS.returnItems(e, GUIS.getType(e))){
                    e.getPlayer().sendMessage("Test");
                }
            }
    }
}
