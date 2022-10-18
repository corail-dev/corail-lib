package net.corail.core;

import net.corail.nms.NMSHandler;
import net.corail.nms.ServerVersion;
import net.corail.nms_1_19_2.NMSImpl_1_19_2;
import org.bukkit.plugin.java.JavaPlugin;

public class CorailLib extends JavaPlugin {
    private NMSHandler handler;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Detected Java Version: " + ServerVersion.getBukkitVersion());
        decideNMSHandler();
    }

    private void decideNMSHandler() {
        String bukkitVersion = ServerVersion.getBukkitVersion();
        switch (bukkitVersion) {
            case "v1_19_R1":
                handler = new NMSImpl_1_19_2();
                break;
        }
        System.out.println("NMS Handler: " + handler.getRequiredNMSVersion());
    }
}
