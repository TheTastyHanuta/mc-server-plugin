package az.events;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandLog implements Listener{
	
	
	



	@EventHandler
	public void onCommandEnter(PlayerCommandPreprocessEvent event) {
		
		Player player = event.getPlayer();
		String cmd = event.getMessage();
		
		Bukkit.broadcastMessage("§c" + player.getName() + " hat den Befehl " + cmd + " eingegeben!");
						
		
 }
}