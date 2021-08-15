package US.Siiant.Forgery.GUI.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {

    static ItemStack fullLava;
    static org.bukkit.inventory.ItemStack emptyLava;
    static ItemStack empty;
    static ItemStack experience;

    public static ItemStack getEmptySlot(){
        empty = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        List<String> lore = new ArrayList<>(); // Create an empty array list for the lore
        lore.add(" "); // For now we're going to make the lore blank
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName(" ");
        emptyMeta.setLore(lore);
        empty.setItemMeta(emptyMeta);
        return empty;
    }

    public static ItemStack getFullExperience(int level, int exp){
        experience = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        return experience;
    }

    public static ItemStack getFullLava(int lavaCount){
        fullLava = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta fLavaMeta = fullLava.getItemMeta();
        fLavaMeta.setDisplayName(lavaCount + " Lava Buckets");
        fullLava.setItemMeta(fLavaMeta);
        return fullLava;
    }


    public static ItemStack getEmptyLava(int lavaCount){
        emptyLava = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        List<String> lore = new ArrayList<>(); // Create an empty array list for the lore
        lore.add(" "); // For now we're going to make the lore blank
        ItemMeta emptyLavaMeta = emptyLava.getItemMeta();
        emptyLavaMeta.setDisplayName(lavaCount + " Lava Buckets");
        emptyLavaMeta.setLore(lore);
        emptyLava.setItemMeta(emptyLavaMeta);
        return emptyLava;
    }

    public static boolean getItems(ItemStack item){
        return item.equals(fullLava) || item.equals(empty) || item.equals(emptyLava) || item.equals(experience);
    }
}
