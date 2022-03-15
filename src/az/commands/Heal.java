package az.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import az.main.Mainclass;

public class Heal implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		

		if(sender instanceof Player) {	
			
			Player p =(Player)sender;
			if(cmd.getName().equalsIgnoreCase("heal")){
				if(p.hasPermission("system.heal")){
					if(args.length == 0){
						if(p.getHealth() == 20){
							p.sendMessage(Mainclass.prefix + "§cDu hast schon volle Leben!");
						}else{
							p.setHealthScale(20);
							p.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(Mainclass.prefix + "§aDu wurdest geheilt!");	
							}
						}else if(args.length == 1){
							Player target = Bukkit.getPlayer(args[0]);
							if(target != null) {
								if(target.getHealth() == 20){
									p.sendMessage(Mainclass.prefix + "§cDer Spieler hat schon volle Leben!");
								}else{	
										target.setHealth(20);
										target.setFoodLevel(20);
										target.sendMessage(Mainclass.prefix + "§aDu wurdest geheilt!");
										p.sendMessage(Mainclass.prefix + "§aDu hast den angegebenen Spieler geheilt!");
								}
							}else{
								p.sendMessage(Mainclass.prefix + "§cDer angegebene Spieler ist nicht online!");
							}
							
						}else{
							p.sendMessage(Mainclass.prefix + "§cBitte benutze /heal <SPIELER>!");
						}
				}else{ 
					p.sendMessage(Mainclass.noPerm);
				}
			}
		}else{
			if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.getHealth() == 20){
					Bukkit.getConsoleSender().sendMessage(Mainclass.prefix + "§cDer Spieler hat schon volle Leben!");
				}else{	
						target.setHealth(20);
						target.setFoodLevel(20);
						target.sendMessage(Mainclass.prefix + "§aDu wurdest geheilt!");
						Bukkit.getConsoleSender().sendMessage(Mainclass.prefix +"§aDu hast den angegebenen Spieler geheilt!");
				}
			}else{
				Bukkit.getConsoleSender().sendMessage(Mainclass.prefix +"§cDer angegebene Spieler ist nicht online!");
			}
			}else {
				Bukkit.getConsoleSender().sendMessage(Mainclass.prefix +"§cBitte benutze /heal <SPIELER>!");
			}
			}
		return false;
	}
}