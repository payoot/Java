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
@Table(name = "auth_group", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthGroup.findAll", query = "SELECT a FROM AuthGroup a"),
    @NamedQuery(name = "AuthGroup.findById", query = "SELECT a FROM AuthGroup a WHERE a.id = :id"),
    @NamedQuery(name = "AuthGroup.findByName", query = "SELECT a FROM AuthGroup a WHERE a.name = :name")})
public class AuthGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private List<AuthGroupPermissions> authGroupPermissionsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private List<AuthUserGroups> authUserGroupsList;

    public AuthGroup() { }

    public AuthGroup(final Integer id) {
        this.id = id;
    }

    public AuthGroup(final Integer id, final String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public List<AuthGroupPermissions> getAuthGroupPermissionsList() {
        return authGroupPermissionsList;
    }

    public void setAuthGroupPermissionsList(final List<AuthGroupPermissions> authGroupPermissionsList) {
        this.authGroupPermissionsList = authGroupPermissionsList;
    }

    @XmlTransient
    public List<AuthUserGroups> getAuthUserGroupsList() {
        return authUserGroupsList;
    }

    public void setAuthUserGroupsList(final List<AuthUserGroups> authUserGroupsList) {
        this.authUserGroupsList = authUserGroupsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof AuthGroup)) {
            return false;
        }
        final AuthGroup other = (AuthGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthGroup[ id=" + id + " ]";
    }

}
