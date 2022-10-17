package net.corail.nms_1_19_2;

import net.corail.nms.NMSHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;

public class NMSImpl_1_19_2 implements NMSHandler {
    @Override
    public void setBlockFast(int x, int y, int z, String world, Material material) {
        int id = getId(material);
        byte data = (byte) getData(material);
        int combined = getCombinedId(id, data);

        World w = null;
        try {w = Bukkit.getWorld(world);} catch (Exception e) {Bukkit.getLogger().severe("[Corail] Invalid world name received, check your world names in configs.");}
        if (w == null) return;


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
