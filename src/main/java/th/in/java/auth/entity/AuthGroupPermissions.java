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
@Table(name = "auth_group_permissions", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"group_id", "permission_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthGroupPermissions.findAll", query = "SELECT a FROM AuthGroupPermissions a"),
    @NamedQuery(name = "AuthGroupPermissions.findById", query = "SELECT a FROM AuthGroupPermissions a WHERE a.id = :id")})
public class AuthGroupPermissions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AuthPermission permissionId;
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AuthGroup groupId;

    public AuthGroupPermissions() { }

    public AuthGroupPermissions(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public AuthPermission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(final AuthPermission permissionId) {
        this.permissionId = permissionId;
    }

    public AuthGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(final AuthGroup groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof AuthGroupPermissions)) {
            return false;
        }
        final AuthGroupPermissions other = (AuthGroupPermissions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthGroupPermissions[ id=" + id + " ]";
    }

}
