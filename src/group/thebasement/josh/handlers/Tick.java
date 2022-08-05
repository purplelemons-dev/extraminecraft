package group.thebasement.josh.handlers;

import group.thebasement.josh.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Tick extends BukkitRunnable {

    private final JavaPlugin plugin;

    public Tick(JavaPlugin plugin) {
        this.plugin=plugin;
    }

    @Override
    public void run() {
        for (Player player :
                plugin.getServer().getOnlinePlayers()) {
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.equals(ItemManager.BouncyBall)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,4,4,false,false,true));
            } /*else if (item.getType().equals(Material.POTION)) {

                //player.sendMessage(item.getItemMeta().toString());
            }*/
        }
    }

}
