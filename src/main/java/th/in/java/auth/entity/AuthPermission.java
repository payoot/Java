/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.auth.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
@Entity
@Table(name = "auth_permission", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"content_type_id", "codename"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthPermission.findAll", query = "SELECT a FROM AuthPermission a"),
    @NamedQuery(name = "AuthPermission.findById", query = "SELECT a FROM AuthPermission a WHERE a.id = :id"),
    @NamedQuery(name = "AuthPermission.findByName", query = "SELECT a FROM AuthPermission a WHERE a.name = :name"),
    @NamedQuery(name = "AuthPermission.findByCodename", query = "SELECT a FROM AuthPermission a WHERE a.codename = :codename")})
public class AuthPermission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String codename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionId")
    private List<AuthUserUserPermissions> authUserUserPermissionsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionId")
    private List<AuthGroupPermissions> authGroupPermissionsList;

    public AuthPermission() { }

    public AuthPermission(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(final String codename) {
        this.codename = codename;
    }

    @XmlTransient
    public List<AuthUserUserPermissions> getAuthUserUserPermissionsList() {
        return authUserUserPermissionsList;
    }

    public void setAuthUserUserPermissionsList(final List<AuthUserUserPermissions> authUserUserPermissionsList) {
        this.authUserUserPermissionsList = authUserUserPermissionsList;
    }

    @XmlTransient
    public List<AuthGroupPermissions> getAuthGroupPermissionsList() {
        return authGroupPermissionsList;
    }

    public void setAuthGroupPermissionsList(final List<AuthGroupPermissions> authGroupPermissionsList) {
        this.authGroupPermissionsList = authGroupPermissionsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof AuthPermission)) {
            return false;
        }
        final AuthPermission other = (AuthPermission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthPermission[ id=" + id + " ]";
    }

}
