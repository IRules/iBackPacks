package net.irules.ibackpacks.menu;

import net.irules.ibackpacks.model.BackpackItem;
import net.irules.ibackpacks.settings.BackpackData;
import net.irules.ibackpacks.settings.Settings;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.model.MenuClickLocation;

import javax.annotation.Nullable;

public final class BackpackMenu extends Menu {

	private final Inventory backPackInventory;
	private final String resourcePackChar;

	public BackpackMenu(Inventory inventory) {
		backPackInventory = inventory;
		switch (Settings.BackPackSettings.BACKPACK_SIZE) {
			case 54:
				resourcePackChar = "鸷";
				break;
			case 45:
				resourcePackChar = "幔";
				break;
			case 36:
				resourcePackChar = "挚";
				break;
			case 27:
				resourcePackChar = "抬";
				break;
			case 18:
				resourcePackChar = "撼";
				break;
			default:
				resourcePackChar = "护";
				break;
		}
		setTitle("ϰϰϰϰϰϰϰϰ" + "&f" + resourcePackChar);
		setSize(Settings.BackPackSettings.BACKPACK_SIZE);
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
		return clicked == null || !clicked.getItemMeta().getPersistentDataContainer().has(BackpackItem.getInstance().getKey(), PersistentDataType.STRING);
	}
}
