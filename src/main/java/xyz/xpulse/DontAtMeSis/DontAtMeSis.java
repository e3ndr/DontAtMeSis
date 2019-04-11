package xyz.xpulse.DontAtMeSis;

import org.bukkit.plugin.java.JavaPlugin;

public final class DontAtMeSis extends JavaPlugin {
	private static DontAtMeSis instance;
	@Override
    public void onEnable() {
		instance = this;
		Config.init();
		getServer().getPluginManager().registerEvents(new EventListener(), this);
		this.getCommand("dams").setTabCompleter(new CommandDAMS());
		this.getCommand("dams").setExecutor(new CommandDAMS());
		
	}
	@Override
    public void onDisable() {
		instance = null;
	}
	public static void log(Object obj) {
		instance.getLogger().info(String.valueOf(obj));
	}
	public static String noPerm(String perm) {
		return "You do not have \"" + perm + "\" required to do this.";
	}
	public static String version() {
		return instance.getDescription().getVersion();
	}
	public static String lastColor(String str) {
		char[] chars = str.toCharArray();
		String last = "§r";
		for (int i = 0; i != chars.length; i++) {
			char ch = chars[i];
			if (ch == '§' && i != (chars.length - 1)) {
				last = "" + ch + chars[i + 1];
			}
		}
		
		return last;
	}
	public static String transformColor(String msg) { // RIPPED FROM BUKKIT BASICS
		return msg
				.replace("&4", "§4")
				.replace("&c", "§c")
				.replace("&6", "§6")
				.replace("&e", "§e")
				.replace("&2", "§2")
				.replace("&a", "§a")
				.replace("&b", "§b")
				.replace("&3", "§3")
				.replace("&1", "§1")
				.replace("&9", "§9")
				.replace("&d", "§d")
				.replace("&5", "§5")
				.replace("&f", "§f")
				.replace("&7", "§7")
				.replace("&8", "§8")
				.replace("&0", "§0")
				.replace("&l", "§l")
				.replace("&n", "§n")
				.replace("&o", "§o")
				.replace("&k", "§k")
				.replace("&m", "§m")
				.replace("&r", "§r");
	}
	public static DontAtMeSis instance () {
		return instance;
	}
}
