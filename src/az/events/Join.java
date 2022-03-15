package az.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;



public class Join implements Listener{
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		e.setJoinMessage("§aDer*die Spieler*in " + p.getName() + " §ahat den Server betreten!");
		
		
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onQuit(PlayerQuitEvent e) {
		
		Player p =e.getPlayer();
		e.setQuitMessage("§aDer*die Spieler*in " + p.getName() + " §ahat den Server verlassen!");
		
    }
	

	

}
