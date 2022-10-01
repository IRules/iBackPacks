package net.irules.ibackpacks.model;

import org.mineacademy.fo.command.annotation.Permission;
import org.mineacademy.fo.command.annotation.PermissionGroup;

/**
 * Permissions used by this plugin.
 */
public final class Permissions {

	@PermissionGroup("Permissions for using commands.")
	public static final class Commands {

		@Permission("Give yourself a backpack.")
		public static final String GIVE = "ibackpacks.command.give";

		@Permission("Give others a backpack.")
		public static final String GIVE_OTHERS = "ibackpacks.command.give.others";

		@Permission("Reload the plugin.")
		public static final String RELOAD = "ibackpacks.command.reload";

		@Permission("Debug command for developers.")
		public static final String DEBUG = "ibackpacks.command.debug";

		@Permission("See all permissions.")
		public static final String PERMISSIONS = "ibackpacks.command.permissions";

		@Permission("Inspect a backpack by UUID.")
		public static final String INSPECT = "ibackpacks.command.inspect";

		@Permission("Edit a backpack you are inspecting")
		public static final String INSPECT_EDIT = "ibackpacks.command.inspect.edit";
	}

	@PermissionGroup("Permissions for using backpacks.")
	public static final class Backpacks {
		@Permission("Ability to open backpacks.")
		public static final String OPEN = "ibackpacks.open";
	}
}
