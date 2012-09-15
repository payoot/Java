/*
 * Free Licensed, For HOME & Biz
 */
package in.th.java;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class ThaiCurrency {
   private static final String TXTNUM[] = {"ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า"};
   private static final String TXTWEIGHT[] = {"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน"};

   private transient final String [] strval;

   public ThaiCurrency(String value)
           throws NumberFormatException {
       if (value == null) {
           throw new NumberFormatException("Null Value");
       }

       value = value.replaceAll(",", "");
       value = value.replaceAll(" ", "");

       if ("".equals(value)) {
           throw new NumberFormatException("Blank Value");
       }

       Double.parseDouble(value);

       if (value.charAt(0) == '.') {
           value = "0" + value;
       }

       if (value.charAt(value.length() - 1) == '.') {
           value += "0";
       }

       strval = value.split("[.]");

       if (strval.length > 2) {
           throw new NumberFormatException("ทศนิยมมากกว่า 1 ตัว");
       }
   }

   @Override
   public String toString() {
       final String beforeDot = strval[0];
       String afterDot  = strval.length == 2 ? strval[1] : null;

       final boolean beforeDotIsZero = isZero(beforeDot);
       final boolean afterDotIsZero  = afterDot == null || afterDot != null && isZero(afterDot);

       if (beforeDotIsZero && afterDotIsZero) {
           return "ศูนย์บาท";
       }

       final StringBuilder result = new StringBuilder();

       if (!beforeDotIsZero) {
           final String[] beforeDotArr = splitString(beforeDot);
           for (int i = 0; i < beforeDotArr.length; i++) {
               result.append(parseThaiWording(beforeDotArr[i]));
               result.append( i + 1 < beforeDotArr.length ? "ล้าน" : "บาท" );
           }
       }

       if (!afterDotIsZero) {
           if (afterDot.length() > 2) {
               afterDot = afterDot.substring(0, 2);
           }
           if (afterDot.length() == 1) {
               afterDot += "0";
           }

           final String[] afterDotArr = splitString(afterDot);
           for (int i = 0; i < afterDotArr.length; i++) {
               result.append(parseThaiWording(afterDotArr[i]));
               result.append(i + 1 < afterDotArr.length ? "ล้าน" : "สตางค์");
           }
       }
       return result.toString();
   }

   private boolean isZero(final String number) {
       return Integer.parseInt(number) == 0 ? true : false;
   }

   private String[] splitString(final String number) {
       final int n = number.length() % 6;
       final int sizeArr = number.length() / 6;

       final String []result = new String[n > 0 ? sizeArr+1 : sizeArr];

       if (n > 0) {
           result[0] = number.substring(0, n);
       }

       int indexString = n;
       for (int i=n>0?1:0; i<result.length; i++) {
           result[i] = number.substring(indexString, indexString + 6);
           indexString += 6;
       }

       return result;
   }

   @SuppressWarnings("empty-statement")
   private String parseThaiWording(final String number) {
       final StringBuilder result = new StringBuilder(0);
       final int length = number.length();

       char ch;
       for (int i = 0; i < length; i++) {
            ch = number.charAt(i);
            if (ch == '0') {
                continue;
            }
            if (i == (length - 1) && ch == '1' &&
                 (Integer.parseInt(number) % 100 > 10)) {
                 result.append("เอ็ด"); // ดัก เลข 1 ในกรณีที่มากกว่า 10 ให้แสดงเป็น เอ็ด
            } else if (i == (length - 2) && ch == '2') {
                 result.append("ยี่"); // ดักเลข 20 -> ยี่สิบ
            } else if (i == (length - 2) && ch == '1') {
                 ; // ดักเลข 10 -> สิบ ไม่ใช่ หนึ่งสิบ
            } else {
                 result.append(TXTNUM[((int) ch) - 48]);
            }
            result.append(TXTWEIGHT[length - i - 1]);
       }
       return result.toString();
   }

}
