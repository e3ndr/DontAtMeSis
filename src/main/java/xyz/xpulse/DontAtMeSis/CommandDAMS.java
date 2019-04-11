package xyz.xpulse.DontAtMeSis;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class CommandDAMS implements CommandExecutor, TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1 && sender.hasPermission("DontAtMeSis.admin")) {
			ArrayList<String> sub = new ArrayList<String>();
			sub.add("reload");
			return sub;
		} else {
			return new ArrayList<String>(0);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 1 && sender.hasPermission("DontAtMeSis.admin")) {
			Config.reload();
			return true;
		} else {
			sender.sendMessage(DontAtMeSis.transformColor("&aDontAtMeSis&2 version &a" + DontAtMeSis.version()));
			return true;
		}
	}

}
