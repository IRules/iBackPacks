package net.irules.ibackpacks.listener;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.event.SimpleListener;

@AutoRegister
public final class ChatListener extends SimpleListener<AsyncPlayerChatEvent> {


	/**
	 * The instance of this class, hidden because the only call to this class is from
	 * Foundation auto registration class.
	 */
	@Getter(value = AccessLevel.PRIVATE)
	private static final ChatListener instance = new ChatListener();

	/**
	 * Create a new listener, registered automatically
	 * We use the lowest priority to make sure we are the first to listen to this event.
	 */
	private ChatListener() {
		super(AsyncPlayerChatEvent.class, EventPriority.LOWEST, true);
	}

	/**
	 * Monitor for player chat.
	 */
	@Override
	public void execute(AsyncPlayerChatEvent event) {
		final Player player = event.getPlayer();

		if (event.getMessage().contains("test")) {
			event.setCancelled(true);
			player.sendMessage("test");
		}
	}
}
