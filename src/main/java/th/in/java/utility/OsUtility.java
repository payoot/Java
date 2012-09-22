/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.utility;

import java.util.Locale;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public final class OsUtility {

    private static final String OS_NAME;
    private static final boolean IS_WINDOW;
    private static final boolean IS_NIX;
    private static final boolean IS_OSX;
    private static final boolean IS_SOLARIS;

    private OsUtility() {}

    static {
        OS_NAME = System.getProperty("os.name");

        final String osName = OS_NAME.toLowerCase(Locale.ENGLISH);
        IS_WINDOW = osName.startsWith("windows");
        IS_NIX = osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0;
        IS_OSX = osName.indexOf("mac") >= 0;
        IS_SOLARIS = osName.indexOf("sunos") >= 0;
    }

    public static String getOsName() {
        return OS_NAME;
    }

    public static boolean isWindows() {
        return IS_WINDOW;
    }

    public static boolean isUnix() {
        return IS_NIX;
    }

    public static boolean isMaxOSX() {
        return IS_OSX;
    }

    public static boolean isSolaris() {
        return IS_SOLARIS;
    }

}
