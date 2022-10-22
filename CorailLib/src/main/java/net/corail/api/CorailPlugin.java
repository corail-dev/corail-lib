package net.corail.api;

import net.corail.core.CorailLib;
import net.corail.loader.JavaPluginLoader;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public interface CorailPlugin {

    static CorailPlugin getCorailPlugin(Class clazz) {
        CorailLib lib = JavaPlugin.getPlugin(CorailLib.class);
        List<CorailPlugin> registered = lib.getLoader().getPluginCache();
        for (CorailPlugin plugin : registered) {
            if (plugin.getClass().equals(clazz)) {
                return plugin;
            }
        }
        return null;
    }

    default JavaPluginLoader getLoader() {
        return JavaPlugin.getPlugin(CorailLib.class).getLoader();
    }

    void load(CorailLib core);
    void onUnload(CorailLib core);
    void onClassLoaderProc(JavaPluginLoader loader);

}
