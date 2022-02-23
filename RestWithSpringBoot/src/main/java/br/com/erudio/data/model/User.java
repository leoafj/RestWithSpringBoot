package br.com.erudio.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class User implements UserDetails, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "user_name", unique = true)
	private String userName;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "account_non_expired")
	private Boolean AccountNonExpired;
	
	@Column(name = "account_non_locked")
	private Boolean AccountNonLocked;
	
	@Column(name = "credentials_non_expired")
	private Boolean CredentialsNonExpired;
	
	@Column(name = "enabled")
	private Boolean Enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_permission", joinColumns = {@JoinColumn (name = "id_user")},
			inverseJoinColumns = {@JoinColumn (name = "id_permission")})
	private List<Permission> permissions;
	
	public List<String> getRoles() {
		List<String> roles = new ArrayList<>();
		for (Permission permission : this.permissions) {
			roles.add(permission.getDescription());
		}
		return roles;
		
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissions;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.CredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.Enabled;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Boolean getAccountNonExpired() {
		return AccountNonExpired;
	}


	public void setAccountNonExpired(Boolean accountNonExpired) {
		AccountNonExpired = accountNonExpired;
	}


	public Boolean getAccountNonLocked() {
		return AccountNonLocked;
	}


	public void setAccountNonLocked(Boolean accountNonLocked) {
		AccountNonLocked = accountNonLocked;
	}


	public Boolean getCredentialsNonExpired() {
		return CredentialsNonExpired;
	}


	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		CredentialsNonExpired = credentialsNonExpired;
	}


	public Boolean getEnabled() {
		return Enabled;
	}


	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}


	public List<Permission> getPermissions() {
		return permissions;
	}


	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int hashCode() {
		return Objects.hash(AccountNonExpired, AccountNonLocked, CredentialsNonExpired, Enabled, fullName, id, password,
				permissions, userName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(AccountNonExpired, other.AccountNonExpired)
				&& Objects.equals(AccountNonLocked, other.AccountNonLocked)
				&& Objects.equals(CredentialsNonExpired, other.CredentialsNonExpired)
				&& Objects.equals(Enabled, other.Enabled) && Objects.equals(fullName, other.fullName) && id == other.id
				&& Objects.equals(password, other.password) && Objects.equals(permissions, other.permissions)
				&& Objects.equals(userName, other.userName);
	}
	
	

}
