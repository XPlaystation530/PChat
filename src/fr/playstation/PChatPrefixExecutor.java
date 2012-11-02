package fr.playstation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PChatPrefixExecutor implements CommandExecutor {

	PChat plugin;
	
	public PChatPrefixExecutor(PChat plugin){
	this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("pchat.prefix")){
			if(args.length == 0){
				plugin.util.prefixError(player);
			} else if(args.length == 1){
				plugin.util.prefixError(player);
			} else if(args.length == 2){
				Player player2 = player.getServer().getPlayer(args[0]);
				if(player2 == null){
					plugin.util.onlineError(player);
				} else {
					plugin.util.setPrefix(player2, args[1]);
					plugin.util.setCrochetPrefix(player2, false);
					plugin.util.prefixChange(player);
				}
			} else if(args.length == 3){
				Player player2 = player.getServer().getPlayer(args[0]);
				if(player2 == null){
					plugin.util.onlineError(player);
				} else {
				if(args[2].equalsIgnoreCase("crochet")){
					plugin.util.setCrochetPrefix(player2, true);
					plugin.util.prefixChange(player);
				}else{
					plugin.util.setCrochetPrefix(player2, false);
					plugin.util.prefixError(player);
				}
			  }
			} else{
				plugin.util.prefixError(player);
			} 
		  } else {
			  plugin.util.permissionError(player);
		  }
		} else {
			plugin.util.senderError(sender);
		}
		return false;
	}
}
