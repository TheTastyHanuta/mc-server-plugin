package az.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(!p.hasPermission("langeweile.bc")) {
				p.sendMessage("§4Keine Rechte!");
				return true;
			}
		}
		StringBuilder text = new StringBuilder();
		for(int i = 0 ; i < args.length ; i++) {
			text.append(args[i]).append(" ");
		}
		
		Bukkit.broadcastMessage("§8[§4Rundruf§8]§2 " +  text.toString());
		
		return true;
	}

}
