package org.banque.bp.metier;

import java.util.List;

import org.banque.bp.enties.Client;
import org.banque.bp.enties.Compte;
import org.banque.bp.enties.Employe;
import org.banque.bp.enties.Groupe;
import org.banque.bp.enties.Operation;

public interface IBanqueMetier {
	public void addClient(Client c);

	public void addEmploye(Employe e, Long numEmpSup);

	public void addGroupe(Groupe g);

	public void addEmployeToGroupe(Long idGroupe, Long idEmp);

	public void addCompte(Compte c, Long numCli, Long numEmp);

	public void addOperation(Operation op, String numCpte, Long numEmp);

	public void verser(double mt, String cpte, Long codeEmp);
	public void retirer(double mt, String cpte, Long codeEmp);
	public void virement(double mt, String cpte1,String cpte2,Long codeEmp);
	public Compte consulterCompte(String numCpte);

	public List<Client> consulterClientsParNom(String mc);

	public List<Client> consulterClients();

	public List<Groupe> consulterGroupes();

	public List<Employe> consulterEmployes();

	public List<Employe> consulterEmployesParGroupe(Long idG);

	public Employe consulterEmploye(Long idEmp);
}
