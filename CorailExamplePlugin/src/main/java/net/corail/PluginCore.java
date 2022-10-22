package net.corail;

import net.corail.api.CorailPlugin;
import net.corail.core.CorailLib;
import net.corail.events.EventListener;
import net.corail.events.ExampleEvent;
import net.corail.loader.JavaPluginLoader;

public class PluginCore implements CorailPlugin {

    private EventListener listener;
    private JavaPluginLoader loader;

    @Override
    public void load(CorailLib core) {
        System.out.println("Plugin Has Been Loaded.");
        this.listener = new EventListener();

        ExampleEvent event = new ExampleEvent();
        event.register(this);

        try {
            loader.callEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUnload(CorailLib core) {
        System.out.println("Plugin Has Been Unloaded.");
    }

    @Override
    public void onClassLoaderProc(JavaPluginLoader loader) {
        System.out.println("ClassLoader Has Been Procced.");
        this.loader = loader;
    }

}