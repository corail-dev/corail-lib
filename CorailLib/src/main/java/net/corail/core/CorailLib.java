package net.corail.core;

import net.corail.commands.BlockSetCommand;
import net.corail.nms.NMSHandler;
import net.corail.nms.ServerVersion;
import net.corail.nms_1_19_2.NMSImpl_1_19_2;
import org.bukkit.plugin.java.JavaPlugin;

public class CorailLib extends JavaPlugin {
    private NMSHandler handler;
    private BlockSetCommand command;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Detected Java Version: " + ServerVersion.getBukkitVersion());
        decideNMSHandler();

        this.command = new BlockSetCommand(this);
        getCommand("setblock").setExecutor(command);
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

    public NMSHandler getHandler() {
        return handler;
    }
}
