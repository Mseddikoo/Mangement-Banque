package org.banque.bp.enties;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	private double taux;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(String numCompte, Date dateCreation, double solde) {
		super(numCompte, dateCreation, solde);
	}

	public CompteEpargne(String numCompte, Date dateCreation, double solde,double taux) {
		super(numCompte, dateCreation, solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
