package fr.playstation;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PChatListener implements Listener {
	
	PChat plugin;
	
	public PChatListener(PChat plugin){
		this.plugin = plugin;
	}
	
    @SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.NORMAL)
	  public void onPlayerChat(PlayerChatEvent event) {
	    Player player = event.getPlayer();
	    String prefix = plugin.util.getPrefix(player);
	    String suffix = plugin.util.getSuffix(player);
	    String color = plugin.util.getColorMessage(player);
	    String nom = plugin.util.getNom(player);
	    
	    boolean p = plugin.util.getPrefix(player) != null;
	    boolean s = plugin.util.getSuffix(player) != null;
	    boolean c = plugin.util.getColorMessage(player) != null;
	    boolean n = plugin.util.getNom(player) != null;
	         if(p && s && c && n)
	    if(plugin.config.players.getString(player.getName() + ".prefix") == ""
	    && plugin.config.players.getString(player.getName() + ".suffix") == ""
	    && plugin.config.players.getString(player.getName() + ".couleur") == "&f"
	    && plugin.config.players.getString(player.getName() + ".nom") == player.getName()){
	         event.setFormat(player.getName() + ": " + event.getMessage());
	   } else{
	     	 event.setFormat(prefix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + suffix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + color.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + event.getMessage());
	        }
	    else if(p && s && c)
	         event.setFormat(prefix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + suffix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + color.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + event.getMessage());
	    else if(p && s)
	    	 event.setFormat(prefix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + suffix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " +  event.getMessage());
	    else if(p)
	    	 event.setFormat(prefix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + event.getMessage());
	    else if(p && c)
	    	 event.setFormat(prefix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + color.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + event.getMessage());
	    else if(p && c && n)
	    	 event.setFormat(prefix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + color.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + event.getMessage());
	    else if(p && n)
	    	 event.setFormat(prefix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + event.getMessage());
	    else if(s && c && n)
	         event.setFormat(nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + suffix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + color.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + event.getMessage());
	    else if(s && c)
	    	event.setFormat(nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + suffix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + color.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + event.getMessage());
	    else if(s && n)
	    	 event.setFormat(nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + suffix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + event.getMessage());
	    else if(s)
	    	event.setFormat(nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + " " + suffix.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + event.getMessage());
	    else if(c && n)
	         event.setFormat(nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + color.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + event.getMessage());
	    else if(c)
	    	event.setFormat(nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + color.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + event.getMessage());
	    else if(n)
	    	event.setFormat(nom.replaceAll("(&([A-Fa-f0-9L-Ol-o]))", "§$2") + ChatColor.RESET + ": " + event.getMessage());
	  }
}
