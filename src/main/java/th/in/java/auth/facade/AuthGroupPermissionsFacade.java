/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.auth.facade;

import javax.persistence.EntityManager;
import th.in.java.auth.entity.AuthGroupPermissions;
import th.in.java.jpa.AbstractFacade;
import th.in.java.jpa.JPAUtil;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class AuthGroupPermissionsFacade extends AbstractFacade<AuthGroupPermissions> {

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

    public AuthGroupPermissionsFacade() {
        super(AuthGroupPermissions.class);
    }

    public AuthGroupPermissionsFacade(final EntityManager em) {
        super(AuthGroupPermissions.class);

        this.em = em;
    }

}
