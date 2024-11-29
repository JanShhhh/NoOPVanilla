package st.datho.janshhhh.noOPVanillaBukkit.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WeatherCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Check if the correct number of arguments are provided
        if (args.length != 1) {
            sender.sendMessage("§cUsage: /myweather <clear,rain,thunder>");
            return false;
        }

        World world = Bukkit.getWorlds().getFirst(); // Get the default world
        String weatherArg = args[0].toLowerCase();

        switch (weatherArg) {
            case "clear":
                world.setStorm(false);
                world.setThundering(false);
                world.setWeatherDuration(0);
                break;
            case "rain":
                world.setStorm(true);
                world.setThundering(false);
                break;
            case "thunder":
                world.setStorm(true);
                world.setThundering(true);
                break;
            default:
                sender.sendMessage("§cInvalid weather type. Use 'clear', 'rain', or 'thunder'.");
                return false;
        }

        sender.sendMessage("§aWeather set to " + weatherArg + ".");
        return true;
    }
}
