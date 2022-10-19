package net.corail.commands;

import net.corail.core.CorailLib;
import net.corail.nms.Vector3;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class FindBlockTestCommand implements CommandExecutor {
    private CorailLib lib;

    public FindBlockTestCommand(CorailLib lib) {
        this.lib = lib;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Material material = Material.DIAMOND_ORE;
            List<Vector3> positions = lib.getHandler().findBlocksInChunk(material, player.getLocation().getChunk());
            player.sendMessage("Found " + positions.size() + " " + material.name() + " blocks in chunk.");
        }

        return false;
    }
}
