package az.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import az.main.Mainclass;

public class Deop implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
		
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("deop")) { 
			if(p.isOp()) {
				if(args.length == 1){
				Player target = Bukkit.getPlayer(args[0]);
				target.setOp(false);
				p.sendMessage(Mainclass.prefix + "§7Du hast erfolgreich " + target.getName() + " die Rechte entzogen!");
				target.sendMessage(Mainclass.prefix + "§7Du wurdest zum Spieler ernannt!" );
				}else {
					p.sendMessage(Mainclass.prefix + "§cBitte benutze /deop <Spieler>");
				}
				}else {
				p.sendMessage(Mainclass.noPerm);
			}
		}
		}else {
			if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			target.setOp(false);
			Bukkit.getConsoleSender().sendMessage(Mainclass.prefix  + "§aDu hast erfolgreich " + target.getName() + " die Rechte entzogen!");
			target.sendMessage(Mainclass.prefix + "§7Du wurdest zum Spieler ernannt!" );
		}else {
			Bukkit.getConsoleSender().sendMessage(Mainclass.prefix + "§cBitte benutze /deop <Spieler>!");
		}
		}
		return false;
	}
	

}



