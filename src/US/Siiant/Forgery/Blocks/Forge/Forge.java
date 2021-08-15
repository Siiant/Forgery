package US.Siiant.Forgery.Blocks.Forge;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Forge {

    static ItemStack forge;
    static ItemMeta forgeMeta;
    String location;
    int lava;

    public Forge(String loc, int lava){
        this.lava = lava;
        location = loc;
    }

    public Forge(Location location){

    }


    public void setForge(){
        forge = new ItemStack(Material.ANVIL);
        forgeMeta = forge.getItemMeta();
        forgeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lForge"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Place this down to start forging improved tools!"));
        forgeMeta.setLore(lore);
        forgeMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        forgeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        forge.setItemMeta(forgeMeta);
    }

    public static ItemMeta getItemMeta(){
        forge = new ItemStack(Material.ANVIL);
        forgeMeta = forge.getItemMeta();
        forgeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lForge"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Place this down to start forging improved tools!"));
        forgeMeta.setLore(lore);
        forgeMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        forgeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        forge.setItemMeta(forgeMeta);
        return forgeMeta;
    }

    public void setLava(int count){
        lava = count;
    }

    public int getLava(){
        return lava;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }

    public ItemStack getForge(){
        return forge;
    }

    public static ItemStack giveForge(){
        forge = new ItemStack(Material.ANVIL);
        forgeMeta = forge.getItemMeta();
        forgeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lForge"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Place this down to start forging improved tools!"));
        forgeMeta.setLore(lore);
        forgeMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        forgeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        forge.setItemMeta(forgeMeta);
        return forge;
    }
}
