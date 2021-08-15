package US.Siiant.Forgery.Data;

import US.Siiant.Forgery.DataManager.Config;

import static US.Siiant.Forgery.Forgery.getDataManager;

public class GUIItems {

    private static Config items;

    public static void createConfig(){
        items = getDataManager().getNewConfig("ForgeItems.yml");
        createForgeItems();
        items.saveConfig();
    }

    public static void createForgeItems(){
        //All place holders $lava, $lavamax, $expneeded, $level, $levelmax, $exp, $expmax
        String section = "Full Lava";
        items.createSection(section);
        //Full lava slot block
        items.setListValue(section, "Item", "RED_STAINED_GLASS_PANE");
        items.setListValue(section, "Display Name", "$lava Lava Buckets");
        items.setListValue(section, "Lore", "$lava Buckets out of $lavamax");
        //Empty lava slot block
        section = "Empty Lava";
        items.setListValue(section, "Item", "GREY_STAINED_GLASS_PANE");
        items.setListValue(section, "Display Name", "$lava Lava Buckets");
        items.setListValue(section, "Lore", "$lava Buckets out of $lavamax");
        //Empty slot block
        section = "Empty";
        items.setListValue(section, "Item", "BLACK_STAINED_GLASS_PANE");
        items.setListValue(section, "Display Name", "");
        items.setListValue(section, "Lore", "");
        //Empty EXP block
        section = "Empty Exp";
        items.setListValue(section, "Item", "LIME_STAINED_GLASS_PANE");
        items.setListValue(section, "Display Name", "$expneeded to get to the next level!");
        items.setListValue(section, "Lore", "");
        //Full EXP Block
        section = "Full EXP";
        items.setListValue(section, "Item", "GREEN_STAINED_GLASS_PANE");
        items.setListValue(section, "Display Name", "Level $level out of $levelmax");
        items.setListValue(section, "Lore", "$exp/$expmax");

    }
}
