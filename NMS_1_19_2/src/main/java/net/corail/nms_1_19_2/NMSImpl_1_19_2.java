package net.corail.nms_1_19_2;

import net.corail.nms.NMSHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R1.block.CraftBlockState;

public class NMSImpl_1_19_2 implements NMSHandler {
    @Override
    public void setBlockFast(int x, int y, int z, String world, Material material) {
        int id = getId(material);
        byte data = (byte) getData(material);

        World w = null;
        try {w = Bukkit.getWorld(world);} catch (Exception e) {Bukkit.getLogger().severe("[Corail] Invalid world name received, check your world names in configs.");}
        if (w == null) return;

        ServerLevel level = ((CraftWorld) w).getHandle();
        Chunk chunk = w.getChunkAt(x >> 4, z >> 4);
        BlockState state = chunk.getBlock(x & 15, y, z & 15).getState();
        BlockPos blockPos = new BlockPos(x, y, z);
        state.setData(material.getNewData(data));
        level.setBlock(blockPos, ((CraftBlockState) state).getHandle(), 2);
    }

    @Override
    public int getId(Material material) {
        return material.getId();
    }

    @Override
    public int getData(Material material) {
        return material.getData().getModifiers();
    }

    private int getCombinedId(int id, int data) {
        return id + (data << 12);
    }

    @Override
    public String getRequiredNMSVersion() {
        return "v1_19_R1";
    }
}
