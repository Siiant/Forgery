package US.Siiant.Forgery.Blocks.Infuser;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Infuser {

    private static ItemStack infuser;
    private static ItemMeta infuserMeta;

    public Infuser() {

    }

    public static ItemMeta getInfuserMeta(){
        infuser = new ItemStack(Material.BREWING_STAND);
        infuserMeta = infuser.getItemMeta();
        infuserMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lInfuser"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Place this down to start infusing items!"));
        infuserMeta.setLore(lore);
        infuserMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        infuserMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        infuser.setItemMeta(infuserMeta);
        return infuserMeta;
    }

    public static ItemStack giveInfuser(){
        infuser = new ItemStack(Material.BREWING_STAND);
        infuserMeta = infuser.getItemMeta();
        infuserMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lInfuser"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Place this down to start infusing items!"));
        infuserMeta.setLore(lore);
        infuserMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        infuserMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        infuser.setItemMeta(infuserMeta);
        return infuser;
    }
}
