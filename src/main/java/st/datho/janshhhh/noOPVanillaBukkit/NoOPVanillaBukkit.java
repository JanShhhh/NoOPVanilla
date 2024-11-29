package st.datho.janshhhh.noOPVanillaBukkit;

import org.bukkit.plugin.java.JavaPlugin;
import st.datho.janshhhh.noOPVanillaBukkit.Commands.TeleportCommand;
import st.datho.janshhhh.noOPVanillaBukkit.Commands.TimeCommand;
import st.datho.janshhhh.noOPVanillaBukkit.Commands.WeatherCommand;
import st.datho.janshhhh.noOPVanillaBukkit.Commands.HelpCommand;
import st.datho.janshhhh.noOPVanillaBukkit.EventHandler.TeleportCatchExecuteIn;
import st.datho.janshhhh.noOPVanillaBukkit.Commands.TimeCommandTabCompleter;
import st.datho.janshhhh.noOPVanillaBukkit.Commands.WeatherCommandTabCompleter;

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
