package fr.dawan.cvinter.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class CentresInterets implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Version
	private int version;

	private String name;

//	@ManyToOne(cascade = CascadeType.ALL)
//	private CV cv;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

//	public CV getCv() {
//		return cv;
//	}
//
//	public void setCv(CV cv) {
//		this.cv = cv;
//	}

	public CentresInterets() {
		super();
	}

	public CentresInterets(String name) {
		super();

		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
