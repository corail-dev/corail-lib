package net.corail.nms_1_19_2;

import net.corail.nms.NMSHandler;
import net.corail.nms.Vector3;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftChunk;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R1.util.CraftMagicNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public List<Vector3> findBlocksInChunk(Material material, Chunk chunk) {
        List<Vector3> list = new ArrayList<>();
        LevelChunk levelChunk = ((CraftChunk) chunk).getHandle();
        int minX = levelChunk.getPos().getMinBlockX();
        int minZ = levelChunk.getPos().getMinBlockZ();
        int maxX = levelChunk.getPos().getMaxBlockX();
        int maxZ = levelChunk.getPos().getMaxBlockZ();

        //Iterate through all blocks
        for (int x = minX; x <= maxX; x++) {
            for (int z = minZ; z <= maxZ; z++) {
                for (int y = 0; y <= 255; y++) {
                    BlockState block = levelChunk.getBlockState(new BlockPos(x, y, z));
                    BlockState b = CraftMagicNumbers.getBlock(material).defaultBlockState();
                    if (block.getBlock().getName().equals(b.getBlock().getName())) {
                        list.add(new Vector3(x, y, z));
                    }
                }
            }
        }
        return list;
    }

    @Override
    public Map<Material, List<Vector3>> findBlocksInChunk(Chunk chunk, Material... materials) {
        return null;
    }

    @Override
    public String getRequiredNMSVersion() {
        return "v1_19_R1";
    }
}
