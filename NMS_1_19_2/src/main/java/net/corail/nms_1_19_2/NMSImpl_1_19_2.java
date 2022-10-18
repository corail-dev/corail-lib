package net.corail.nms_1_19_2;

import net.corail.nms.NMSHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R1.util.CraftMagicNumbers;

public class NMSImpl_1_19_2 implements NMSHandler {
    @Override
    public void setBlockFast(int x, int y, int z, String world, Material material) {
        BlockState block = CraftMagicNumbers.getBlock(material, (byte)0);

        World w = null;
        try {w = Bukkit.getWorld(world);} catch (Exception e) {Bukkit.getLogger().severe("[Corail] Invalid world name received, check your world names in configs.");}
        if (w == null) return;

        ServerLevel level = ((CraftWorld) w).getHandle();
        BlockPos blockPos = new BlockPos(x, y, z);
        level.setBlock(blockPos, block, 2);
    }

    @Override
    public String getRequiredNMSVersion() {
        return "v1_19_R1";
    }
}
