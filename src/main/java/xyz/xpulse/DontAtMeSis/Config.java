package xyz.xpulse.DontAtMeSis;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	public static String get(String key) {
		switch (key) {
			case "highlight": return DontAtMeSis.transformColor((String) yml.get("highlight"));
			case "sound": return DontAtMeSis.transformColor((String) yml.get("sound"));
			case "use-display-names": return DontAtMeSis.transformColor((String) yml.get("use-display-names"));
			case "sound-pitch": return DontAtMeSis.transformColor((String) yml.get("sound-pitch"));
			
		}
		return "";
	}
	private static YamlConfiguration yml = YamlConfiguration.loadConfiguration(new File("./plugins/DontAtMeSis/config.yml"));
	public static void init() {
			DontAtMeSis.instance().saveResource("config.yml", false);
			reload();
	}
	public static void reload() {
		try {
			yml.load(new File("./plugins/DontAtMeSis/config.yml"));
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		return;
	}
}
