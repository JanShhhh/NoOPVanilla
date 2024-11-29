package janshhhh.noOPVanillaBukkit.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TeleportCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Ensure the sender is a player
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;


        // No arguments provided
        if (args.length == 0) {
            player.sendMessage("§cUsage: /mytp <x> <y> <z> or /mytp <player>");
            return false;
        }

        // Teleport to another player
        if (args.length == 1) {
            String targetName = args[0];
            Player targetPlayer = Bukkit.getPlayerExact(targetName);

            if (targetPlayer == null || !targetPlayer.isOnline()) {
                player.sendMessage("§cPlayer '" + targetName + "' is not online.");
                return true;
            }

            // Teleport the player to the target player
            player.teleport(targetPlayer.getLocation());
            player.sendMessage("§aTeleported to player " + targetPlayer.getName() + ".");
            return true;
        }

        // Teleport to coordinates
        if (args.length == 3) {
            try {
                // Parse coordinates
                double x = parseCoordinate(args[0], player.getLocation().getX());
                double y = parseCoordinate(args[1], player.getLocation().getY());
                double z = parseCoordinate(args[2], player.getLocation().getZ());

                // Get the player's current world
                World world = player.getWorld();

                // Create a new location object
                Location targetLocation = new Location(world, x, y, z);

                // Teleport the player
                player.teleport(targetLocation);
                player.sendMessage("§aTeleported to " + x + ", " + y + ", " + z + ".");
                return true;

            } catch (NumberFormatException e) {
                player.sendMessage("§cCoordinates must be numbers or relative (~).");
                return false;
            }
        }

        // Invalid usage
        player.sendMessage("§cUsage: /mytp <x> <y> <z> or /mytp <player>");
        return false;
    }

    private double parseCoordinate(String input, double current) throws NumberFormatException {
        if (input.startsWith("~")) {
            if (input.length() == 1) {
                return current;
            } else {
                return current + Double.parseDouble(input.substring(1));
            }
        } else {
            return Double.parseDouble(input);
        }
    }
}
