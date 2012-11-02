package fr.playstation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PChatSuffixExecutor implements CommandExecutor {

	PChat plugin;
	
	public PChatSuffixExecutor(PChat plugin){
	this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("pchat.suffix")){
			if(args.length == 0){
				plugin.util.suffixError(player);
			} else if(args.length == 1){
				plugin.util.suffixError(player);
			} else if(args.length == 2){
				Player player2 = player.getServer().getPlayer(args[0]);
				if(player2 == null){
					plugin.util.onlineError(player);
				} else {
					plugin.util.setSuffix(player2, args[1]);
					plugin.util.setCrochetSuffix(player2, false);
					plugin.util.suffixChange(player);
				}
			} else if(args.length == 3){
				Player player2 = player.getServer().getPlayer(args[0]);
				if(player2 == null){
					plugin.util.onlineError(player);
				} else {
				if(args[2].equalsIgnoreCase("crochet")){
					plugin.util.setCrochetSuffix(player2, true);
					plugin.util.suffixChange(player);
				}else{
					plugin.util.setCrochetSuffix(player2, false);
					plugin.util.suffixError(player);
				}
			  }
			}  
			
			else{
				plugin.util.suffixError(player);
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
