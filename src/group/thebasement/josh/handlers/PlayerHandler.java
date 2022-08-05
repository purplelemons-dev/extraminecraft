package group.thebasement.josh.handlers;

import group.thebasement.josh.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class PlayerHandler implements Listener {
    public PlayerHandler(MainPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    /*@EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItem(e.getNewSlot());
        if (item != null) {
            if (item.equals(ItemManager.BouncyBall)) {
                PotionEffect jump= new PotionEffect(PotionEffectType.JUMP, 99999, 4, false, false, true);
                player.addPotionEffect(jump);
            }
        }
    }*/
}
