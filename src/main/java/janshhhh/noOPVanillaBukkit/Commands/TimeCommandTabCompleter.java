package janshhhh.noOPVanillaBukkit.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeCommandTabCompleter implements TabCompleter {

    private static final List<String> TIME_OPTIONS = Arrays.asList("day", "noon", "night", "midnight");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // Only provide suggestions for the first argument
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            String partialInput = args[0].toLowerCase();

            for (String option : TIME_OPTIONS) {
                if (option.startsWith(partialInput)) {
                    completions.add(option);
                }
            }
            return completions;
        }
        return null; // Return null to let Bukkit handle default completions
    }
}
