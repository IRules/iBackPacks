package net.irules.ibackpacks;

import net.irules.ibackpacks.model.BackpackCrafting;
import net.irules.ibackpacks.settings.Settings;
import org.mineacademy.fo.plugin.SimplePlugin;

/**
 * Primary class of this plugin, extends {@link SimplePlugin}
 * <p>
 * We use Foundation for fast and efficient development process.
 */
public final class BackPacksMain extends SimplePlugin {

	/**
	 * Automatically perform login ONCE when the plugin starts.
	 *
	 * @see org.mineacademy.fo.plugin.SimplePlugin#onPluginStart()
	 */
	@Override
	protected void onPluginStart() {
	}

	/**
	 * Automatically perform login when the plugin starts and each time it is reloaded.
	 * We use @AutoRegister to register classes, that is why they are not loaded in here.
	 *
	 * @see org.mineacademy.fo.plugin.SimplePlugin#onReloadablesStart()
	 */
	@Override
	protected void onReloadablesStart() {
		if (Settings.BackPackSettings.BACKPACK_CRAFTABLE) {
			BackpackCrafting.getInstance().unregister();
			BackpackCrafting.getInstance().register();
		} else {
			BackpackCrafting.getInstance().unregister();
		}
	}

	/**
	 * @return the instance of this plugin
	 */
	public static BackPacksMain getInstance() {
		return (BackPacksMain) SimplePlugin.getInstance();
	}
}
