/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.auth.facade;

import javax.persistence.EntityManager;
import th.in.java.auth.entity.AuthUserUserPermissions;
import th.in.java.jpa.AbstractFacade;
import th.in.java.jpa.JPAUtil;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class AuthUserUserPermissionsFacade extends AbstractFacade<AuthUserUserPermissions> {

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

    public AuthUserUserPermissionsFacade() {
        super(AuthUserUserPermissions.class);
    }

    public AuthUserUserPermissionsFacade(final EntityManager em) {
        super(AuthUserUserPermissions.class);

        this.em = em;
    }

}
