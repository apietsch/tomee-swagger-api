package be.pengo.tomeeapi.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the region database table.
 *
 */
@Entity
@Table(name="regions")
@NamedQuery(name="Region.findAll", query="SELECT p FROM Region p")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="RegionGen")
	@TableGenerator(name="RegionGen", table="REGION_GEN", pkColumnName="PK",
			valueColumnName="AID", initialValue = 1, allocationSize = 1)
	@Column(name="AID")
	private long id;
	
	private String name;

	public Region() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String nombre) {
		this.name = nombre;
	}

}
