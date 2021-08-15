package US.Siiant.Forgery.Listeners;

import US.Siiant.Forgery.Blocks.Forge.Forge;
import US.Siiant.Forgery.Blocks.Infuser.Infuser;
import US.Siiant.Forgery.Data.JSONData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;


public class ForgePlace implements Listener {

    @EventHandler
    public void onForgePlace(BlockPlaceEvent e){
        if(e.getItemInHand().hasItemMeta() && e.getItemInHand().getItemMeta().equals(Forge.getItemMeta())){
           new JSONData("Forges").logBlock(e);
        } else if ( e.getItemInHand().hasItemMeta() && e.getItemInHand().getItemMeta().equals(Infuser.getInfuserMeta())){
            new JSONData("Infusers").logBlock(e);
        }
    }
}
