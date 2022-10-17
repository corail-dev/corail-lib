package net.corail.nms_1_8_8;

import net.corail.nms.NMSHandler;

public class NMSImpl_1_8_8 implements NMSHandler {
    @Override
    public void setBlockFast(int x, int y, int z, String world, int id, byte data) {

    }

    @Override
    public String getRequiredNMSVersion() {
        return "v1_7_R4";
    }
}
