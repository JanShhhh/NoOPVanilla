package janshhhh.noOPVanillaBukkit;

import org.bukkit.plugin.java.JavaPlugin;
import janshhhh.noOPVanillaBukkit.Commands.TeleportCommand;
import janshhhh.noOPVanillaBukkit.Commands.TimeCommand;
import janshhhh.noOPVanillaBukkit.Commands.WeatherCommand;
import janshhhh.noOPVanillaBukkit.Commands.HelpCommand;
import janshhhh.noOPVanillaBukkit.EventHandler.TeleportCatchExecuteIn;
import janshhhh.noOPVanillaBukkit.Commands.TimeCommandTabCompleter;
import janshhhh.noOPVanillaBukkit.Commands.WeatherCommandTabCompleter;

public final class NoOPVanillaBukkit extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Enabling NoOPVanilla Plugin");

        // Register Command Executors
        this.getCommand("mytp").setExecutor(new TeleportCommand());
        this.getCommand("mytime").setExecutor(new TimeCommand());
        this.getCommand("myweather").setExecutor(new WeatherCommand());
        this.getCommand("NoOPHelp").setExecutor(new HelpCommand());

        // Register Tab Completers
        this.getCommand("mytime").setTabCompleter(new TimeCommandTabCompleter());
        this.getCommand("myweather").setTabCompleter(new WeatherCommandTabCompleter());

        // Xaeros Minimap Fix to catch cross dimensional teleport using waypoints
        getServer().getPluginManager().registerEvents(new TeleportCatchExecuteIn(), this);

        getLogger().info("NoOPVanilla plugin has been enabled successfully.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
