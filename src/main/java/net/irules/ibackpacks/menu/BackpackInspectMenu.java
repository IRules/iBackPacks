package net.irules.ibackpacks.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.model.MenuClickLocation;
import org.mineacademy.fo.settings.Lang;

import javax.annotation.Nullable;

public final class BackpackInspectMenu extends Menu {

	private final Inventory backPackInventory;

	public BackpackInspectMenu(Inventory inventory) {
		setTitle(Lang.of("Backpack.itemName") + " - &c&lInspect");
		setSize(54);
		backPackInventory = inventory;
	}

	/**
	 * @see Menu#getItemAt(int)
	 */
	@Override
	public ItemStack getItemAt(int slot) {
		//Replace items in the menu with those saved in the serialized backpack inventory.
		return backPackInventory.getItem(slot);
	}

	/**
	 * @see Menu#getInfo()
	 */
	@Override
	protected String[] getInfo() {
		return null;
	}

	/**
	 * Show this menu to the given player
	 *
	 * @param player
	 */
	public static void showTo(Player player, Inventory inventory) {
		new BackpackInspectMenu(inventory).displayTo(player);
	}

	@Override
	protected void onMenuClose(Player player, Inventory inventory) {
	}

	@Override
	protected boolean isActionAllowed(MenuClickLocation location, int slot, @Nullable ItemStack clicked, @Nullable ItemStack cursor) {
		return false;
	}
}
