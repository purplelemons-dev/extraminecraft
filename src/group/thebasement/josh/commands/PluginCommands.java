package group.thebasement.josh.commands;

import group.thebasement.josh.items.ItemManager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PluginCommands implements CommandExecutor {
    @Override
    // Player-only Commands
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            BaseComponent[] error = new ComponentBuilder("Only players may execute this command").color(ChatColor.RED).create();
            sender.spigot().sendMessage(error);
            return false;
        }

        if (command.getName().equalsIgnoreCase("disable")) {
            Server server = player.getServer();
            server.getPluginManager().disablePlugins();
            server.broadcastMessage("§cGoodbye...");
            return true;
        }

        if (command.getName().equalsIgnoreCase("test")) {
            if (args[0].equals("feather")) {
                player.getInventory().addItem(ItemManager.SpeedFeather);
            } else if (args[0].equals("ball")) {
                player.getInventory().addItem(ItemManager.BouncyBall);
            } else if (args[0].equals("pot")) {
                player.getInventory().addItem(new ItemStack(Material.getMaterial("strong_swiftness")));
            }
        }

        return true;
    }
}
