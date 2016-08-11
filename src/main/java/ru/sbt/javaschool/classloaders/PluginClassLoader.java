package ru.sbt.javaschool.classloaders;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Никита on 11.08.2016.
 */
public class PluginClassLoader extends URLClassLoader {

    public PluginClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("java") || name.contains("Plugin")) {
            return super.loadClass(name);
        }
        return findClass(name);
    }

}
