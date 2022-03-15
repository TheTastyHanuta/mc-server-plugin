package az.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teamchat implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(p.hasPermission("langeweile.teamchat") || p.isOp()) {
				StringBuilder text = new StringBuilder();
				for(int i = 0 ; i < args.length ; i++) {
					text.append(args[i]).append(" ");
				}
				String msg = "§c[§3Team§3Chat§c]§a " + p.getName() + "§7: §8" + text.toString();
				for(Player t : Bukkit.getOnlinePlayers()) {
					if(t.hasPermission("langeweile.teamchat") || t.isOp()) {
						t.sendMessage(msg);
					}
				}
				
			} else {
				p.sendMessage("§4Dazu hast du keine Rechte!");
			}
		}
		return true;
	}

}
	


