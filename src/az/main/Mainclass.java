package az.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


import az.commands.Broadcast;
import az.commands.Deop;
import az.commands.Difficulty;
import az.commands.Gamemode;
import az.commands.Gm;
import az.commands.Heal;
import az.commands.Op;
import az.commands.Sleepcommand;
import az.commands.Teamchat;
import az.commands.Tpa;
import az.commands.TpaAccept;
import az.commands.TpaDeny;
import az.events.Join;
import az.events.Chat;
import az.events.CommandLog;

public class Mainclass extends JavaPlugin{
	
	public static String prefix = "§8[§3Server§8] ";
	public static String noPerm = prefix + "§cDu hast keine Rechte dazu!";
	public static HashMap<Player, Player> tpa = new HashMap<Player, Player>();


	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(prefix+ "§7enabled");
		this.getCommand("heal").setExecutor(new Heal());
		this.getCommand("gm").setExecutor(new Gm());
		Bukkit.getPluginManager().registerEvents(new Join(), this);
		this.getCommand("sleep").setExecutor(new Sleepcommand());
		Bukkit.getPluginManager().registerEvents(new Chat(), this);
		this.getCommand("bc").setExecutor(new Broadcast());
		this.getCommand("op").setExecutor(new Op());
		this.getCommand("deop").setExecutor(new Deop());
		this.getCommand("tc").setExecutor(new Teamchat());
		this.getCommand("tpa").setExecutor(new Tpa());
		this.getCommand("tpaccept").setExecutor(new TpaAccept());
		this.getCommand("tpadeny").setExecutor(new TpaDeny());
		this.getCommand("difficulty").setExecutor(new Difficulty());
		Bukkit.getPluginManager().registerEvents(new CommandLog(), this);
		this.getCommand("gamemode").setExecutor(new Gamemode());
	}
	
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(prefix+ "§7disabled");
	}

}

