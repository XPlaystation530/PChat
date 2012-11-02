package fr.playstation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PChatMessageExecutor implements CommandExecutor {

	PChat plugin;
	
	public PChatMessageExecutor(PChat plugin){
	this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("pchat.couleur")){
			if(args.length == 0){
				plugin.util.colorError(player);
			} else if(args.length == 1){
				plugin.util.colorError(player);
			} else if(args.length == 2){
				Player player2 = player.getServer().getPlayer(args[0]);
				if(player2 == null){
					plugin.util.onlineError(player);
				} else {
					if(args[1].startsWith("&")){
						plugin.util.setColorMessage(player, args[1]);
						plugin.util.couleurChange(player);
					} else {
						plugin.util.mauvaiseColorError(player);
					}
				}
			} else{
				plugin.util.colorError(player);
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
