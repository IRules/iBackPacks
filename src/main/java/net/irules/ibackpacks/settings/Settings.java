package net.irules.ibackpacks.settings;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import org.mineacademy.fo.settings.Lang;
import org.mineacademy.fo.settings.SimpleSettings;
import org.mineacademy.fo.settings.YamlStaticConfig;

/**
 * Primary settings class for iBackpacks, extends {@link SimpleSettings}
 */

@SuppressWarnings("unused")
public final class Settings extends SimpleSettings {

	/**
	 * This has to match the version in the config. Else we risk corruption.
	 * @see org.mineacademy.fo.settings.SimpleSettings#getConfigVersion()
	 * @return the config version
	 */
	@Override
	protected int getConfigVersion() {
		return 1;
	}
	@Getter
	public static class BackPackSettings {

		public static Integer BACKPACK_SIZE;
		public static Boolean BACKPACK_CRAFTABLE;

		/*
		 * Automatically called method when we load settings.yml to load values in this subclass
		 */
		private static void init() {
			setPathPrefix("Backpacks");

			BACKPACK_SIZE = getInteger("size", 54);
			BACKPACK_CRAFTABLE = getBoolean("craftable");
		}
	}

	/*
	 * Automatically called method when we load settings.yml to load values in this class.
	 *
	 * See above for usage.
	 */
	private static void init() {
		setPathPrefix(null);
	}
}
