package net.corail.nms_1_8_8;

import net.corail.nms.NMSHandler;
import org.bukkit.Material;

public class NMSImpl_1_8_8 implements NMSHandler {
    @Override
    public void setBlockFast(int x, int y, int z, String world, int id, byte data) {

    }

    @Override
    public int getId(Material material) {
        return material.getId();
    }

    @Override
    public int getData(Material material) {
        return material.getData().getModifiers();
    }

    @Override
    public String getRequiredNMSVersion() {
        return "v1_8_R3";
    }
}
