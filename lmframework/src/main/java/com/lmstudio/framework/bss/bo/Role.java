package com.lmstudio.framework.bss.bo;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role extends BaseBo  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Column(name="ROLE_NAME")
	private String roleName;

	//bi-directional many-to-many association to Authority
	@ManyToMany(mappedBy="roles")
	private List<Authority> authorities;

	//bi-directional many-to-many association to Module
	@ManyToMany(mappedBy="roles")
	private List<Module> modules;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="ref_user_role"
		, joinColumns={
			@JoinColumn(name="ROL_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="USER_ID")
			}
		)
	private List<User> users;

	public Role() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public List<Module> getModules() {
		return this.modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}