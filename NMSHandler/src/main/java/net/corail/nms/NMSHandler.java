package net.corail.nms;

import org.bukkit.Chunk;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public interface NMSHandler {

    void setBlockFast(int x, int y, int z, String world, Material material);
    List<Vector3> findBlocksInChunk(Material material, Chunk chunk);
    Map<Material, List<Vector3>> findBlocksInChunk(Chunk chunk, Material... materials);
    String getRequiredNMSVersion();

}
