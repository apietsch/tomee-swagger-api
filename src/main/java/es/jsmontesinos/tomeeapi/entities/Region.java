package es.jsmontesinos.tomeeapi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


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
	private Long id;

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
