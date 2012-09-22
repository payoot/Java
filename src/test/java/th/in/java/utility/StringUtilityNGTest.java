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
public class StringUtilityNGTest {

    @Test
    public void testIsEmpty() {
        final String string = "";
        final boolean expResult = true;
        final boolean result = StringUtility.isEmpty(string);
        assertEquals(result, expResult, "Validate empty string");
    }

    @Test
    public void testIsEmail1() {
        final String string = "nuboat@gmail.com";
        final boolean expResult = true;
        final boolean result = StringUtility.isEmail(string);
        assertEquals(result, expResult, "Validate Email");
    }

    @Test
    public void testIsEmail2() {
        final String string = "nuboat";
        final boolean expResult = false;
        final boolean result = StringUtility.isEmail(string);
        assertEquals(result, expResult, "Validate Email");
    }

    @Test
    public void testIsAlphabet1() {
        final String string = "ABC_104";
        final boolean expResult = true;
        final boolean result = StringUtility.isAlphabet(string);
        assertEquals(result, expResult, "Validate Alphabet");
    }

    @Test
    public void testIsAlphabet2() {
        final String string = "ABC_104--";
        final boolean expResult = false;
        final boolean result = StringUtility.isAlphabet(string);
        assertEquals(result, expResult, "Validate Alphabet");
    }

}
