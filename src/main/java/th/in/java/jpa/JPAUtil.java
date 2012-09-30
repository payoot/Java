/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public final class JPAUtil {

    private JPAUtil() { }

    /**
     *
     *
        <persistence-unit name="unitName" transaction-type="RESOURCE_LOCAL">
            <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
            <properties>
                <property name="eclipselink.jdbc.password" value=""/>
                <property name="eclipselink.jdbc.user" value="root"/>
                <property name="eclipselink.jdbc.driver" value="com.mysql.jdbc.Driver"/>
                <property name="eclipselink.jdbc.url" value="jdbc:mysql://localhost:3306/test"/>
                <property name="eclipselink.ddl-generation" value="drop-and-create-tables"/>
                <property name="eclipselink.logging.level" value="INFO"/>
            </properties>
        </persistence-unit>
     * ref; http://javahowto.blogspot.com/2008/10/helloworld-with-eclipselink-and-mysql.html
     */
    public static EntityManager getEntityManager(final String unitName) {
        return Persistence.createEntityManagerFactory(unitName).createEntityManager();
    }

}
