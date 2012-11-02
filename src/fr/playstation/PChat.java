package fr.playstation;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class PChat extends JavaPlugin {

	public Logger log = Logger.getLogger("Minecraft");
	public PChatPrefixExecutor prefix = new PChatPrefixExecutor(this);
	public PChatNomExecutor nom = new PChatNomExecutor(this);
	public PChatSuffixExecutor suffix = new PChatSuffixExecutor(this);
	public PChatMessageExecutor message = new PChatMessageExecutor(this);
	public PChatResetExecutor reset = new PChatResetExecutor(this);
	public PChatHelpExecutor help = new PChatHelpExecutor(this);
	public PChatConfig config = new PChatConfig(this);
	public PChatUtil util = new PChatUtil(this);
	public PChatListener listener = new PChatListener(this);
	
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(listener, this);
		this.getCommand("nom").setExecutor(nom);
		this.getCommand("prefix").setExecutor(prefix);
		this.getCommand("suffix").setExecutor(suffix);
		this.getCommand("couleur").setExecutor(message);
		this.getCommand("reset").setExecutor(reset);
		this.getCommand("pchat").setExecutor(help);
		config.load();
	}
	public void onDisable(){
		config.save();
	}
}
