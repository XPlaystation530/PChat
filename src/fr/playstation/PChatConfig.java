package fr.playstation;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PChatConfig {

	PChat plugin;
    public File b;
    public FileConfiguration players;
	
	public PChatConfig(PChat plugin){
	this.plugin = plugin;
	}
	
    public void load()
    {
            b = new File(plugin.getDataFolder(), "players.yml");
            if(!b.exists())
            {
            	players = YamlConfiguration.loadConfiguration(b);
                    try
                    {
                    	players.save(b);
                    }
                    catch(IOException ex)
                    {
                    }
            }
            players = YamlConfiguration.loadConfiguration(b);
    }
    
    public void save()
    {
        b = new File(plugin.getDataFolder(), "players.yml");  
            try
            {
                    players.save(b);
            }
            catch(IOException ex)
            {
            }
    }
	
}
