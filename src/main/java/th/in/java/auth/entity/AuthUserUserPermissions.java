/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.auth.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
@Entity
@Table(name = "auth_user_user_permissions", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "permission_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthUserUserPermissions.findAll", query = "SELECT a FROM AuthUserUserPermissions a"),
    @NamedQuery(name = "AuthUserUserPermissions.findById", query = "SELECT a FROM AuthUserUserPermissions a WHERE a.id = :id")})
public class AuthUserUserPermissions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AuthUser userId;
    @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AuthPermission permissionId;

    public AuthUserUserPermissions() { }

    public AuthUserUserPermissions(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public AuthUser getUserId() {
        return userId;
    }

    public void setUserId(final AuthUser userId) {
        this.userId = userId;
    }

    public AuthPermission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(final AuthPermission permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof AuthUserUserPermissions)) {
            return false;
        }
        final AuthUserUserPermissions other = (AuthUserUserPermissions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthUserUserPermissions[ id=" + id + " ]";
    }

}
