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
public class PasswordGeneratorNGTest {

    @Test
    public void testGeneratePassword() {
        final int passwordLength = 12;
        final String result = PasswordGenerator.generatePassword(passwordLength);
        System.out.println("Random: " + result);
        assertEquals(result.length(), passwordLength);
    }

    @Test
    public void testGeneratePasswordPerformance() throws Exception {
        final int passwordLength = 12;

        String result;
        final Long start = System.currentTimeMillis();
        for (int i=0; i<1000; i++) {
            result = PasswordGenerator.generatePassword(passwordLength);
        }
        final Long finish = System.currentTimeMillis();
        System.out.println("Execution time: " + (finish-start) + " ms.");
    }

}
