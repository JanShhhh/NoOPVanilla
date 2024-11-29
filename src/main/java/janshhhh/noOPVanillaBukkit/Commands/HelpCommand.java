package janshhhh.noOPVanillaBukkit.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {

    private final String pluginName = ChatColor.GREEN + "NoOPVanilla";
    private final String header = ChatColor.AQUA + "==== " + pluginName + ChatColor.AQUA + " Commands ====";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(header);
        sender.sendMessage(ChatColor.YELLOW + "/mytp <x> <y> <z>" + ChatColor.WHITE + " - Teleport to coordinates.");
        sender.sendMessage(ChatColor.YELLOW + "/mytp <player>" + ChatColor.WHITE + " - Teleport to another player.");
        sender.sendMessage(ChatColor.YELLOW + "/mytime <day,noon,night,midnight,<ticks>>" + ChatColor.WHITE + " - Set the time of day.");
        sender.sendMessage(ChatColor.YELLOW + "/myweather <clear,rain,thunder>" + ChatColor.WHITE + " - Set the weather.");
        sender.sendMessage(ChatColor.YELLOW + "/NoOPHelp" + ChatColor.WHITE + " - Display this help message.");
        return true;
    }
}
