package net.corail.commands;

import net.corail.core.CorailLib;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlockSetCommand implements CommandExecutor {
    private CorailLib lib;

    public BlockSetCommand(CorailLib lib) {
        this.lib = lib;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 4) {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int z = Integer.parseInt(args[2]);
            String material = args[3];

            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location loc = player.getLocation();
                World world = loc.getWorld();
                lib.getHandler().setBlockFast(x, y, z, world.getName(), Material.getMaterial(material));
                player.sendMessage("Block test completed.");
            }
        }

        return false;
    }
}
