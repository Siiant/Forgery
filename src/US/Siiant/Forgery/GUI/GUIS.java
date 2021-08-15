package US.Siiant.Forgery.GUI;

import US.Siiant.Forgery.GUI.Forge.ForgeGUI;
import US.Siiant.Forgery.GUI.Infuser.InfuserGUI;
import US.Siiant.Forgery.Listeners.ForgeClick;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Objects;

public class GUIS {

    public static boolean myGUIS(InventoryCloseEvent e){
        if(ForgeClick.getForge() == null && ForgeClick.getInfuser() == null ){
                return false;
        } if(ForgeClick.getForge() != null && e.getView().getTopInventory() == ForgeClick.getForge().getInventory()){
            return true;
        }
        if(ForgeClick.getInfuser() != null && e.getView().getTopInventory() == ForgeClick.getInfuser().getInventory()){
            return true;
        }
        return false;
    }

    public static Inventory getType(InventoryCloseEvent e){
        if(ForgeClick.getForge() != null && e.getView().getTopInventory() == ForgeClick.getForge().getInventory()){
            return new ForgeGUI(ForgeClick.getForge().getLocation()).getInventory();
        } else {
            return new InfuserGUI(ForgeClick.getInfuser().getLocation()).getInventory();
        }
    }


    public static boolean returnItems(InventoryCloseEvent e, Inventory inventory){
        if (!Arrays.equals(e.getView().getTopInventory().getContents(), inventory.getContents())) {
            for (int i = 0; i < inventory.getSize(); i++) {
                if (!Objects.equals(e.getView().getTopInventory().getItem(i), inventory.getItem(i))) {
                    ItemStack tempItem = new ItemStack((Objects.requireNonNull(e.getView().getTopInventory().getItem(i))));
                    if(tempItem.hasItemMeta()){
                        tempItem.setItemMeta(e.getView().getTopInventory().getItem(i).getItemMeta());
                    }
                    tempItem.setData(Objects.requireNonNull(e.getView().getTopInventory().getItem(i)).getData());
                    tempItem.setAmount(Objects.requireNonNull(e.getView().getTopInventory().getItem(i)).getAmount());
                    e.getPlayer().getInventory().addItem(tempItem);
                    ((Player) e.getPlayer()).updateInventory();
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
