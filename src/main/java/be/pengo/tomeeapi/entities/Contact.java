package be.pengo.tomeeapi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Entity implementation class for Entity: Contact
 *
 */
@Entity
@Table(name = "contacts")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ContactsGen")
	@TableGenerator(name="ContactsGen", table="CONTACTS_GEN", pkColumnName="PK",
			valueColumnName="AID", initialValue = 1, allocationSize = 1)
	@Column(name="AID")
	private long id;

	@NotNull(message = "Name is not optional.")
	private String name;

	private String lastname;

	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
			+ "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email.")
	private String email;

	@Column(name="mobile_phone")
	private String mobilePhone;

	private String phone;

	@Column(name="postal_code")
	private String postalCode;

	private String address;

	private String locality;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="region")
	private Region region;

	private Date birthdate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date contactDate;
	// ZoneOffset

	@Column(name="identity_id")
	private String identityId;

	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Date getContactDate() {
		return contactDate;
	}

	public void setContactDate(Date contactDate) {
		this.contactDate = contactDate;
	}

	public String getIdentityId() {
		return identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}



}
