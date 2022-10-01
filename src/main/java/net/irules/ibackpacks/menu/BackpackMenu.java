package net.irules.ibackpacks.menu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import net.irules.ibackpacks.model.BackpackItem;
import net.irules.ibackpacks.settings.BackpackData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.model.MenuClickLocation;

import javax.annotation.Nullable;
public final class BackpackMenu extends Menu {

	private final Inventory backPackInventory;

	public BackpackMenu(Inventory inventory) {
		setTitle("&e&lBackpack");
		setSize(9 * 6);
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
		new BackpackMenu(inventory).displayTo(player);
	}

	@Override
	protected void onMenuClose(Player player, Inventory inventory) {
		BackpackData.from(player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(BackpackItem.getInstance().getKey(), PersistentDataType.STRING)).setBackPackInventory(inventory);

	}

	@Override
	protected boolean isActionAllowed(MenuClickLocation location, int slot, @Nullable ItemStack clicked, @Nullable ItemStack cursor) {
		return true;
	}
}
