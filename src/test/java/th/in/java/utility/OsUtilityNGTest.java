/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.in.java.utility;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author nuboat
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
        final boolean expResult = true;
        final boolean result = OsUtility.isUnix();
        assertEquals(result, expResult, "IS UNIX");
    }

}
