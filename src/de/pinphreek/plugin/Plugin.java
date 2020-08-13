package de.pinphreek.plugin;

public interface Plugin {
    public void run();
    public void stop();

    //sending and reciveing methods for twitch-chat
    //public String sendMessage(); //mayby calling that directly
    public void recieveMessage(String channel, String sender, String login, String hostname, String message);
}
