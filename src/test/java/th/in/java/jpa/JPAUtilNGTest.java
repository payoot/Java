/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.jpa;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class JPAUtilNGTest {

    private static final Logger LOG = Logger.getLogger(JPAUtilNGTest.class.getName());

    @Test
    public void testGetEntityManager() {
        final EntityManager result = JPAUtil.getEntityManager("auth_unit");
        assertNotNull(result, "EntityManager should not be null.");

        final Query query = result.createNativeQuery("select now();");
        final Object obj = query.getSingleResult();

        LOG.info(obj.toString());
        assertNotNull(obj, "Object should not be null.");
    }

}
