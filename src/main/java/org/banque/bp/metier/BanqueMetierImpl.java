package org.banque.bp.metier;

import java.util.Date;
import java.util.List;

import org.banque.bp.dao.IBanqueDAO;
import org.banque.bp.enties.Client;
import org.banque.bp.enties.Compte;
import org.banque.bp.enties.Employe;
import org.banque.bp.enties.Groupe;
import org.banque.bp.enties.Operation;
import org.banque.bp.enties.Retrait;
import org.banque.bp.enties.Versement;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class BanqueMetierImpl implements IBanqueMetier{

	private IBanqueDAO dao;
	public void setDao(IBanqueDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addClient(Client c) {
		dao.addClient(c);
	}

	@Override
	public void addEmploye(Employe e, Long numEmpSup) {
		dao.addEmploye(e, numEmpSup);
	}

	@Override
	public void addGroupe(Groupe g) {
		dao.addGroupe(g);
	}

	@Override
	public void addEmployeToGroupe(Long idGroupe, Long idEmp) {
		dao.addEmployeToGroupe(idGroupe, idEmp);
	}

	@Override
	public void addCompte(Compte c, Long numCli, Long numEmp) {
		dao.addCompte(c, numCli, numEmp);
	}

	@Override
	public void addOperation(Operation op, String numCpte, Long numEmp) {
		dao.addOperation(op, numCpte, numEmp);
	}

	@Override
	public Compte consulterCompte(String numCpte) {
		return dao.consulterCompte(numCpte);
	}

	@Override
	public List<Client> consulterClientsParNom(String mc) {
		return dao.consulterClientsParNom(mc);
	}

	@Override
	public List<Client> consulterClients() {
		return dao.consulterClients();
	}

	@Override
	public List<Groupe> consulterGroupes() {
		return dao.consulterGroupes();
	}

	@Override
	public List<Employe> consulterEmployes() {
		return dao.consulterEmployes();
	}

	@Override
	public List<Employe> consulterEmployesParGroupe(Long idG) {
		return dao.consulterEmployesParGroupe(idG);
	}

	@Override
	public Employe consulterEmploye(Long idEmp) {
		return dao.consulterEmploye(idEmp);
	}

	@Override
	public void verser(double mt, String cpte,  Long codeEmp) {
		dao.addOperation(new Versement(new Date(), mt), cpte, codeEmp);
		Compte cp =dao.consulterCompte(cpte);
		cp.setSolde(cp.getSolde()+mt);
		
		
	}

	@Override
	public void retirer(double mt, String cpte, Long codeEmp) {
		dao.addOperation(new Retrait(new Date(), mt), cpte, codeEmp);
		Compte cp =dao.consulterCompte(cpte);
		cp.setSolde(cp.getSolde()-mt);
		
	}

	@Override
	public void virement(double mt, String cpte1, String cpte2,  Long codeEmp) {
			retirer(mt, cpte1,  codeEmp);
			verser(mt, cpte2,  codeEmp);
	}

}
