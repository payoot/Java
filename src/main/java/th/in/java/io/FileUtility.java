/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.io;

import java.io.File;
import th.in.java.constant.StringConstant;
import th.in.java.utility.OsUtility;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public final class FileUtility {

    private FileUtility() {}

    public static File getFile(final String [] fullname) {
        StringBuilder path;

        int index = 0;
        if (OsUtility.isWindows()) {
            path = new StringBuilder(getSubPath(fullname[index++]));
            path.append(File.pathSeparator).append(File.separator);
        } else {
            path = new StringBuilder(File.separator);
        }

        for (int i = index; i<fullname.length; i++) {
            path.append(getSubPath(fullname[i])).append(File.separator);
        }
        return new File(path.toString());
    }

    private static String getSubPath(final String s) {
        return s.replace(File.separator, StringConstant.EMPTY)
                .replace(File.pathSeparator, StringConstant.EMPTY);
    }

}
