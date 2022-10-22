package net.corail.nms.entity;

import net.corail.nms.Vector3;
import net.corail.nms.entity.events.NMSEntityCreateEvent;
import net.corail.nms.entity.events.NMSEntityDamageEvent;
import net.corail.nms.entity.events.NMSEntityDeathEvent;
import net.corail.nms.entity.events.NMSEntitySpawnEvent;
import org.bukkit.Location;

import java.util.List;

public interface NMSEntity {

    String getWorld();
    Vector3 getLocation();
    EntityTypes getEntityType();
    List<Location> getPathfinderLocations();
    void addPathfinderLocation(Location location);
    void clearPathfinderLocations();
    void onDeath(NMSEntityDeathEvent event);
    void onSpawn(NMSEntitySpawnEvent event);
    void onCreate(NMSEntityCreateEvent event);
    void onHit(NMSEntityDamageEvent event);

}
