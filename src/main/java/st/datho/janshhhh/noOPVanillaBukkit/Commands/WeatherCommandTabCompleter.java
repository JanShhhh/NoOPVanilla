package st.datho.janshhhh.noOPVanillaBukkit.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherCommandTabCompleter implements TabCompleter {

    private static final List<String> WEATHER_OPTIONS = Arrays.asList("clear", "rain", "thunder");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // Only provide suggestions for the first argument
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            String partialInput = args[0].toLowerCase();

            for (String option : WEATHER_OPTIONS) {
                if (option.startsWith(partialInput)) {
                    completions.add(option);
                }
            }
            return completions;
        }
        return null; // Return null to let Bukkit handle default completions
    }
}
