package edu.bedelias.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class SecUtils {

	/**
	 * Returns a safely hashed password using the BCrypt algorithm.
	 * @param rawString
	 * @return
	 */
	public static String hashPassword(String rawString) {
		return BCrypt.hashpw(rawString, BCrypt.gensalt());
	}
	
	/**
	 * Verifies if a given password matches its hashed value with BCrypt.
	 * @param plainText
	 * @param hashedPwd
	 * @return
	 */
	public static Boolean verifyPassword(String plainText, String hashedPwd) {
		return BCrypt.checkpw(plainText, hashedPwd);
	}
}
