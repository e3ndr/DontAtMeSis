package xyz.xpulse.DontAtMeSis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventListener implements Listener {
	 @SuppressWarnings("deprecation")
	@EventHandler
     public void onPlayerChat(AsyncPlayerChatEvent event) {      
		 Player player = event.getPlayer();
		 String message = event.getMessage();
		 if (message.contains("@") && player.hasPermission("DontAtMeSis.ping")) {
			 boolean useDisplayNames = Config.get("use-display-names").equals("true");
        	 ArrayList<String> names = new ArrayList<String>();
        	 for (Player p : Bukkit.getOnlinePlayers()) {
        		 if (useDisplayNames) {
        			 // if (message.toLowerCase().contains(p.getDisplayName().toLowerCase())) names.add(p.getDisplayName());
        		 }
        		 if (message.toLowerCase().contains(p.getName().toLowerCase())) names.add(p.getName());
        	 }
        	 String lastColor = DontAtMeSis.lastColor(message);
        	 for (String name : names) {
        		 String highlight = DontAtMeSis.transformColor(Config.get("highlight"));
        		 String name1 = "@" + name;
        		 String name2 = highlight + name + lastColor;
        		 message = message.replace(name1, name2);
        		 if (message.contains(name2)) {
        			 Player p = Bukkit.getPlayer(name);
        			 p.playSound(p.getLocation(), Sound.valueOf(Config.get("sound").toUpperCase()), 100f, Float.parseFloat(Config.get("sound-pitch")));
        		 }
        	 }
        	 event.setMessage(message);
         }
     }
}
