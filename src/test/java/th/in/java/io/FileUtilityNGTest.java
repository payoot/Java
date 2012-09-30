/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.io;

import java.io.File;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class FileUtilityNGTest {

    @Test
    public void testGetFile() {
        final String[] fullname = {"Users", "nuboat"};
        final File expResult = new File("/Users/nuboat");
        final File result = FileUtility.getFile(fullname);
        assertEquals(expResult, result, "Path: /Users/nuboat");
    }

}
