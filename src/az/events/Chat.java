package az.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class Chat  implements Listener{
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("prefix.owner")){
			e.setFormat("§4Owner : " + p.getName() + "§8 : §l§a" + e.getMessage());
		}else if(p.hasPermission("prefix.admin")){
			e.setFormat("§4Admin : " + p.getName() + "§8 : §l§a" + e.getMessage());
		}else if(p.hasPermission("prefix.dev")){
			e.setFormat("§bDeveloper : " + p.getName() + "§8 : §7" + e.getMessage());
		}else if(p.hasPermission("prefix.moderator")){
			e.setFormat("§cModerator : " + p.getName() + "§8 : §7" + e.getMessage());
		}else if(p.hasPermission("prefix.supporter")){
			e.setFormat("§9Supporter : " + p.getName() + "§8 : §7" + e.getMessage());	
		}else if(p.hasPermission("prefix.builder")){
			e.setFormat("§2Builder : " + p.getName() + "§8 : §7" + e.getMessage());
		}else if(p.hasPermission("prefix.youtuber")){
			e.setFormat("§5YouTuber : " + p.getName() + "§8 : §7" + e.getMessage());
		}else if(p.hasPermission("prefix.premium")){
			e.setFormat("§6Premium : " + p.getName() + "§8 : §7" + e.getMessage());
		}else if(p.hasPermission("*")) {
			e.setFormat("§4Owner : " + p.getName() + "§8 : §l§a" + e.getMessage());
		}else if(p.isOp()) {
			e.setFormat("§4Owner : " + p.getName() + "§8 : §l§a" + e.getMessage());
		}else if(p.hasPermission("prefix.spieler")){
			e.setFormat("§7Spieler : " + p.getName() + "§8 : §7" + e.getMessage());
		}
		
	}

}
