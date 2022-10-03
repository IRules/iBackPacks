package net.irules.ibackpacks.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.irules.ibackpacks.BackPacksMain;
import net.irules.ibackpacks.settings.Settings;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.menu.tool.Tool;
import org.mineacademy.fo.model.Replacer;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.Lang;

import java.util.UUID;


/*
 * The BackPack Item. This is auto registered with Foundation.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BackpackItem extends Tool {

	@Getter
	private static final BackpackItem instance = new BackpackItem();

	@Getter
	private final NamespacedKey key = new NamespacedKey(BackPacksMain.getInstance(), "backpack-uuid");

	@Override
	public ItemStack getItem() {
		String backpackItemUUID = UUID.randomUUID().toString();
		String lore /* :( */ = Replacer.replaceArray(Lang.of("Backpack.itemLore"), "{uuid}", backpackItemUUID);
		ItemStack backpackItem = ItemCreator.of(
						CompMaterial.CHEST,
						Lang.of("Backpack.itemName"), lore)
				.make();
		ItemMeta backpackItemMeta = backpackItem.getItemMeta();
		assert backpackItemMeta != null;
		backpackItemMeta.setCustomModelData(Settings.BackPackSettings.BACKPACK_MODELDATA);

		/*
		 * We use the PersistentDataContainer to store the UUID of the backpack item.
		 */
		backpackItemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, backpackItemUUID);
		backpackItem.setItemMeta(backpackItemMeta);
		return backpackItem;
	}
}
