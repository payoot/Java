/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.io;

import java.io.File;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import th.in.java.utility.OsUtility;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class FileUtilityNGTest {

    @Test
    public void testGetFile() {

        if (OsUtility.isWindows()) {
            final String[] fullname = {"Users", "nuboat"};
            final File expResult = new File("/Users/nuboat");
            final File result = FileUtility.getFile(fullname);
            assertEquals(expResult, result, "Path: /Users/nuboat");
        } else {
            final String[] fullname = {"User", "nuboat"};
            final File expResult = new File("/User/nuboat");
            final File result = FileUtility.getFile(fullname);
            assertEquals(expResult, result, "Path: /User/nuboat");
        }
    }

}
