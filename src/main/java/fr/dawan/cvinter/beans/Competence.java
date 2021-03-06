package fr.dawan.cvinter.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Competence implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@ElementCollection
	private List<String> tags;

//	@ManyToOne(cascade = CascadeType.ALL)
//	private CV cv;

	public Competence() {
		tags = new ArrayList<>();
	}

	public Competence(String name, List<String> tags) {
		super();
		this.name = name;
		this.tags = tags;
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

//	public CV getCv() {
//		return cv;
//	}
//
//	public void setCv(CV cv) {
//		this.cv = cv;
//	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
