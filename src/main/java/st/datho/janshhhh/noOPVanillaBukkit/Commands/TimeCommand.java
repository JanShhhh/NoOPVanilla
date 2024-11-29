package st.datho.janshhhh.noOPVanillaBukkit.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Check if the correct number of arguments are provided
        if (args.length != 1) {
            sender.sendMessage("§cUsage: /mytime <day,noon,night,midnight,<ticks>>");
            return false;
        }

        World world = Bukkit.getWorlds().getFirst(); // Get the default world
        String timeArg = args[0].toLowerCase();

        long time;

        switch (timeArg) {
            case "day":
                time = 1000;
                break;
            case "noon":
                time = 6000;
                break;
            case "night":
                time = 13000;
                break;
            case "midnight":
                time = 18000;
                break;
            default:
                try {
                    time = Long.parseLong(timeArg);
                } catch (NumberFormatException e) {
                    sender.sendMessage("§cInvalid time. Use 'day', 'noon', 'night', 'midnight', or a number of ticks.");
                    return false;
                }
        }

        world.setTime(time);
        sender.sendMessage("§aTime set to " + timeArg + ".");
        return true;
    }
}
