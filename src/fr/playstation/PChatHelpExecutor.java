package fr.playstation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PChatHelpExecutor implements CommandExecutor {
	
	PChat plugin;
	
	public PChatHelpExecutor(PChat plugin){
	this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(args.length == 0){
				plugin.util.sendHelpMessage(player);
			} else {
				plugin.util.sendHelpMessage(player);
			}
		} else {
			plugin.util.senderError(sender);
		}
		return false;
	}
}
