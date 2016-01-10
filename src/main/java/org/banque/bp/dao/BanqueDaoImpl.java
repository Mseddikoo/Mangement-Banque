package org.banque.bp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.banque.bp.enties.Client;
import org.banque.bp.enties.Compte;
import org.banque.bp.enties.Employe;
import org.banque.bp.enties.Groupe;
import org.banque.bp.enties.Operation;

public class BanqueDaoImpl implements IBanqueDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addClient(Client c) {
		em.persist(c);
	}

	@Override
	public void addEmploye(Employe e, Long numEmpSup) {
		Employe empSup;
		if (numEmpSup != null) {
			empSup = em.find(Employe.class, numEmpSup);
			e.setSupperHerarchie(empSup);
		}
		em.persist(e);
	}

	@Override
	public void addGroupe(Groupe g) {
		em.persist(g);
	}

	@Override
	public void addEmployeToGroupe(Long idGroupe, Long idEmp) {
		Employe emp = em.find(Employe.class, idEmp);
		Groupe g = em.find(Groupe.class, idGroupe);
		emp.getGroupes().add(g);
		g.getEmployes().add(emp);
	}

	@Override
	public void addCompte(Compte c, Long numCli, Long numEmp) {
		Client cli = em.find(Client.class, numCli);
		Employe e = em.find(Employe.class, numEmp);
		c.setClient(cli);
		c.setEmploye(e);
		em.persist(c);
	}

	@Override
	public void addOperation(Operation op, String numCpte, Long numEmp) {
		Compte c = em.find(Compte.class, numCpte);
		Employe emp = em.find(Employe.class, numEmp);
		op.setEmploye(emp);
		op.setCompte(c);
		em.persist(op);
	}

	@Override
	public Compte consulterCompte(String numCpte) {
		Compte cpte = em.find(Compte.class, numCpte);
		if (cpte == null)
			throw new RuntimeException("Compte " + numCpte + " n'existe pas");
		cpte.getOperations().size();
		return cpte;
	}

	@Override
	public List<Client> consulterClientsParNom(String mc) {
		Query req = em.createQuery("select c from Client c where c.nom like:mc");
		req.setParameter("mc", "%" + mc + "%");
		return req.getResultList();
	}

	@Override
	public List<Client> consulterClients() {
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

	@Override
	public List<Groupe> consulterGroupes() {
		Query req = em.createQuery("select g from Groupe g");
		return req.getResultList();
	}

	@Override
	public List<Employe> consulterEmployes() {
		Query req = em.createQuery("select eg from Employe e");
		return req.getResultList();
	}

	@Override
	public List<Employe> consulterEmployesParGroupe(Long idG) {
		Query req = em.createQuery("select e from Employe e where e.groupes.numGroupe=:x");
		req.setParameter("x", idG);
		return req.getResultList();
	}

	@Override
	public Employe consulterEmploye(Long idEmp) {
		Employe e = em.find(Employe.class, idEmp);
		if (e == null)
			throw new RuntimeException("Employe " + idEmp + " n'existe pas");
		return e;
	}

	
}
