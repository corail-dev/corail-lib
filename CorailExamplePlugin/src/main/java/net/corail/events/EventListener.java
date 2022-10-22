package net.corail.events;

import net.corail.api.CorailEventForwarder;
import net.corail.api.CorailPlugin;

public class EventListener extends CorailEventForwarder {

    public EventListener(CorailPlugin plugin) { super(plugin); }

    public void onExampleEvent(ExampleEvent event) {
        System.out.println("Event Has Been Called.");
    }

}
