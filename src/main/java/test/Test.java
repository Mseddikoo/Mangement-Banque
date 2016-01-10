package test;

import java.util.Date;

import org.banque.bp.enties.Client;
import org.banque.bp.enties.CompteCourant;
import org.banque.bp.enties.CompteEpargne;
import org.banque.bp.enties.Employe;
import org.banque.bp.enties.Groupe;
import org.banque.bp.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");
			metier.addClient(new Client("C1", "AD1"));
			metier.addClient(new Client("C2", "AD2"));
			metier.addClient(new Client("C3", "AD3"));
			
			metier.addEmploye(new Employe("E1"), null);
			metier.addEmploye(new Employe("E2"), 1L);
			metier.addEmploye(new Employe("E3"), 1L);
			metier.addGroupe(new Groupe("G1"));
			metier.addGroupe(new Groupe("G2"));
			metier.addEmployeToGroupe(1L, 1L);
			metier.addEmployeToGroupe(2L, 2L);
			metier.addEmployeToGroupe(2L, 3L);
			
			metier.addCompte(new CompteCourant("CC1", new Date(), 9000, 8000), 2L,1L);
			metier.addCompte(new CompteEpargne("CE1", new Date(), 9000, 8000), 2L,1L);
	}
}
