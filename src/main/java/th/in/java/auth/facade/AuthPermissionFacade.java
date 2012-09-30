/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.auth.facade;

import javax.persistence.EntityManager;
import th.in.java.auth.entity.AuthPermission;
import th.in.java.jpa.AbstractFacade;
import th.in.java.jpa.JPAUtil;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class AuthPermissionFacade extends AbstractFacade<AuthPermission> {

    private transient EntityManager em;

    @Override
    protected String getUnitName() {
        return "";
    }

    @Override
    protected EntityManager getEntityManager() {
        if (this.em == null) {
            this.em = JPAUtil.getEntityManager(getUnitName());
        }
        return this.em;
    }

    public AuthPermissionFacade() {
        super(AuthPermission.class);
    }

    public AuthPermissionFacade(final EntityManager em) {
        super(AuthPermission.class);

        this.em = em;
    }

}
