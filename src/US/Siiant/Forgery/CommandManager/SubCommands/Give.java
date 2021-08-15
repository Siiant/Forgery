package US.Siiant.Forgery.CommandManager.SubCommands;

import US.Siiant.Forgery.Blocks.Forge.Forge;
import US.Siiant.Forgery.Blocks.Infuser.Infuser;
import US.Siiant.Forgery.CommandManager.SubCommand;
import org.bukkit.entity.Player;

public class Give extends SubCommand {
    @Override
    public String getName() {
        return "give";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return null;
    }

    @Override
    public void perform(Player player, String[] args) {
        if(args[2].equalsIgnoreCase("forge")){
            player.getInventory().addItem(Forge.giveForge());
        } else if (args[2].equalsIgnoreCase("infuser")){
            player.getInventory().addItem(Infuser.giveInfuser());
        }
    }
}
