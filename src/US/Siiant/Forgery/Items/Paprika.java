package US.Siiant.Forgery.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Paprika {

    private static ItemStack paprika;
    private static ItemMeta itemMeta;

    public static ItemStack getItemStack(){
        paprika = new ItemStack(Material.REDSTONE);
        List<String> lore = new ArrayList<>(); // Create an empty array list for the lore
        lore.add(" "); // For now we're going to make the lore blank
        itemMeta = paprika.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lPaprika"));
        itemMeta.setLore(lore);
        paprika.setItemMeta(itemMeta);
        return paprika;
    }
}
