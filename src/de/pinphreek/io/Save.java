package de.pinphreek.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.pinphreek.config.Config;

public class Save {

	public static void saveToFile(String path, String data[]) {
		try {
			FileWriter w = new FileWriter(new File(path));
			for(String s : data) {
				w.write(s + getReturnCharacter());
			}
			w.flush();
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void appendToFile(String path, String data[]) {
		try {
			FileWriter w = new FileWriter(new File(path));
			for(String s : data) {
				w.append(s + getReturnCharacter());
			}
			w.flush();
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static String getReturnCharacter() {
		if(Config.os.contains("Linux")) {
			return "\n";
		}
		else if(Config.os.contains("Windows")) {
			return  "\r\n";
		}
		return "";
	}
	
}
