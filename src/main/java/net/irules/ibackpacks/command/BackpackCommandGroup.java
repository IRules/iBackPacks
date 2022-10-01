package net.irules.ibackpacks.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.irules.ibackpacks.model.Permissions;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.DebugCommand;
import org.mineacademy.fo.command.PermsCommand;
import org.mineacademy.fo.command.ReloadCommand;
import org.mineacademy.fo.command.SimpleCommandGroup;

/*
 * Main command class. The command label can be changed in the settings.
 */
@AutoRegister
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BackpackCommandGroup extends SimpleCommandGroup {

	@Getter
	private final static SimpleCommandGroup instance = new BackpackCommandGroup();

	@Override
	protected void registerSubcommands() {
		// Registering all commands under /bp
		registerSubcommand(new PermsCommand(Permissions.class, Permissions.Commands.PERMISSIONS));
		registerSubcommand(new DebugCommand(Permissions.Commands.DEBUG));
		registerSubcommand(new ReloadCommand(Permissions.Commands.RELOAD));
		registerSubcommand(new GiveBackpackCommand(Permissions.Commands.GIVE));
		registerSubcommand(new InspectBackpackCommand(Permissions.Commands.INSPECT));
	}

	/*
	 * We won't need the credits.
	 */
	@Override
	protected String getCredits() {
		return null;
	}
}
