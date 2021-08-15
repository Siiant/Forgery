package US.Siiant.Forgery;


import US.Siiant.Forgery.CommandManager.CommandManager;
import US.Siiant.Forgery.Data.CreateConfig;
import US.Siiant.Forgery.Data.GUIItems;
import US.Siiant.Forgery.DataManager.DataManager;
import US.Siiant.Forgery.Listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Forgery extends JavaPlugin {

    public static DataManager manager;
    public static Forgery plugin;

    @Override
    public void onEnable() {
        plugin = this; //
        manager = new DataManager(this);// Create the data manager, there should only be one instance of this.
        //if(!getDataFolder().exists()){//Create all the configs if the folder doesn't exist
            CreateConfig.createConfigFile();
            GUIItems.createConfig();
        getCommand("Forgery").setExecutor(new CommandManager());
        getServer().getPluginManager().registerEvents(new ForgeClick(), this); // Listener for when a forge is clicked
        getServer().getPluginManager().registerEvents(new ForgeDestroy(), this); // Listener for when a forge is destroyed.
        getServer().getPluginManager().registerEvents(new ForgeInventoryClick(), this);// Listener for when a player is in a forge's GUI
        getServer().getPluginManager().registerEvents(new ForgeInventoryClose(), this);// Listener for when a player closes out of a forge's GUI
        getServer().getPluginManager().registerEvents(new ForgePlace(), this); // Listener for when a player places a forge.
    }

    @Override
    public void onDisable() {
    }

    public static Forgery getPlugin(){
        return plugin;
    }

    public static DataManager getDataManager(){return manager;} // Make the datamanager publicly accessible in all the classes
}
