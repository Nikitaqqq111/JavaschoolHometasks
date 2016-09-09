package ru.sbt.javaschool.classloaders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Никита on 11.08.2016.
 */

public class EncryptedClassLoader extends ClassLoader {

    private final String key;

    private final File dir;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] byteArrayClazz = Files.readAllBytes(Paths.get(dir + "/" + name.replace('.', '/').concat(".class")));
            for (int i = 0; i < byteArrayClazz.length; i++) {
                byteArrayClazz[i] = (byte) (byteArrayClazz[i] + key.hashCode());
            }
            return defineClass(name, byteArrayClazz, 0, byteArrayClazz.length);
        } catch (IOException ex) {
            throw new RuntimeException("IOException from EncryptedClassLoader.findClass", ex);
        }
    }


}

