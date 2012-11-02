package fr.playstation;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PChatUtil {

	PChat plugin;
	
	public PChatUtil(PChat plugin){
		this.plugin = plugin;
	}
	
	public void nomChange(Player p){
		p.sendMessage(ChatColor.DARK_GREEN + "[PChat] Le nom de ce joueur a bien changé.");
	}
	
	public void resetChange(Player p){
		p.sendMessage(ChatColor.DARK_GREEN + "[PChat] Le suffixe, préfixe, nom et la couleur d'écriture a bien été reset.");
	}
	
	public void prefixChange(Player p){
		p.sendMessage(ChatColor.DARK_GREEN + "[PChat] Le préfixe de ce joueur a bien changé.");
	}
	
	public void suffixChange(Player p){
		p.sendMessage(ChatColor.DARK_GREEN + "[PChat] Le suffixe de ce joueur a bien changé.");
	}
	
	public void couleurChange(Player p){
		p.sendMessage(ChatColor.DARK_GREEN + "[PChat] Le couleur d'écriture de ce joueur a bien changé.");
	}
	
	public void sendHelpMessage(Player player){
		player.sendMessage(ChatColor.DARK_GREEN + "PChat v1.0 - Developped by Playstation530");
		player.sendMessage(ChatColor.AQUA + "/reset <Player> " + ChatColor.GREEN + "- Permet de remettre à zéro le Suffix, Préfix, Nom, Couleur d'un joueur.");
		player.sendMessage(ChatColor.AQUA + "/couleur <Player> <Couleur> " + ChatColor.GREEN + "- Permet de changer la couleur d'écriture d'un joueur. Exemple : /couleur joueur &5");
		player.sendMessage(ChatColor.AQUA + "/prefix <Player> <Prefix> (crochet) " + ChatColor.GREEN + "- Permet de changer le prefix d'un joueur dans le chat. Vous pouvez mettre de la couleur avec &1, &2, &3 etc.");
		player.sendMessage(ChatColor.AQUA + "/suffix <Player> <Suffix> (crochet) " + ChatColor.GREEN + "- Permet de changer le suffix d'un joueur dans le chat. Vous pouvez mettre de la couleur avec &1, &2, &3 etc.");
		player.sendMessage(ChatColor.AQUA + "/nom <Player> <Nom> " + ChatColor.GREEN + "- Permet de changer le nom d'un joueur dans le chat. Vous pouvez mettre de la couleur avec &1, &2, &3 etc.");
	}
	
	public void onlineError(Player p){
		p.sendMessage(ChatColor.RED + "[PChat] Ce joueur n'est pas en ligne.");
	}
	
	public void permissionError(Player p){
		p.sendMessage(ChatColor.DARK_RED + "Vous n'avez pas la permission.");
	}
	
	public void nomError(Player p){
		p.sendMessage(ChatColor.RED + "[PChat] Mauvais usage : /nom <Joueur> <Nom>");
	}
	
	public void resetError(Player p){
		p.sendMessage(ChatColor.RED + "[PChat] Mauvais usage : /reset <Joueur>");
	}
	
	public void prefixError(Player p){
		p.sendMessage(ChatColor.RED + "[PChat] Mauvais usage : /prefix <Joueur> <Prefix> (crochet)");
	}
	
	public void suffixError(Player p){
		p.sendMessage(ChatColor.RED + "[PChat] Mauvais usage : /suffix <Joueur> <Suffix> (crochet)");
	}
	
	public void senderError(CommandSender sender){
		sender.sendMessage(ChatColor.RED + "[PChat] Vous devez etre un joueur pour faire cette commande.");
	}
	
	public void colorError(Player player){
		player.sendMessage(ChatColor.RED + "[PChat] Mauvais usage : /message <Joueur> <Couleur>");
	}
	
	public void mauvaiseColorError(Player player){
		player.sendMessage(ChatColor.RED + "[PChat] Ce n'est pas une couleur. Exemple : &0, &1, &2, [...]");
	}
    
    public String getPrefix(Player player){
    	String s = plugin.config.players.getString(player.getName() + ".prefix");
    	if(isCrochetPrefix(player)){
    		return "[" + s + ChatColor.RESET + "]";
    	}else{
    		return s + ChatColor.RESET;
    	}
    }
    
    public String getSuffix(Player player){
    	String s = plugin.config.players.getString(player.getName() + ".suffix");
    	if(isCrochetSuffix(player)){
    		return "[" + s + ChatColor.RESET + "]";
    	}else{
    		return s + ChatColor.RESET;
    	}
    }
    
    public String getNom(Player player){
    	String s = plugin.config.players.getString(player.getName() + ".nom");
    	return s;
    }
    
    public String getColorMessage(Player player){
    	String s = plugin.config.players.getString(player.getName() + ".couleur");
    	return s;
    }
    
    public void setColorMessage(Player player, String couleur){
    	plugin.config.players.set(player.getName() + ".couleur", couleur);
    }
    
    public void setPrefix(Player player, String prefix){
    	plugin.config.players.set(player.getName() + ".prefix", prefix);
    }
    
    public void setCrochetPrefix(Player player, Boolean b){
    	plugin.config.players.set(player.getName() + ".crochetPrefix", b);
    }
    
    public void setCrochetSuffix(Player player, Boolean b){
    	plugin.config.players.set(player.getName() + ".crochetSuffix", b);
    }
    
    public Boolean isCrochetSuffix(Player player){
    	if(plugin.config.players.getBoolean(player.getName() + ".crochetSuffix")){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public Boolean isCrochetPrefix(Player player){
    	if(plugin.config.players.getBoolean(player.getName() + ".crochetPrefix")){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void setSuffix(Player player, String suffix){
    	plugin.config.players.set(player.getName() + ".suffix", suffix);
    }
 
    public void setNom(Player player, String nom){
    	player.setDisplayName(nom);
    	plugin.config.players.set(player.getName() + ".nom", player.getDisplayName());
    }
}
