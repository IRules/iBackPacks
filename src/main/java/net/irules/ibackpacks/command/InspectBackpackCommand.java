package net.irules.ibackpacks.command;

import net.irules.ibackpacks.menu.BackpackInspectMenu;
import net.irules.ibackpacks.menu.BackpackMenu;
import net.irules.ibackpacks.model.Permissions;
import net.irules.ibackpacks.settings.BackpackData;
import org.mineacademy.fo.Messenger;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public class InspectBackpackCommand extends SimpleSubCommand {

	InspectBackpackCommand(String permission) {
		super("inspect");

		setDescription("Inspect a backpack based on its UUID.");
		setPermission(permission);
		setUsage("<UUID>");
	}
	@Override
	protected void onCommand() {
		checkConsole();
		if (args.length == 0) {
			Messenger.error(sender, "You must specify a backpack UUID.");
		} else {
			if (sender.hasPermission(Permissions.Commands.INSPECT_EDIT)) {
				try {
					BackpackMenu.showTo(getPlayer(), BackpackData.from(args[0]).getBackPackInventory().getInventory());
				} catch (Exception e) {
					Messenger.error(sender, "Invalid backpack UUID.");
				}
			} else {
				try {
					BackpackInspectMenu.showTo(getPlayer(), BackpackData.from(args[0]).getBackPackInventory().getInventory());
				} catch (Exception e) {
					Messenger.error(sender, "Invalid backpack UUID.");
				}
			}
		}
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
