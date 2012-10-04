/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.security;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.CharEncoding;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public final class PasswordEncoder {

    public static final String SHA256 = "SHA-256";

    private PasswordEncoder() { }

    /**
     *
     * @param password
     * @param saltKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String encode(final String password, final String saltKey)
	    throws NoSuchAlgorithmException, IOException {

        final Base64 base64 = new Base64();
        final MessageDigest digest = MessageDigest.getInstance(SHA256);

        digest.reset();
        digest.update(base64.decode(saltKey.getBytes()));

        byte[] btPass;
        btPass = digest.digest(password.getBytes(CharEncoding.UTF_8));
        digest.reset();
        btPass = digest.digest(btPass);
        digest.reset();
        btPass = digest.digest(btPass);
        digest.reset();
        btPass = digest.digest(btPass);
        digest.reset();
        btPass = digest.digest(btPass);
        digest.reset();
        btPass = digest.digest(btPass);

        return new String(base64.encode(btPass));
    }

}
