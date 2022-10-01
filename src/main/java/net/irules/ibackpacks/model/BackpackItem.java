package net.irules.ibackpacks.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.irules.ibackpacks.BackPacksMain;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.menu.tool.Tool;
import org.mineacademy.fo.remain.CompMaterial;

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
		ItemStack backpackItem = ItemCreator.of(
						CompMaterial.FEATHER,
						"&e&lBackpack",
						"",
						"&7Must be in your &c&nOFF-HAND&7 and your main hand must be empty.",
						"&7To open your backpack perform the following actions:",
						"&c&nSHIFT&r&7 + &c&nRIGHT-CLICK&r&7 on a block.",
						"",
						"&7UUID: &c&n" + backpackItemUUID)
				.make();
		ItemMeta backpackItemMeta = backpackItem.getItemMeta();
		assert backpackItemMeta != null;
//		backpackItem.getItemMeta().setCustomModelData(1);

		/*
		 * We use the PersistentDataContainer to store the UUID of the backpack item.
		 */
		backpackItemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, backpackItemUUID);
		backpackItem.setItemMeta(backpackItemMeta);
		return backpackItem;
	}
}
