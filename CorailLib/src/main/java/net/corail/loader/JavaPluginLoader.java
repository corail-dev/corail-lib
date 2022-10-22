package net.corail.loader;

import net.corail.api.CorailEventForwarder;
import net.corail.api.CorailPlugin;
import net.corail.core.CorailLib;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JavaPluginLoader {

    private List<CorailPlugin> pluginCache;

    public JavaPluginLoader() {
        pluginCache = new ArrayList<>();
        String baseDir =JavaPlugin.getProvidingPlugin(getClass()).getDataFolder().getAbsolutePath().replace("plugins\\CorailLib", "");
        File baseServerDirectory = new File(baseDir);
        for (File file : Objects.requireNonNull(baseServerDirectory.listFiles())) {
            if (file.getName().endsWith(".jar")) {
                JarFile jarFile = null;
                //Load the jarfile and get the "versions.json" file from the base dir.
                try {
                    jarFile = new JarFile(file);
                    if (jarFile.getEntry("version.json") != null) {
                        URL fileURL = file.toURI().toURL();
                        File pluginDir = new File(baseDir + "\\corail_plugins\\");

                        if (!pluginDir.exists()) {
                            pluginDir.mkdir();
                        }

                        for (File f : Objects.requireNonNull(pluginDir.listFiles())) {
                            System.out.println("jar:" + fileURL +"!/");
                            URL[] urls = { new URL("jar:file:" + f.getAbsolutePath() + "!/") };
                            URLClassLoader cl = URLClassLoader.newInstance(urls, getClass().getClassLoader());
                            JarFile jar = new JarFile(f);
                            Enumeration<JarEntry> e = jar.entries();
                            while (e.hasMoreElements()) {
                                JarEntry je = e.nextElement();
                                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                                    continue;
                                }

                                String className = je.getName().substring(0, je.getName().length() - 6);
                                className = className.replace('/', '.');
                                Class c = cl.loadClass(className);

                                // Get the interfaces the class imports if it imports any
                                Class[] interfaces = c.getInterfaces();
                                if (interfaces.length > 0) {
                                    for (Class i : interfaces) {
                                        // Check if the interface is a CorailPlugin
                                        if (i.getName().equals("net.corail.api.CorailPlugin")) {
                                            //Instantiate the class in a non-deprecated way
                                            CorailPlugin plugin = (CorailPlugin) c.getDeclaredConstructor().newInstance();
                                            plugin.onClassLoaderProc(this);
                                            plugin.load(JavaPlugin.getPlugin(CorailLib.class));
                                            pluginCache.add(plugin);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<CorailPlugin> getPluginCache() {
        return pluginCache;
    }

    public void unload() {
        for (CorailPlugin plugin : getPluginCache()) {
            plugin.onUnload(JavaPlugin.getPlugin(CorailLib.class));
        }
    }

    public void callEvent(Object event) throws InvocationTargetException, IllegalAccessException {
        for (CorailEventForwarder forwarder : JavaPlugin.getPlugin(CorailLib.class).getForwarders()) {
            for (Method method : forwarder.getClass().getMethods()) {
                //If method has arguments of the event type, call the event method with the event as the first arg.
                if (method.getParameterCount() > 0) {
                    System.out.println(method.getParameterTypes()[0].getSimpleName());
                    if (method.getParameterTypes()[0].getSimpleName().equalsIgnoreCase(event.getClass().getSimpleName())) {
                        System.out.println("Found Valid Method Listener");
                        method.invoke(this, event);
                    }
                }
            }
        }
    }

}
