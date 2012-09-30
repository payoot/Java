/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.utility;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class OsUtilityNGTest {

    @Test
    public void testGetOsName() {
        final String expResult = "Mac OS X";
        final String result = OsUtility.getOsName();
        assertEquals(result, expResult, "OS Name");
    }

    @Test
    public void testIsWindows() {
        final boolean expResult = false;
        final boolean result = OsUtility.isWindows();
        assertEquals(result, expResult, "IS WINDOW");
    }

    @Test
    public void testIsUnix() {
        final boolean expResult = false;
        final boolean result = OsUtility.isUnix();
        assertEquals(result, expResult, "IS UNIX");
    }

    @Test
    public void testIsOSX() {
        final boolean expResult = true;
        final boolean result = OsUtility.isMaxOSX();
        assertEquals(result, expResult, "IS MAC OS X");
    }

}
