package de.pinphreek.plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader {

    public static Class<?> loadClass(String dir, String config) throws IOException, ClassNotFoundException {
        return loadClass(new File(dir), config);
    }
    public static Class<?> loadClass(File dir, String config) throws IOException, ClassNotFoundException {

        JarFile jf = new JarFile(dir);
        JarEntry je = jf.getJarEntry(config);

        BufferedReader br = new BufferedReader(new InputStreamReader(jf.getInputStream(je)));
        String in;

        HashMap<String, String> data = new HashMap<>();

        while((in = br.readLine())!=null){
            if (in.isEmpty() || in.startsWith("#"))continue;
            data.put(in.split(" ")[0], in.split(" ")[1]);
        }
        return Class.forName(data.get("Main"), true, new URLClassLoader(new URL[]{dir.toURI().toURL()}));
    }
    public static Class<?>[] loadDirectory(String dir, String config) throws IOException, ClassNotFoundException{
        return loadDirectory(new File(dir), config);
    }
    public static Class<?>[] loadDirectory(File dir, String config) throws IOException, ClassNotFoundException {
        File[] files = dir.listFiles();
        //TODO implement check for jar files

        Class<?>[] classes = new Class<?>[files.length];
        for (int i = 0; i < files.length; i++) {
            classes[i] = loadClass(files[i], config);
        }
        return classes;
    }
    public static Plugin initAsPlugin(Class<?> group) throws IllegalAccessException, InstantiationException {

        return (Plugin) group.newInstance();

    }
    public static Plugin[] initAsPlugin(Class<?>[] group) throws InstantiationException, IllegalAccessException {

        Plugin[] plugins = new Plugin[group.length];
        for (int i = 0; i < group.length; i++) {
            plugins[i] = initAsPlugin(group[i]);
        }
        return plugins;
    }
}
