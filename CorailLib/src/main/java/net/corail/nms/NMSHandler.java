package net.corail.nms;

import org.bukkit.Material;

public interface NMSHandler {

    void setBlockFast(int x, int y, int z, String world, Material material);
    int getId(Material material);
    int getData(Material material);
    String getRequiredNMSVersion();

}
