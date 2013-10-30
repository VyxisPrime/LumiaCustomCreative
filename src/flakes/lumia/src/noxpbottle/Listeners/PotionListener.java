package flakes.lumia.src.noxpbottle.Listeners;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import flakes.lumia.src.noxpbottle.Main;

public class PotionListener implements Listener {

	private static Logger logger = Logger.getLogger("Minecraft");
	@SuppressWarnings("unused")
	private Main plugin;

	public PotionListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void PlayerItemConsume(PlayerItemConsumeEvent e) {
		Player player = e.getPlayer();
		if (player.hasPermission("lumia.potions.all")) {
			if (player.getGameMode() == GameMode.CREATIVE) {
				if (e.getItem().getType() == Material.POTION) {
					if (e.getItem().getDurability() != 0) { // Water Bottles is
															// throw Exception.

						Potion potion = Potion.fromItemStack(e.getItem());
						if (potion.getType() == PotionType.INVISIBILITY) {

							if (player.hasPermission("lumia.potions.invisible")) {
								player.sendMessage(ChatColor.RED
										+ e.getPlayer().getName()
										+ " You may not use that Potion!");
								e.setCancelled(true);

								// Logging

								logger.info(player.getName()
										+ " tried to use the Invisibility Potion!");

							}
						}
					}
					if (e.getItem().getDurability() != 0) { // Water Bottles is
															// throw Exception.

						Potion potion = Potion.fromItemStack(e.getItem());
						if (potion.getType() == PotionType.FIRE_RESISTANCE) {

							if (player
									.hasPermission("lumia.potions.fireresist")) {
								player.sendMessage(ChatColor.RED
										+ e.getPlayer().getName()
										+ " You may not use that Potion!");
								e.setCancelled(true);

								// Logging

								logger.info(e.getPlayer().getName()
										+ " tried to use the Fire Resistance Potion!");

							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	@SuppressWarnings("deprecation")
	public void onDispense(BlockDispenseEvent event, PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if (player.hasPermission("lumia.potions.all")) {
			if (player.getGameMode() == GameMode.CREATIVE) {
				if (event.getItem().getType() == Material.POTION) {
					if (event.getItem().getDurability() != 0) { // Water Bottles
																// is
																// throw
																// Exception.

						Potion potion = Potion.fromItemStack(event.getItem());
						if (potion.getType() == PotionType.INVISIBILITY
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the InvisibilityPotion.");

						}
						if (potion.getType() == PotionType.FIRE_RESISTANCE
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the Fire Resist Potion.");

						}
						if (potion.getType() == PotionType.INSTANT_DAMAGE
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the Instant Damage Potion.");

						}
						if (potion.getType() == PotionType.INSTANT_HEAL
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the Instant Healing Potion.");

						}
						if (potion.getType() == PotionType.NIGHT_VISION
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the Night Vision Potion.");

						}
						if (potion.getType() == PotionType.POISON
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the Poison Potion.");

						}
						if (potion.getType() == PotionType.REGEN
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the Regen Potion.");

						}
						if (potion.getType() == PotionType.SLOWNESS
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the Slowness Potion.");

						}
						if (potion.getType() == PotionType.SPEED
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the Swiftness Potion.");

						}
						if (potion.getType() == PotionType.STRENGTH
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the Strength Potion.");

						}if (potion.getType() == PotionType.WEAKNESS
								&& potion.isSplash()) {
							// hold Entity. not Splash
							Entity sp = event
									.getBlock()
									.getWorld()
									.dropItem(event.getBlock().getLocation(),
											event.getItem());
							sp.setVelocity(event.getVelocity());
							Inventory inv = ((Dispenser) event.getBlock()
									.getState()).getInventory();
							int fi = inv.first(event.getItem());
							inv.setItem(fi, new ItemStack(0));

							event.setCancelled(true);

							// Logging

							Location loc = event.getBlock().getLocation();
							logger.info("x:"
									+ loc.getBlockX()
									+ " y:"
									+ loc.getBlockY()
									+ " z:"
									+ loc.getBlockZ()
									+ " Dispenser was trying to throw the Weakness Potion.");

						}
					}
				}
			}
		}
	}

	@EventHandler
	public void hitSplashPotion(PotionSplashEvent event, PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("lumia.potions.all")) {
			if (p.getGameMode() == GameMode.CREATIVE) {
				if (Potion.fromItemStack(event.getEntity().getItem()) == null) {
					return;
				}

				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.INVISIBILITY) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Invisibility Splash Potion.");
						}
					}
				}
				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.FIRE_RESISTANCE) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Fire Resist Splash Potion.");
						}
					}
				}
				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.INSTANT_DAMAGE) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Instant Damage Splash Potion.");
						}
					}
				}
				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.INSTANT_HEAL) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Instant Heal Splash Potion.");
						}
					}
				}
				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.NIGHT_VISION) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Night Vision Splash Potion.");
						}
					}
				}
				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.POISON) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Poison Splash Potion.");
						}
					}
				}
				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.REGEN) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Regen Splash Potion.");
						}
					}
				}
				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.SLOWNESS) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Slowness Splash Potion.");
						}
					}
				}
				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.SPEED) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Swiftness Splash Potion.");
						}
					}
				}
				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.STRENGTH) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Strength Splash Potion.");
						}
					}
				}
				if (Potion.fromItemStack(event.getEntity().getItem()).getType() == PotionType.WEAKNESS) {
					if (event.getEntity().getShooter() instanceof Player) {
						Player player = (Player) event.getEntity().getShooter();
						if (player.hasPermission("Lumia.Potions.all")
								|| player.isOp()) {
							return;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You may not use this SplashPotion");
							event.setCancelled(true);

							event.getEntity()
									.getLocation()
									.getWorld()
									.dropItem(event.getEntity().getLocation(),
											event.getPotion().getItem());

							// Logging
							logger.info(player.getName()
									+ " tried to throw an Weakness Splash Potion.");
						}
					}
				}
			}
		}
	}
}
