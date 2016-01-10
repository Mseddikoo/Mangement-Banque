package org.banque.bp.enties;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{

	public Retrait() {
		super();
	}

	public Retrait( Date dateOperation, double montant) {
		super(dateOperation, montant);
	}

	
}
