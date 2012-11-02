package fr.playstation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PChatResetExecutor implements CommandExecutor {

	PChat plugin;
	
	public PChatResetExecutor(PChat plugin){
	this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("pchat.reset")){
			if(args.length == 0){
				plugin.util.resetError(player);
			} else if(args.length == 1){
				Player player2 = player.getServer().getPlayer(args[0]);
				plugin.util.setNom(player2, player2.getName().replaceAll(" ", ""));
				plugin.util.setPrefix(player2, "".replaceAll(" ", ""));
				plugin.util.setSuffix(player2, "".replaceAll(" ", ""));
				plugin.util.setCrochetPrefix(player2, false);
				plugin.util.setCrochetSuffix(player2, false);
				plugin.util.setColorMessage(player2, "&f".replaceAll(" ", ""));
				plugin.util.resetChange(player);
			} else {
				plugin.util.resetError(player);
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
