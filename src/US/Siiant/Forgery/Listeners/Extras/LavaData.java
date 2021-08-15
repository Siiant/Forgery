package US.Siiant.Forgery.Listeners.Extras;

import US.Siiant.Forgery.Data.JSONData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

public class LavaData {

    public static boolean lavaCheck(String fileName, InventoryOpenEvent e){
        return new JSONData(fileName).getLava(e.getInventory().getLocation()) < 18 && e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.LAVA_BUCKET);
    }

    public static void addLava(String fileName, InventoryOpenEvent e){
        JSONData jsonData = new JSONData(fileName);
        e.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.BUCKET));// Set the lava bucket to a normal bucket
        Player player = (Player) e.getPlayer();
        player.updateInventory();
        jsonData.addLava(e.getInventory().getLocation(), jsonData.getLava(e.getInventory().getLocation()) + 1);
    }
}
