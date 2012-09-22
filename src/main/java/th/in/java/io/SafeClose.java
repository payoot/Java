/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.io;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public final class SafeClose {

    private static final Logger LOG = Logger.getLogger(SafeClose.class.getName());

    private SafeClose() {}

    public static void close(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch(final IOException ioe) {
            LOG.severe(ioe.getMessage());
        }
    }

}
