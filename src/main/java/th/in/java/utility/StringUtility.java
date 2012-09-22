/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.utility;

import java.util.regex.Pattern;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public final class StringUtility {

    private StringUtility() {}

    public static boolean isEmpty(final String string) {
        return string == null || "".equals(string) ? true : false;
    }

	private static final String  EMAIL_PATTERN_STR = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_PATTERN_STR);
    public static boolean isEmail(final String string) {
        return EMAIL_PATTERN.matcher(string).matches();
    }

    private static final String  ALPHABET_PATTERN_STR = "^[a-zA-Z0-9_]+$";
    private static final Pattern ALPHABET_PATTERN = Pattern.compile(ALPHABET_PATTERN_STR);
    public static boolean isAlphabet(final String string) {
        return ALPHABET_PATTERN.matcher(string).matches();
    }

}
