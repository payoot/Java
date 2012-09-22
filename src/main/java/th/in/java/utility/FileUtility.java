/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.utility;

import java.io.File;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public final class FileUtility {

    private FileUtility() {}

    public static File getFile(final String [] fullname) {
        final StringBuilder path = new StringBuilder("/");
        for (String s : fullname) {
            path.append(s).append(File.separator);
        }
        return new File(path.toString());
    }

}
