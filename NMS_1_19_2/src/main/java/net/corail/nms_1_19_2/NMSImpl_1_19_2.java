package net.corail.nms_1_19_2;

import net.corail.nms.NMSHandler;
import org.bukkit.Material;

public class NMSImpl_1_19_2 implements NMSHandler {
    @Override
    public void setBlockFast(int x, int y, int z, String world, int id, byte data) {
        int combined = id + (data << 12);
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
