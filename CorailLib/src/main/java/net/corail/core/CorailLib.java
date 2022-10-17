package net.corail.core;

import net.corail.nms.ServerVersion;
import org.bukkit.plugin.java.JavaPlugin;

public class CorailLib extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Detected Java Version: " + ServerVersion.getBukkitVersion());
    }
}
