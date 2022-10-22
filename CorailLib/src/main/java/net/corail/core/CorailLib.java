package net.corail.core;

import net.corail.api.CorailEventForwarder;
import net.corail.commands.BlockSetCommand;
import net.corail.commands.FindBlockTestCommand;
import net.corail.loader.JavaPluginLoader;
import net.corail.nms.NMSHandler;
import net.corail.nms.ServerVersion;
import net.corail.nms_1_19_2.NMSImpl_1_19_2;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class CorailLib extends JavaPlugin {
    private NMSHandler handler;
    private BlockSetCommand command;
    private FindBlockTestCommand findBlockTestCommand;
    private JavaPluginLoader loader;
    private List<Class> eventTypes = new ArrayList<>();
    private List<CorailEventForwarder> forwarders = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Detected Java Version: " + ServerVersion.getBukkitVersion());
        decideNMSHandler();

        this.command = new BlockSetCommand(this);
        getCommand("setblock").setExecutor(command);
        this.findBlockTestCommand = new FindBlockTestCommand(this);
        getCommand("findblocktest").setExecutor(findBlockTestCommand);

        // Custom pluginloader, stripped down from Bukkit for performance.
        this.loader = new JavaPluginLoader();
    }

    @Override
    public void onDisable() {
        // Properly handle the internal plugin handler shutdown.
        this.loader.unload();
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
    public JavaPluginLoader getLoader() {
        return loader;
    }
    public List<Class> getEventTypes() {
        return eventTypes;
    }
    public List<CorailEventForwarder> getForwarders() {
        return forwarders;
    }

}
