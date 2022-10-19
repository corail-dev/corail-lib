package net.corail.nms_1_8_8;

import net.corail.nms.NMSHandler;
import net.corail.nms.Vector3;
import org.bukkit.Chunk;
import org.bukkit.Material;

import java.util.List;

public class NMSImpl_1_8_8 implements NMSHandler {
    @Override
    public void setBlockFast(int x, int y, int z, String world, Material material) {

    }

    @Override
    public List<Vector3> findBlocksInChunk(Material material, Chunk chunk) {
        return null;
    }

    @Override
    public String getRequiredNMSVersion() {
        return "v1_8_R3";
    }
}
