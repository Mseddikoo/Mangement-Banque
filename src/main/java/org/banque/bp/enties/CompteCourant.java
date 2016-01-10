package org.banque.bp.enties;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{

	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant( String numCompte, Date dateCreation, double solde
			) {
		super(numCompte, dateCreation, solde);
	}

	public CompteCourant(String numCompte, Date dateCreation, double solde,  double decouvert) {
		super(numCompte, dateCreation, solde);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
}
