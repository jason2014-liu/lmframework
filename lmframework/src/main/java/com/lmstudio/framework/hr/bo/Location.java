package com.lmstudio.framework.hr.bo;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOCATIONS database table.
 * 
 */
@Entity
@Table(name="LOCATIONS")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location extends com.lmstudio.framework.bss.bo.BaseBo  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCATIONS_LOCATIONID_GENERATOR", sequenceName="LOCATIONS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATIONS_LOCATIONID_GENERATOR")
	@Column(name="LOCATION_ID")
	private long locationId;

	private String city;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	@Column(name="STREET_ADDRESS")
	private String streetAddress;

	//bi-directional many-to-one association to Department 默认延迟加载 LAZY
//	@OneToMany(mappedBy="location",fetch = FetchType.EAGER)
//	private List<Department> departments;
//
//	//bi-directional many-to-one association to Country
//	@ManyToOne
//	@JoinColumn(name="COUNTRY_ID")
//	private Country country;

	public Location() {
	}

	public long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


}