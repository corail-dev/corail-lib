package net.corail.nms;

import org.bukkit.Material;

public interface NMSHandler {

    void setBlockFast(int x, int y, int z, String world, Material material);
    String getRequiredNMSVersion();

}
