/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.security;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class MessageNGTest {

    @Test
    public void testPreventLogForgingforLogger() {
        final String message = "INFO XXXXXX";
        final String expResult = "  XXXXXX";
        final String result = Message.preventLogForgingforLogger(message);
        assertEquals(result, expResult);
    }
}
