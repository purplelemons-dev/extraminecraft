package group.thebasement.josh;

import group.thebasement.josh.commands.PluginCommands;
import group.thebasement.josh.handlers.ArrowHandler;
import group.thebasement.josh.handlers.PlayerHandler;
import group.thebasement.josh.handlers.Tick;
import group.thebasement.josh.items.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().broadcastMessage("§3Josh's plugin enabled!");

        new ArrowHandler(this);
        new PlayerHandler(this);

        Tick loop = new Tick(this);
        loop.runTaskTimer(this,0,1);

        getCommand("disable").setExecutor(new PluginCommands());
        getCommand("test").setExecutor(new PluginCommands());

        ItemManager.init();

    }

    @Override
    public void onDisable() {
        System.out.println("Plugin Stopped!");
    }


}
