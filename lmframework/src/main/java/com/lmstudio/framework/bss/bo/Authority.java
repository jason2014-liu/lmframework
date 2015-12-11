package com.lmstudio.framework.bss.bo;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the authorities database table.
 * 
 */
@Entity
@Table(name="authorities")
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority extends BaseBo  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Column(name="AUTHORITY_CODE")
	private String authorityCode;

	@Column(name="AUTHORITY_HREF")
	private String authorityHref;

	@Column(name="AUTHORITY_TYPE")
	private String authorityType;

	//bi-directional many-to-one association to Module
	@ManyToOne
	private Module module;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="ref_role_authority"
		, joinColumns={
			@JoinColumn(name="AUT_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ROLE_ID")
			}
		)
	private List<Role> roles;

	public Authority() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthorityCode() {
		return this.authorityCode;
	}

	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}

	public String getAuthorityHref() {
		return this.authorityHref;
	}

	public void setAuthorityHref(String authorityHref) {
		this.authorityHref = authorityHref;
	}

	public String getAuthorityType() {
		return this.authorityType;
	}

	public void setAuthorityType(String authorityType) {
		this.authorityType = authorityType;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}