package org.banque.bp.enties;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numOperation;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name="Code_Compte")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="Code_Employe")
	private Employe employe;
	public Operation( Date dateOperation, double montant, Compte compte, Employe employe) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
		this.employe = employe;
	}

	public Operation() {
		super();
	}

	public Operation( Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public long getNumOperation() {
		return numOperation;
	}

	public void setNumOperation(long numOperation) {
		this.numOperation = numOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

}
