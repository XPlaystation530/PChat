package fr.playstation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PChatNomExecutor implements CommandExecutor {

	PChat plugin;
	
	public PChatNomExecutor(PChat plugin){
	this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("pchat.nom")){
			if(args.length == 0){
				plugin.util.nomError(player);
			} else if(args.length == 1){
				plugin.util.nomError(player);
			} else if(args.length == 2){
				Player player2 = player.getServer().getPlayer(args[0]);
				if(player2 == null){
					plugin.util.onlineError(player);
				} else {
					plugin.util.setNom(player2, args[1]);
					plugin.util.nomChange(player);
				}
			} else{
				plugin.util.nomError(player);
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
