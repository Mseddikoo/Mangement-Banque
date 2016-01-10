package org.banque.bp.enties;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Groupe implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long numGroupe;
	private String nomGroupe;
	@ManyToMany(mappedBy="groupes")
	private Collection<Employe> employes;

	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}

	public Groupe() {
		super();
	}

	public long getNumGroupe() {
		return numGroupe;
	}

	public void setNumGroupe(long numGroupe) {
		this.numGroupe = numGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public Collection<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}

}
