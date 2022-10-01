package net.irules.ibackpacks.command;

import net.irules.ibackpacks.model.BackpackItem;
import net.irules.ibackpacks.model.Permissions;
import org.mineacademy.fo.Messenger;
import org.mineacademy.fo.command.SimpleSubCommand;

public class GiveBackpackCommand extends SimpleSubCommand {

	GiveBackpackCommand(String permission) {
		super("give");

		setDescription("Gives you or the specified player a backpack.");
		setPermission(permission);
		setUsage("<player>");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		if (args.length == 0) {
			BackpackItem.getInstance().give(getPlayer());
		} else {
			if (sender.hasPermission(Permissions.Commands.GIVE_OTHERS))
				BackpackItem.getInstance().give(findPlayer(args[0]));
			else
				Messenger.error(sender, "You do not have permission to give others a backpack.");
		}
	}
}
