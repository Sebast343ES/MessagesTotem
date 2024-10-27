package mt.sqbas;

import mt.sqbas.commands.MainCommand;
import mt.sqbas.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MessagesTotem extends JavaPlugin {

    public static String prefix = "&8[&e&lMessagesTotems&8] ";
    private String version = getDescription().getVersion();

    public void onEnable() {
        registerCommands();
        registerEvents();

        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', prefix + "¡&aLos mensajes de los totems han sido cargados correctamente&f! &fVersion: " + version));
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', prefix + "¡&aLos mensajes de los totems han sido deshabilitados correctamente&f! &fVersion: " + version));
    }

    public void registerCommands(){
        this.getCommand("messagestotem").setExecutor(new MainCommand(this));
    }

    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new PlayerListener(),this);
    }
}

