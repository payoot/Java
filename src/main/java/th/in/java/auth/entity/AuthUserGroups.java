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
@Table(name = "auth_user_groups", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "group_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthUserGroups.findAll", query = "SELECT a FROM AuthUserGroups a"),
    @NamedQuery(name = "AuthUserGroups.findById", query = "SELECT a FROM AuthUserGroups a WHERE a.id = :id")})
public class AuthUserGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AuthUser userId;
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AuthGroup groupId;

    public AuthUserGroups() { }

    public AuthUserGroups(final Integer id) {
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
        if (!(object instanceof AuthUserGroups)) {
            return false;
        }
        final AuthUserGroups other = (AuthUserGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthUserGroups[ id=" + id + " ]";
    }

}
