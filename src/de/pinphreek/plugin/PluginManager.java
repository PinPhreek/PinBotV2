package de.pinphreek.plugin;

import java.util.ArrayList;

public class PluginManager {
    ArrayList<Plugin> plugins = new ArrayList<>();

    public void addPlugin(Plugin plugin){plugins.add(plugin);} //adds a plugin to the list

    /**
     * This function is designed to get called while, from the Bot to spread the functionality to the plugins
     * @param channel the channel the message was entered in
     * @param sender who sended the message
     * @param login login
     * @param hostname the hostname
     * @param message the message, that was written
     * */
    public void revievedMessage(String channel, String sender, String login, String hostname, String message){
        for (Plugin p : plugins){
            p.recieveMessage(channel, sender, login, hostname, message);
        }
    }
}

