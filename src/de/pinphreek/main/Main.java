package de.pinphreek.main;

import java.io.IOException;

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
		//Say hello
		//run plugins
		
		

	}

}
