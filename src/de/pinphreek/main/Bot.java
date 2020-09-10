package de.pinphreek.main;

import org.jibble.pircbot.*;

import de.pinphreek.config.Config;
import de.pinphreek.io.Save;

public class Bot extends PircBot {

	public Bot() {
		this.setName(Config.name);
	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		System.out.println(sender + ": " + message);
		Main.pluginManager.revievedMessage(channel, sender, login, hostname, message); //pass that shit through
		
		//Points
		if(!message.startsWith("!")) {
			if(channel.equals(sender) && message.equalsIgnoreCase("!save")) {
				Save.saveToFile("users.txt", Main.users.get(0).toStringArray());
				for(de.pinphreek.users.User u : Main.users) {
					Save.appendToFile("users.txt", u.toStringArray());
				}
			}
			for(de.pinphreek.users.User u : Main.users) {
				if(u.getName().equals(sender)) {
					u.setPoints(u.getPoints() + message.length());
					return;
				}
			}
			Main.users.add(new de.pinphreek.users.User(sender, message.length()));
			this.sendMessage(channel, "Welcome @" + sender + " collect points for beeing here. You currently have " + Main.users.get(Main.users.size() - 1));
		}
	}
}
