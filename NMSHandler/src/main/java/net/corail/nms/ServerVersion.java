package net.corail.nms;

import org.bukkit.Bukkit;

public class ServerVersion {

    public static String getBukkitVersion() {
        String name = Bukkit.getServer().getClass().getPackage().getName();
        return name.substring(name.lastIndexOf('.') + 1);
    }

}
