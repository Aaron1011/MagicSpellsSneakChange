package io.github.Aaron1011.MagicSpellsSneakChange;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.nisovin.magicspells.MagicSpells;
import com.nisovin.magicspells.events.SpellCastEvent;

public class SpellCastListener implements Listener {
	private JavaPlugin plugin;
	
	public SpellCastListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onSpellCast(final SpellCastEvent e) {
		if (e.getSpell().getName().equalsIgnoreCase("fireball")) {
			if (e.getCaster().isSneaking())  {
				e.setCancelled(true);
				Bukkit.getScheduler().runTask(plugin, new Runnable() {
					@Override
					public void run() {
						MagicSpells.getSpellByInternalName("lightning").cast(e.getCaster());
					}
				});
			}
		}
	}
}
