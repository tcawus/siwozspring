package org.siwoz.util;

import java.util.Random;

public class TextGenerator {
	public static String generateString(String characters, int length) {
		Random rng = new Random();
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text).replaceAll("a", " ").replaceAll("e", " ")
				.replaceAll("o", " ");
	}
}
