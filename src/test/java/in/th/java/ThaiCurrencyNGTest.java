/*
 * Free Licensed, For HOME & Biz
 */
package in.th.java;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author nuboat
 */
public class ThaiCurrencyNGTest {

    @Test
    public void testGetBaht10() {
        final ThaiCurrency currency1 = new ThaiCurrency("10");
        final String result = currency1.toString();
        assertEquals(result, "สิบบาท", "Normal data Error : 10");
    }

    @Test
    public void testGetBaht21() {
        final ThaiCurrency currency1 = new ThaiCurrency("21");
        final String result = currency1.toString();
        assertEquals(result, "ยี่สิบเอ็ดบาท", "Normal data Error : 21");
    }

    @Test
    public void testGetBahtmorethanMillion1() {
        final ThaiCurrency currency1 = new ThaiCurrency("35,000,000");
        final String result = currency1.toString();
        assertEquals(result, "สามสิบห้าล้านบาท", "More than million error : 35,000,000");
    }

    @Test
    public void testGetBahtmorethanMillion2() {
        final ThaiCurrency currency1 = new ThaiCurrency("35,000,001.50");
        final String result = currency1.toString();
        System.out.println(result);
        assertEquals(result, "สามสิบห้าล้านหนึ่งบาทห้าสิบสตางค์", "More than million error : 35,000,001.50");
    }

    @Test
    public void testGetBahtwithSuffix1() {
        final ThaiCurrency currency1 = new ThaiCurrency("21.50");
        final String result = currency1.toString();
        assertEquals(result, "ยี่สิบเอ็ดบาทห้าสิบสตางค์", "Not Integer error : 21.50");
    }

    @Test
    public void testGetBahtwithSuffix2() {
        final ThaiCurrency currency1 = new ThaiCurrency("21.5");
        final String result = currency1.toString();
        assertEquals(result, "ยี่สิบเอ็ดบาทห้าสิบสตางค์", "Not Integer error : 21.5");
    }

    @Test
    public void testGetBahtwithSuffix3() {
        final ThaiCurrency currency1 = new ThaiCurrency("21.505");
        final String result = currency1.toString();
        assertEquals(result, "ยี่สิบเอ็ดบาทห้าสิบสตางค์", "Not Integer error : 21.505");
    }

}
