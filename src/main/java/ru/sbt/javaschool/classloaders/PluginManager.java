package ru.sbt.javaschool.classloaders;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Никита on 11.08.2016.
 */
public class PluginManager {

    //Все PluginImpl обязаны реализовывать ru.sbt.javaschool.classloaders.Plugin
    private final static String PLUGIN_SYSTEM_INTERFACE = "ru.sbt.javaschool.classloaders.Plugin";

    private final String pluginRootDirectory;

    static {
        try {
            PluginManager.class.getClassLoader().loadClass(PLUGIN_SYSTEM_INTERFACE);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Interface Plugin not found", ex);
        }
    }

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return (Plugin) new PluginClassLoader(new URL[]{new URL(pluginRootDirectory + pluginName)}).loadClass(pluginClassName).newInstance();
    }

}

