package az.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class Sleepcommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            long ingametime = p.getWorld().getTime();
            if (args.length == 0) {
                if (cmd.getName().equalsIgnoreCase("sleep")) {
                    if ((ingametime > 12541) && (ingametime < 24000)) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 70, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 70, 4));
                        

	                                        
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {

                                    @Override
                                    public void run() {
                                      
                                    	Bukkit.broadcastMessage("§b" + p.getName() + " hat geschlafen!");
                                        p.sendMessage(
                                                "§aDu hast dich erfolgreich ausgeruht und deinen Respawnpunkt neu gesetzt!");
                                        
                                    }

                                },
                                6000);
                        
                        p.setBedSpawnLocation(p.getLocation(), true);
                        p.getWorld().setTime(1000);

                    } else {
                        p.sendMessage("Es ist noch nicht Nacht!");
                    }
                }
            } else {
                p.sendMessage("Bitte benutze /sleep!");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage("Error!");
        }

        return false;
    }

}
