package net.irules.ibackpacks.model;

import lombok.Getter;
import net.irules.ibackpacks.BackPacksMain;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import org.mineacademy.fo.remain.CompMaterial;

/**
 * This class handles the crafting recipe of the backpack. Recipe:
 * {Leather} | {IRON_NUGGET} | {Leather}
 * {STRING}  |    {CHEST}    | {STRING}
 * {Leather} |   {Leather}   | {Leather}
 */

public class BackpackCrafting {
	@Getter
	public static BackpackCrafting instance = new BackpackCrafting();
	private ItemStack backpack = BackpackItem.getInstance().getItem();
	private ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(BackPacksMain.getInstance(), "backpack"), backpack);

	private BackpackCrafting() {
		recipe.shape("LNL", "SCS", "LLL");
		recipe.setIngredient('L', CompMaterial.LEATHER.getMaterial());
		recipe.setIngredient('N', CompMaterial.IRON_NUGGET.getMaterial());
		recipe.setIngredient('C', CompMaterial.CHEST.getMaterial());
		recipe.setIngredient('S', CompMaterial.STRING.getMaterial());
	}

	public void register() {
		Bukkit.addRecipe(recipe);
	}

	public void unregister() {
		Bukkit.removeRecipe(recipe.getKey());
	}
}
