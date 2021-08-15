package US.Siiant.Forgery.Data;

import US.Siiant.Forgery.DataManager.JSONManager;
import com.google.gson.JsonObject;
import org.bukkit.Location;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JSONData {

    File playersFile;
    File forgesFile;
    JSONManager jsonManager;
    File file;
    Plugin pl;

    public JSONData(String file){
        this.jsonManager = new JSONManager(file);
        this.file = jsonManager.getFile();
    }

    public void logBlock(BlockPlaceEvent e){
        Location location = e.getBlock().getLocation();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Lava" , 0);
        jsonManager.save((int) location.getX() + "," + location.getBlockY() + "," + location.getBlockZ(), jsonObject);
    }

    public void logPlayer(BlockPlaceEvent e){
        JsonObject player = new JsonObject();
        JsonObject pData = new JsonObject();
        pData.addProperty("Exp", "0");
        pData.addProperty("Success", "0");
        pData.addProperty("Fail", "0");
        player.add(e.getPlayer().getUniqueId().toString(), pData);
        jsonManager.save(player);
    }

    public void remove(Location loc){
        jsonManager.remove((int) loc.getX() + "," + loc.getBlockY() + "," + loc.getBlockZ());
    }


    public void addLava(Location location, int lavaAmount){
        JsonObject fData = new JsonObject();
        fData.addProperty("Lava", lavaAmount);
        jsonManager.save((int) location.getX() + "," + location.getBlockY() + "," + location.getBlockZ(), fData);
    }


    public int getLava(Location loc){
        try {
            FileReader reader = new FileReader(file); // Parse the json file to a file reader
            Map<?, ?> map = JSONManager.GSON.fromJson(reader, Map.class); // Convert the reader into a Map
            String string = map.get((int) loc.getX() + "," + loc.getBlockY() + "," + loc.getBlockZ()).toString(); // Get the amount of lava at that location
            return (int) Double.parseDouble(string.replace("Lava=", "").replace("{", "").replace("}", ""));// Return the lava count.
        } catch(Exception e){
            e.printStackTrace();
        }
        return 22;
    }

    public static boolean forgeExists(Location loc){
        File file = new JSONManager("Forges").getFile();// Get the Json file
        try {
            FileReader reader = new FileReader(file); // Parse the json file to a file reader
            Map<?,?> map = JSONManager.GSON.fromJson(reader, Map.class); // Convert the reader into a Map
            reader.close();// Close the reader
            if (map.containsKey((int)loc.getX() + "," + loc.getBlockY() + "," + loc.getBlockZ())) {//Check the location of the forge in the JSON file
                return true;// Return true if the forge exists
            } else {
                return false; // Return false if the forge doesn't exist.
            }
        } catch (IOException e){
            e.printStackTrace(); // Return the error if there is an error
        }
        return false; // Return false after giving the error to console
    }

    public static boolean infuserExists(Location loc){
        File file = new JSONManager("Infusers").getFile();// Get the Json file
        try {
            FileReader reader = new FileReader(file); // Parse the json file to a file reader
            Map<?,?> map = JSONManager.GSON.fromJson(reader, Map.class); // Convert the reader into a Map
            reader.close();// Close the reader
            if (map.containsKey((int)loc.getX() + "," + loc.getBlockY() + "," + loc.getBlockZ())) {//Check the location of the forge in the JSON file
                return true;// Return true if the forge exists
            } else {
                return false; // Return false if the forge doesn't exist.
            }
        } catch (IOException e){
            e.printStackTrace(); // Return the error if there is an error
        }
        return false; // Return false after giving the error to console
    }
}
