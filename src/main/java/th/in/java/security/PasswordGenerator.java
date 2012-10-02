/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.apache.log4j.Logger;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public final class PasswordGenerator {

    private static final Logger LOG = Logger.getLogger(PasswordGenerator.class.getName());

	private static final double CLASS_LETTER_AND_NUMBER_WEIGHT = 0.9;
	private static final double CLASS_LETTER_WEIGHT = 0.7;
	private static final int CLASS_LETTER = 0;
	private static final int CLASS_NUMBER = 1;
	private static final int CLASS_SYMBOL = 2;
	private static final char[] LETTERS_ALPHABET = { 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	private static final char[] NUMBERS_ALPHABET = { '0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9' };
	private static final char[] SYMBOLS_ALPHABET = { '!', '#', '$', '%', '&',
			'(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '?', '@',
			'[', '\\', ']', '^', '_', '`', '{', '|', '}', '~' };

	// Default here is 1024-bits of random goodness.
	private static final int DEFAULT_RANDOM_SIZE = 1024;

	private static final String SHA1_PRNG = "SHA1PRNG";

	private static SecureRandom secureRandom;

    private PasswordGenerator() { }

	private static SecureRandom getSecureRandom() {
		try {
			secureRandom = SecureRandom.getInstance(SHA1_PRNG);
		} catch (NoSuchAlgorithmException e) {
			LOG.error(e.getMessage(), e);
		}
		getNextSecureRandom(DEFAULT_RANDOM_SIZE);
		return secureRandom;
	}

	private static int selectCharacterClass() {

		// Get 1024-bits of secure random goodness.
		final double randomValue = getSecureRandom().nextDouble();
		if (randomValue < CLASS_LETTER_WEIGHT) {
			return CLASS_LETTER;
		}

		if (randomValue < CLASS_LETTER_AND_NUMBER_WEIGHT) {
			return CLASS_NUMBER;
		}

		return CLASS_SYMBOL;
	}

	public static byte[] getNextSecureRandom() {
		return getNextSecureRandom(DEFAULT_RANDOM_SIZE);
	}

	public static byte[] getNextSecureRandom(final int bits) {

		// Make sure the number of bits we're asking for is at least
		// divisible by 8.
		if ((bits % 8) != 0) {
			throw new IllegalArgumentException("Size is not divisible " + "by 8!");
		}

		// Usually 64-bits of randomness, 8 bytes
		final byte[] randBytes = new byte[bits / 8];

		// Get the next 64 random bits. Forces SecureRandom
		// to seed itself before returning the bytes.
		secureRandom.nextBytes(randBytes);

		return randBytes;

	}

	public static String generatePassword(final int passwordLength) {
		if (passwordLength <= 0) {
			throw new ArrayIndexOutOfBoundsException("Password length must be greater then 0");
		}

		final StringBuffer password = new StringBuffer();
		char[] charset;
		for (int iIndexL = 0; iIndexL < passwordLength; iIndexL++) {
			switch (selectCharacterClass()) {
				case CLASS_NUMBER:
					charset = NUMBERS_ALPHABET;
					break;

				case CLASS_SYMBOL:
					charset = SYMBOLS_ALPHABET;
					break;

				case CLASS_LETTER:
				default:
					charset = LETTERS_ALPHABET;
					break;
			}

			password.append(charset[getSecureRandom().nextInt(charset.length - 1)]);
		}

		return password.toString();
	}

}
