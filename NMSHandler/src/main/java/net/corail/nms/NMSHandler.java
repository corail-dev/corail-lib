package net.corail.nms;

import org.bukkit.Chunk;
import org.bukkit.Material;

import java.util.List;

public interface NMSHandler {

    void setBlockFast(int x, int y, int z, String world, Material material);
    List<Vector3> findBlocksInChunk(Material material, Chunk chunk);
    String getRequiredNMSVersion();

}
