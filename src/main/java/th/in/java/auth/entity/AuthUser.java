/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.auth.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
@Entity
@Table(name = "auth_user", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthUser.findAll", query = "SELECT a FROM AuthUser a"),
    @NamedQuery(name = "AuthUser.findById", query = "SELECT a FROM AuthUser a WHERE a.id = :id"),
    @NamedQuery(name = "AuthUser.findByUsername", query = "SELECT a FROM AuthUser a WHERE a.username = :username"),
    @NamedQuery(name = "AuthUser.findByFirstName", query = "SELECT a FROM AuthUser a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "AuthUser.findByLastName", query = "SELECT a FROM AuthUser a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "AuthUser.findByEmail", query = "SELECT a FROM AuthUser a WHERE a.email = :email"),
    @NamedQuery(name = "AuthUser.findByPassword", query = "SELECT a FROM AuthUser a WHERE a.password = :password"),
    @NamedQuery(name = "AuthUser.findByIsStaff", query = "SELECT a FROM AuthUser a WHERE a.isStaff = :isStaff"),
    @NamedQuery(name = "AuthUser.findByIsActive", query = "SELECT a FROM AuthUser a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "AuthUser.findByIsSuperuser", query = "SELECT a FROM AuthUser a WHERE a.isSuperuser = :isSuperuser"),
    @NamedQuery(name = "AuthUser.findByLastLogin", query = "SELECT a FROM AuthUser a WHERE a.lastLogin = :lastLogin"),
    @NamedQuery(name = "AuthUser.findByDateJoined", query = "SELECT a FROM AuthUser a WHERE a.dateJoined = :dateJoined")})
public class AuthUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String username;
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;
    @Basic(optional = false)
    @Column(nullable = false, length = 75)
    private String email;
    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String password;
    @Basic(optional = false)
    @Column(name = "is_staff", nullable = false)
    private boolean isStaff;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "is_superuser", nullable = false)
    private boolean isSuperuser;
    @Basic(optional = false)
    @Column(name = "last_login", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Basic(optional = false)
    @Column(name = "date_joined", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateJoined;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<AuthUserUserPermissions> authUserUserPermissionsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<AuthUserGroups> authUserGroupsList;

    public AuthUser() { }

    public AuthUser(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public void setIsStaff(final boolean isStaff) {
        this.isStaff = isStaff;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(final boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(final boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(final Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(final Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    @XmlTransient
    public List<AuthUserUserPermissions> getAuthUserUserPermissionsList() {
        return authUserUserPermissionsList;
    }

    public void setAuthUserUserPermissionsList(final List<AuthUserUserPermissions> authUserUserPermissionsList) {
        this.authUserUserPermissionsList = authUserUserPermissionsList;
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
        if (!(object instanceof AuthUser)) {
            return false;
        }
        final AuthUser other = (AuthUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthUser[ id=" + id + " ]";
    }

}
