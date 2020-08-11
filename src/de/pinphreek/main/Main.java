package de.pinphreek.main;

import java.io.IOException;

import org.jibble.pircbot.IrcException;

import de.pinphreek.config.Config;
import de.pinphreek.io.Load;

public class Main {

	public static void main(String[] args) {
		
		//TODO load Plugins
		//start twitchbot (reading a config)
		try {
			Load.readConfigFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error while reading config-file!");
		}
		Bot bot = new Bot();
		bot.setVerbose(false);
		try {
			bot.connect("irc.twitch.tv", 6667, Config.API_KEY);
		} catch (IOException | IrcException e) {
			e.printStackTrace();
			System.err.println("Error connecting to twitch.\nABORTING");
			System.exit(-1);
		}
		bot.joinChannel("#" + Config.streamer);
		System.out.println("Debug");
		
		//Say hello
		bot.sendMessage("#" + bot.getName(), "Hello Chat!");
		
		//run plugins
		
		

	}

}
