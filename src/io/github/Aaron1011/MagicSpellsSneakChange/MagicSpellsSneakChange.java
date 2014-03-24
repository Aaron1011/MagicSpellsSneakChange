package io.github.Aaron1011.MagicSpellsSneakChange;

import org.bukkit.plugin.java.JavaPlugin;

public class MagicSpellsSneakChange extends JavaPlugin {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new SpellCastListener(this), this);
	}
}
