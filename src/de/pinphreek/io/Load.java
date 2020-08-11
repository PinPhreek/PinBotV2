package de.pinphreek.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import de.pinphreek.config.Config;

public class Load {



	private static File cfgFile = new File("config.txt");;

	public static void readConfigFile() throws IOException {

		if (!cfgFile.exists()) {
			/**
			 * Creates a new File if not existing and writes default values to it.
			 */
			cfgFile.createNewFile();

			FileWriter w = new FileWriter(cfgFile);
			String s;
			if(System.getProperty("os.name").toLowerCase().contains("windows"))s = "\r\n";
			else s = "\n";
			w.write(Config.LABEL_API_KEY + ": " + s);
			w.write(Config.LABEL_NAME + ": " + s);
			w.write(Config.LABEL_STREAMER + ": " + s);
			w.flush();
			w.close();
			System.out.println("Config-file created successfully!\nPlease fill in the missing pieces!");
			System.exit(0);
		}

		Scanner sc = new Scanner(cfgFile);//to be replaced
		String s;

		while (sc.hasNextLine()) {

			s = sc.nextLine().replace(" ", "");
			if(s.isEmpty()) continue;
			if(s.toLowerCase().contains(Config.LABEL_API_KEY.toLowerCase())) {
				String[] str = s.split(":");
				Config.API_KEY = str[1] + ":" + str[2];
			}
			else if(s.toLowerCase().contains(Config.LABEL_NAME.toLowerCase())) {
				Config.name = s.split(":")[1];
			}
			else if(s.toLowerCase().contains(Config.LABEL_STREAMER.toLowerCase())) {
				Config.streamer = s.split(":")[1];
			}
			
		}
		sc.close();
	}
	public static void readConfigFile(String path) throws IOException {

		cfgFile = new File(path);
		
		if (!cfgFile.exists()) {
			/**
			 * Creates a new File if not existing and writes default values to it.
			 */
			cfgFile.createNewFile();

			FileWriter w = new FileWriter(cfgFile);
			String s;
			if(System.getProperty("os.name").toLowerCase().contains("windows"))s = "\r\n";
			else s = "\n";
			w.write(Config.LABEL_API_KEY + ": " + s);
			w.write(Config.LABEL_NAME + ": " + s);
			w.write(Config.LABEL_STREAMER + ": " + s);
			w.flush();
			w.close();
			System.out.println("Config-file created successfully!\nPlease fill in the missing pieces!");
			System.exit(0);
		}

		Scanner sc = new Scanner(cfgFile);//to be replaced
		String s;

		while (sc.hasNextLine()) {

			s = sc.nextLine().replace(" ", "");
			if(s.isEmpty()) continue;
			if(s.toLowerCase().contains(Config.LABEL_API_KEY.toLowerCase())) {
				String[] str = s.split(":");
				Config.API_KEY = str[1] + ":" + str[2];
			}
			else if(s.toLowerCase().contains(Config.LABEL_NAME.toLowerCase())) {
				Config.name = s.split(":")[1];
				System.out.println("Name: " + Config.name);
			}
			else if(s.toLowerCase().contains(Config.LABEL_STREAMER.toLowerCase())) {
				Config.streamer = s.split(":")[1];
			}
		}
		sc.close();
	}
}