package de.pinphreek.users;

import java.util.ArrayList;

public class User {

	private String name = null;
	private int points = 0;
	
	public User(String name, int points) {
		this.name = name;
		this.points = points;
	}
	public User() {};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	public String[] toStringArray() {
		ArrayList<String> ret = new ArrayList<>();
		ret.add(NAME + ":" + this.name);
		ret.add(POINTS + ":" + this.points);
		ret.add(SEPARATOR);
		return (String[]) ret.toArray();
	}
	public static final String NAME = "NAME";
	public static final String POINTS = "POINTS";
	public static final String SEPARATOR = "----";
}
