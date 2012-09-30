/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.security;

import java.util.logging.Level;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public final class Message {

    private Message() { }

    public static String preventLogForgingforLogger(final String message) {
        return message.replaceAll("\n", " ")
                .replaceAll("\r", " ")
                .replaceAll(Level.ALL.getName(), " ")
                .replaceAll(Level.CONFIG.getName(), " ")
                .replaceAll(Level.FINE.getName(), " ")
                .replaceAll(Level.FINER.getName(), " ")
                .replaceAll(Level.FINEST.getName(), " ")
                .replaceAll(Level.INFO.getName(), " ")
                .replaceAll(Level.OFF.getName(), " ")
                .replaceAll(Level.SEVERE.getName(), " ")
                .replaceAll(Level.WARNING.getName(), " ");
    }

}
