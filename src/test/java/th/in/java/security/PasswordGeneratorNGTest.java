/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.in.java.security;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author nuboat
 */
public class PasswordGeneratorNGTest {

    @Test
    public void testGeneratePassword() {
        final int passwordLength = 12;
        final String result = PasswordGenerator.generatePassword(passwordLength);
        assertEquals(result.length(), passwordLength);
    }
}
