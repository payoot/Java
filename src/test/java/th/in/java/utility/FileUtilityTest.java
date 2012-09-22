/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.in.java.utility;

import java.io.File;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author nuboat
 */
public class FileUtilityTest {

    @Test
    public void testGetFile() {
        final String[] fullname = {"Users", "nuboat"};
        final File expResult = new File("/Users/nuboat");
        final File result = FileUtility.getFile(fullname);
        assertEquals(expResult, result, "Path: /Users/nuboat");
    }

}
