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
public class PasswordEncoderNGTest {

    @Test
    public void testEncode() throws Exception {
        final String saltKey_1 = "1234567890";
        final String saltKey_2 = "0000000000";

        final String password_1 = "4124;kdfasjflkasf";
        final String result_1 = PasswordEncoder.encode(password_1, saltKey_1);
        assertNotNull(result_1, "result_1 should not be null.");

        final String result_2 = PasswordEncoder.encode(password_1, saltKey_1);
        assertEquals(result_1, result_2, "result_1 should equals with result_2");

        final String password_3 = "jflfasfds34;kasf";
        final String result_3 = PasswordEncoder.encode(password_3, saltKey_1);
        assertNotEquals(result_1, result_3, "result_1 should not equals with result_3");

        final String result_4 = PasswordEncoder.encode(password_1, saltKey_2);
        assertNotEquals(result_1, result_4, "result_1 should not equals with result_4");
    }

    @Test
    public void testEncodePerf() throws Exception {
        final String saltKey_1 = "1234567890";
        final String password_1 = "4124;kdfasjflkasf";

        String result;
        for (int i=0; i<1000; i++) {
            result = PasswordEncoder.encode(password_1, saltKey_1);
        }

    }

}
