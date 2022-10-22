package net.corail.api;

import net.corail.core.CorailLib;
import org.bukkit.plugin.java.JavaPlugin;

public interface CorailEvent {

    default void register(CorailPlugin plugin) {
        JavaPlugin.getPlugin(CorailLib.class).getEventTypes().add(getClass());
    }

    default void unregister(CorailPlugin plugin) {
        JavaPlugin.getPlugin(CorailLib.class).getEventTypes().remove(getClass());
    }

}
