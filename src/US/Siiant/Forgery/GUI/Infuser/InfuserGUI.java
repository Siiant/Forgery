package US.Siiant.Forgery.GUI.Infuser;

import US.Siiant.Forgery.Forgery;
import US.Siiant.Forgery.Data.JSONData;
import US.Siiant.Forgery.GUI.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class InfuserGUI {

    public Inventory infuser;
    public Location location;
    public boolean spin;
    public int count;
    public int i = 24;
    public int a;

    public InfuserGUI(Location location){
        infuser = Bukkit.createInventory(null, 27 , ChatColor.translateAlternateColorCodes('&', "&6&lInfuser"));
        JSONData jsonData = new JSONData("Infusers");
        this.location = location;
        int lavaCount = jsonData.getLava(location);
        int row = 6;
        for(int i = 0; i <= 26; i++){
            if(i == 2 || i == 6){
                // Do nothing, this is where the players will infuse their items.
            }  else if (i == 0 || i == 8 || i == 9 || i == 17 || i == 18 || i == 26) {
                if(lavaCount / row >= 3){
                    infuser.setItem(i, Items.getFullLava(lavaCount));//Set the item to a full lava item
                } else {
                    infuser.setItem(i,Items.getEmptyLava(lavaCount));// Set the item to the empty slot
                }
                row--;
            } else {
                infuser.setItem(i,Items.getEmptySlot());
            }
        }
    }

    public void spinGUI(int amount){
        ItemStack full = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        ItemMeta fullMeta = full.getItemMeta();
        fullMeta.setDisplayName("Infusing items");
        fullMeta.setLore(lore);
        full.setItemMeta(fullMeta);
        spin = true;
        a = amount;
        for(int c = 24; c > 19; c--){
            full.setAmount(amount);
            infuser.setItem(c,full);
        }
        a--;
                //System.out.println(count + " , " + a);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(a !=0){
                            full.setAmount(a);
                            infuser.setItem(i,full);
                            i--;
                            if (i == 19){
                                i = 24;
                                a--;
                            }
                        } else {
                            cancel();
                        }
                        //System.out.println(count + " , " + a);
                    }
                }.runTaskTimer(Forgery.getPlugin(), 10,10);// Wait half a second and then every half a second run the code
        spin = false;
    }

    public Location getLocation(){
        return location;
    }

    public boolean getSpinning(){
        return spin;
    }

    public Inventory getInventory(){
        return infuser;
    }


}
