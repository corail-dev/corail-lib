package net.corail.api;

import net.corail.core.CorailLib;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CorailEventForwarder {

    public CorailEventForwarder(CorailPlugin plugin) {
        System.out.println("Event Forwarder Has Been Loaded and Registered.");
        JavaPlugin.getPlugin(CorailLib.class).getForwarders().add(this);
    }

}
