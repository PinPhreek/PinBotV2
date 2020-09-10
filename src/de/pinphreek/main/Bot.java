package de.pinphreek.main;

import org.jibble.pircbot.*;

import de.pinphreek.config.Config;

public class Bot extends PircBot {

	public Bot() {
		this.setName(Config.name);
	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		System.out.println(sender + ": " + message);
		Main.pluginManager.revievedMessage(channel, sender, login, hostname, message); //pass that shit through
	}
}
