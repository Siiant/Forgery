package US.Siiant.Forgery.Listeners;

import US.Siiant.Forgery.Data.JSONData;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ForgeDestroy implements Listener {

    @EventHandler
    public void onForgeDestroy(BlockBreakEvent e){
        if(e.getBlock().getType().equals(Material.ANVIL) && JSONData.forgeExists(e.getBlock().getLocation())){
            new JSONData("Forges").remove(e.getBlock().getLocation());
        } else if(e.getBlock().getType().equals(Material.BREWING_STAND) && JSONData.infuserExists(e.getBlock().getLocation())){
            new JSONData("Infusers").remove(e.getBlock().getLocation());
        }
    }
}
