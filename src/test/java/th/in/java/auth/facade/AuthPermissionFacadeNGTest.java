/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.auth.facade;

import javax.persistence.EntityManager;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import th.in.java.auth.entity.AuthPermission;
import th.in.java.jpa.JPAUtil;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class AuthPermissionFacadeNGTest {

    @Test
    public void testCreate() {
        AuthPermission authPermission;
        AuthPermissionFacade instance;

        final EntityManager em = JPAUtil.getEntityManager("auth_unit");
        try {
            em.getTransaction().begin();

            authPermission = new AuthPermission();
            authPermission.setName("Admin");
            authPermission.setCodename("Admin");

            instance = new AuthPermissionFacade(em);
            instance.create(authPermission);

            em.getTransaction().commit();
        } catch (final Exception e) {
            em.getTransaction().rollback();
            fail(e.getMessage(), e);
        }

    }

}
