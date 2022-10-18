package net.corail.nms_1_8_8;

import net.corail.nms.NMSHandler;
import org.bukkit.Material;

public class NMSImpl_1_8_8 implements NMSHandler {
    @Override
    public void setBlockFast(int x, int y, int z, String world, Material material) {

    }

    @Override
    public String getRequiredNMSVersion() {
        return "v1_8_R3";
    }
}
