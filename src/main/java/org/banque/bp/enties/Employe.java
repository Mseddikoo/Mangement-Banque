package org.banque.bp.enties;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity

public class Employe implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeEmploye;
	private String nomEmploy;
	@ManyToOne
	@JoinColumn(name="Code_Employe_Sup")
	private Employe supperHerarchie;
	@ManyToMany
	@JoinTable(name="Employe_Groupe", joinColumns=
			@JoinColumn(name="Code_Employe"),
			inverseJoinColumns=@JoinColumn(name="Code_Groupe")
	)
	private Collection<Groupe> groupes;
	public Employe() {
		super();
	}
	public Employe(String nomEmploy) {
		super();
		this.nomEmploy = nomEmploy;
		
	}
	public long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploy() {
		return nomEmploy;
	}
	public void setNomEmploy(String nomEmploy) {
		this.nomEmploy = nomEmploy;
	}
	public Employe getSupperHerarchie() {
		return supperHerarchie;
	}
	public void setSupperHerarchie(Employe supperHerarchie) {
		this.supperHerarchie = supperHerarchie;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}

	
	
}
