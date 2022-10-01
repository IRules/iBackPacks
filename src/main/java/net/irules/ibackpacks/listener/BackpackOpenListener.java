package net.irules.ibackpacks.listener;

import lombok.AccessLevel;
import lombok.Getter;
import net.irules.ibackpacks.menu.BackpackMenu;
import net.irules.ibackpacks.model.BackpackItem;
import net.irules.ibackpacks.model.Permissions;
import net.irules.ibackpacks.settings.BackpackData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.event.SimpleListener;
import org.mineacademy.fo.remain.CompMaterial;

/**
 * We monitor for SHIFTING + RIGHT-CLICKING to open the backpack
 */

@AutoRegister
public final class BackpackOpenListener extends SimpleListener<PlayerInteractEvent> {


	/**
	 * The instance of this class, hidden because the only call to this class is from
	 * Foundation auto registration class.
	 */
	@Getter(value = AccessLevel.PRIVATE)
	private static final BackpackOpenListener instance = new BackpackOpenListener();

	/**
	 * Create a new listener, registered automatically
	 * We use monitor priority to make sure we are the last to listen to this event, and we can not interfere with it.
	 */
	private BackpackOpenListener() {
		super(PlayerInteractEvent.class, EventPriority.MONITOR, true);
	}

	/**
	 * Monitor for player right-clicking with a backpack in his off-hand.
	 */
	@Override
	public void execute(PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		// See how complicated it is to check for everything we need? Too many checks for my liking, but whatever.
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK && player.isSneaking()
				&& event.getHand() == EquipmentSlot.OFF_HAND
				&& event.getItem() != null
				&& event.getItem().getType() == CompMaterial.FEATHER.getMaterial()
				&& player.hasPermission(Permissions.Backpacks.OPEN)
				&& player.getInventory().getItemInMainHand().getType() == CompMaterial.AIR.getMaterial()) {
			PersistentDataContainer container = player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer();
			if (container.has(BackpackItem.getInstance().getKey(), PersistentDataType.STRING)) {
				BackpackMenu.showTo(player, BackpackData.from(container.get(BackpackItem.getInstance().getKey(), PersistentDataType.STRING)).getBackPackInventory().getInventory());
			}
		}
	}
}
