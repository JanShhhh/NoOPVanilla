package janshhhh.noOPVanillaBukkit.EventHandler;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.entity.Player;

public class TeleportCatchExecuteIn implements Listener {

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage(); // The full command
        Player player = event.getPlayer();

        // Check if the command starts with "/execute in"
        if (message.startsWith("/execute in ")) {

            // Parse the command to extract dimension and coordinates
            // Expected format: /execute in <dimension> run wp x y z

            String[] parts = message.split(" ");

            if (parts.length >= 7 && parts[3].equalsIgnoreCase("run") && parts[4].equalsIgnoreCase("mytp")) {
                String dimensionName = parts[2];
                String xArg = parts[5];
                String yArg = parts[6];
                String zArg = parts[7];

                // Get the target world
                World targetWorld = getWorldFromDimension(dimensionName);

                if (targetWorld == null) {
                    player.sendMessage("§cInvalid dimension: " + dimensionName);
                    event.setCancelled(true);
                    return;
                }

                try {
                    // Parse coordinates
                    double x = parseCoordinate(xArg, player.getLocation().getX());
                    double y = parseCoordinate(yArg, player.getLocation().getY());
                    double z = parseCoordinate(zArg, player.getLocation().getZ());

                    // Create the target location
                    Location targetLocation = new Location(targetWorld, x, y, z);

                    // Teleport the player
                    player.teleport(targetLocation);
                    player.sendMessage("§aTeleported to " + x + ", " + y + ", " + z + " in " + targetWorld.getName());

                    // Cancel the original command to prevent further processing
                    event.setCancelled(true);
                } catch (NumberFormatException e) {
                    player.sendMessage("§cCoordinates must be numbers or relative (~).");
                    event.setCancelled(true);
                }
            }
        }
    }

    private World getWorldFromDimension(String dimension) {
        switch (dimension.toLowerCase()) {
            case "minecraft:overworld":
                return Bukkit.getWorld("world");
            case "minecraft:the_nether":
                return Bukkit.getWorld("world_nether");
            case "minecraft:the_end":
                return Bukkit.getWorld("world_the_end");
            default:
                return null;
        }
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
