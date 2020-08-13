package de.pinphreek.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jibble.pircbot.IrcException;

import de.pinphreek.config.Config;
import de.pinphreek.io.Load;

public class Main {

	public static Bot bot;
	
	public static void main(String[] args) {
		
		//TODO load Plugins
		//start twitchbot (reading a config)
		try {
			Load.readConfigFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error while reading config-file!");
		}
		
		
		bot = new Bot();
		bot.setVerbose(false);
		//connect to twitch
		try {
			bot.connect("irc.twitch.tv", 6667, Config.API_KEY);
		} catch (IOException | IrcException e) {
			e.printStackTrace();
			System.err.println("Error connecting to twitch.\nABORTING");
			System.exit(-1);
		}
		bot.joinChannel("#" + Config.streamer);
		System.out.println("Connected in channel " + Config.streamer + " as " + Config.name);
		
		//Say hello
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bot.sendMessage("#" + Config.streamer, "The holy bot " + Config.name + " entered the chat of " + Config.streamer);
		
		//start console input from bot
		while (true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				bot.sendMessage(Config.streamer, reader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		//TODO run plugins
		
		

	}

}
