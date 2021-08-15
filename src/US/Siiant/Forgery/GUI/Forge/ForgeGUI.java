package US.Siiant.Forgery.GUI.Forge;

import US.Siiant.Forgery.Data.JSONData;
import US.Siiant.Forgery.GUI.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class ForgeGUI {

    public Inventory forge;
    public Location location;

    public ForgeGUI(Location location){
        this.location = location;
        forge = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&c&lForge"));
        JSONData jsonData = new JSONData("Forges"); // Load the "Forges" json file
        int lavaCount = jsonData.getLava(location); // Get the amount of lava the generator has
        int exp = 0; // Same with the experience of the user.
        List<String> lore = new ArrayList<>(); // Create an empty array list for the lore
        lore.add(" "); // For now we're going to make the lore blank
        int row = 6;
        for(int i = 0; i <= 53; i++){
            if (i == 49){
                //Do nothing, this is where the finished item will be.
            } else if (i == 12 || i == 13 || i == 14 || i == 21 || i == 22 || i == 23 || i == 30 || i == 31 || i == 32){
                // Also do nothing, this is where players will craft their items.
            }
             else if(i % 9 == 0 || i == 0){// Lava math stuff
                 if(lavaCount / row >= 3){
                     forge.setItem(i, Items.getFullLava(lavaCount));//Set the item to a full lava item
                 } else {
                     forge.setItem(i,Items.getEmptyLava(lavaCount));// Set the item to the empty slot
                 }
                 row--;
            } else if (i == 8 || i == 17 || i == 26 || i == 35 || i == 44 || i == 53){
                forge.setItem(i,Items.getFullExperience(0,0));
            } else {
                forge.setItem(i ,Items.getEmptySlot());
            }
        }
    }

    public Location getLocation(){
        return location;
    }

    public Inventory getInventory(){
        return forge;
    }
}
