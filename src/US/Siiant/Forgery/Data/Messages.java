package US.Siiant.Forgery.Data;

import US.Siiant.Forgery.DataManager.Config;

import static US.Siiant.Forgery.Forgery.getDataManager;

public class Messages {

    private static Config messages;

    public static void createConfig(){
        messages = getDataManager().getNewConfig("Messages.yml");
        createForgeMessages();
    }

    public static void createForgeMessages(){
        String section = "Forge Messages";
        messages.createSection(section);
        messages.setListValue(section, "Placed", "");
    }
}
