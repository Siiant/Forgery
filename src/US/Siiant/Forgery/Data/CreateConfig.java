package US.Siiant.Forgery.Data;

import US.Siiant.Forgery.DataManager.Config;

import static US.Siiant.Forgery.Forgery.getDataManager;

public class CreateConfig {

    private static Config config;

    public static void createConfigFile(){
        config = getDataManager().getNewConfig("Config.yml");
        config.saveConfig();
    }
}
