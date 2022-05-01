package com.app.hpx.jpa.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomDataGeneratorUtil {

	private static final String UID_SEQUENCE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final Long UID_LOWER_LIM = 9990000L;
	private static final Long UID_UPPER_LIM = 9999999L;

	private static final Integer LENGTH = 32;

	private static final Random RANDOM = new SecureRandom();

	public static Long generateRandomUidKey() {
		return UID_LOWER_LIM + (long) (Math.random() * (UID_UPPER_LIM - UID_LOWER_LIM));
	}

	public static String getRandomPlainTextKey() {
		return generateRandomPlainTextKey(LENGTH);
	}

	public static String getRandomPlainTextKey(int length) {
		if (length >= (LENGTH * 2)) {
			/*FIXME: implement proper application-level exception */
			throw new RuntimeException("Key length too long!");
		}
		return generateRandomPlainTextKey(length);
	}

	private static String generateRandomPlainTextKey(int length) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < length; i++) {
			builder.append(UID_SEQUENCE.charAt(RANDOM.nextInt(UID_SEQUENCE.length())));
		}

		return builder.toString();
	}
}
