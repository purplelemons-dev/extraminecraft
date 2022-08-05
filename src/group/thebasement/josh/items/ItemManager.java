package group.thebasement.josh.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemManager {
    public static ItemStack SpeedFeather;
    public static ItemStack BouncyBall;

    public static void init() {
        createSpeedFeather();
        createBouncyBall();
    }

    private static void createSpeedFeather() {
        ItemStack item = new ItemStack(Material.FEATHER,1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;

        meta.setDisplayName("§bSpeed Feather");
        List<String> lore = new ArrayList<>();
        lore.add("§7Hold for Speed V");
        meta.setLore(lore);

        AttributeModifier speedMainHand = new AttributeModifier(UUID.randomUUID(), "generic.speed",.25,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speedOffHand = new AttributeModifier(UUID.randomUUID(), "generic.speed",.25,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED,speedMainHand);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED,speedOffHand);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        SpeedFeather = item;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("speed_feather"),SpeedFeather);
        recipe.shape(
                "XXX",
                "X#X",
                "XXX");
        ItemStack speed = new ItemStack(Material.POTION);
        PotionMeta speed_meta = (PotionMeta) speed.getItemMeta();
        speed_meta.setBasePotionData(new PotionData(PotionType.SPEED,false,true));
        speed.setItemMeta(speed_meta);

        recipe.setIngredient('X', new RecipeChoice.ExactChoice(speed));
        recipe.setIngredient('#',Material.FEATHER);
        Bukkit.getServer().addRecipe(recipe);

    }

    private static void createBouncyBall() {
        ItemStack item = new ItemStack(Material.SLIME_BALL,1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;

        meta.setDisplayName("§ABouncy Ball");
        List<String> lore = new ArrayList<>();
        lore.add("§7Hold for Jump Boost V");
        meta.setLore(lore);

        item.setItemMeta(meta);
        BouncyBall = item;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("bouncy_ball"),BouncyBall);
        recipe.shape(
                "XXX",
                "X#X",
                "XXX");
        ItemStack jump = new ItemStack(Material.POTION);
        PotionMeta jump_meta = (PotionMeta) jump.getItemMeta();
        jump_meta.setBasePotionData(new PotionData(PotionType.JUMP,false,true));
        jump.setItemMeta(jump_meta);

        recipe.setIngredient('X', new RecipeChoice.ExactChoice(jump));
        recipe.setIngredient('#',Material.SLIME_BLOCK);
        Bukkit.getServer().addRecipe(recipe);
    }

}
