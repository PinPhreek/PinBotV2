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
			w.flush();
			w.close();
			System.out.println("Config-file created successfully!\nPlease fill in the missing peaces!");
			System.exit(0);
		}

		Scanner sc = new Scanner(cfgFile);//to be replaced
		String s;

		while (sc.hasNextLine()) {

			s = sc.nextLine().replace(" ", "").replace("_", " ");
			if(s.isEmpty()) continue;
			if(s.toLowerCase().contains(Config.LABEL_API_KEY.toLowerCase())) {
				Config.API_KEY = s;
			}
			else if(s.toLowerCase().contains(Config.LABEL_NAME.toLowerCase())) {
				Config.name = s;
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
			w.flush();
			w.close();
			System.out.println("Config-file created successfully!\nPlease fill in the missing peaces!");
			System.exit(0);
		}

		Scanner sc = new Scanner(cfgFile);//to be replaced
		String s;

		while (sc.hasNextLine()) {

			s = sc.nextLine().replace(" ", "").replace("_", " ");
			if(s.isEmpty()) continue;
			if(s.toLowerCase().contains(Config.LABEL_API_KEY.toLowerCase())) {
				Config.API_KEY = s;
			}
			else if(s.toLowerCase().contains(Config.LABEL_NAME.toLowerCase())) {
				Config.name = s;
			}
			
		}
		sc.close();
	}
}