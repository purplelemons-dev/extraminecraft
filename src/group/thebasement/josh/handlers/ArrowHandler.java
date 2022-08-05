package group.thebasement.josh.handlers;

import group.thebasement.josh.MainPlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ArrowHandler implements Listener {
    public ArrowHandler(MainPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow arrow) {
            if (e.getEntity() instanceof LivingEntity damagedEntity) {
                if (arrow.getShooter() instanceof Player shooter) {
                    double finalHealth = damagedEntity.getHealth() - e.getDamage();
                    if (finalHealth>0) {
                        BaseComponent[] hitMessage = new ComponentBuilder(damagedEntity.getName()).color(ChatColor.YELLOW).append(" is on ").color(ChatColor.GREEN).append(String.valueOf((int) finalHealth)+"❤").color(ChatColor.RED).create();
                        shooter.spigot().sendMessage(hitMessage);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        if (e.getEntity() instanceof Arrow arrow) {
            if (arrow.getShooter() instanceof Player shooter) {
                String itemName = shooter.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
                if (itemName.equals("Explosive Bow")) {
                    arrow.setCustomName("Explosive Arrow");
                    arrow.setCustomNameVisible(false);
                } else if (itemName.equals("Terraformer")) {
                    arrow.setCustomName("Terraformer");
                    arrow.setCustomNameVisible(false);
                }
            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow arrow) {
            World world = arrow.getWorld();
            if (arrow.getName().equals("Explosive Arrow")) {
                Creeper creeper = (Creeper) world.spawnEntity(arrow.getLocation(), EntityType.CREEPER);
                creeper.setInvisible(true);
                creeper.setExplosionRadius(7);
                creeper.explode();
                arrow.remove();
            } else if (arrow.getName().equals("Terraformer")) {

            }
        }
    }
}
