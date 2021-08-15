package US.Siiant.Forgery.Listeners;

import US.Siiant.Forgery.GUI.Items.Items;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

import static US.Siiant.Forgery.Listeners.ForgeClick.getForge;
import static US.Siiant.Forgery.Listeners.ForgeClick.getInfuser;


public class ForgeInventoryClick implements Listener {
    @EventHandler
    public void onForgeClick(InventoryClickEvent e){
        try {
            if (e.getView().getTopInventory().equals(getForge().getInventory()) || e.getView().getTopInventory().equals(getInfuser().getInventory())) {
                if (Items.getItems(Objects.requireNonNull(e.getCurrentItem()))) {
                    e.setCancelled(true);
                } else {

                }
            }
        }
        catch(NullPointerException ignored){
        }
    }

}
