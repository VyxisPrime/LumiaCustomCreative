package flakes.lumia.src.noxpbottle.Listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerEvent;

import flakes.lumia.src.noxpbottle.Main;

public class EntityListener implements Listener {

	@SuppressWarnings("unused")
	private Main plugin;

	public EntityListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void xpBottle(ProjectileLaunchEvent event, PlayerEvent e) {
		Player player = e.getPlayer();

		if (player.getGameMode() == GameMode.CREATIVE) {
			// Canceling Bottle 'o Experience on hold or use.
			if (player.hasPermission("Lumia.xpbottle.cancel")) {
				if (event.getEntityType() == EntityType.THROWN_EXP_BOTTLE) {
					event.setCancelled(true);
				}
				// Canceling on Experience Orb hit player
				if (event.getEntityType() == EntityType.EXPERIENCE_ORB) {
					event.isCancelled();
				}
			}
			// Canceling Minecart with Tnt on hold or use
			if (player.hasPermission("Lumia.tntcart.cancel")) {
				if (event.getEntityType() == EntityType.MINECART_TNT) {
					event.isCancelled();
				}
			}
		}
	}
}
