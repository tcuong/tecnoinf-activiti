package edu.bedelias.utils;

public class SpringUtils {
	
	public static String convertToSpringName(String name) {
		StringBuilder springName = new StringBuilder(name.substring(0,1).toLowerCase() + name.substring(1));
		return springName.toString();
	}

}
