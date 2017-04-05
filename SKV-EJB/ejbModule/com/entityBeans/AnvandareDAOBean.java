package com.entityBeans;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Anvandare;

/**
 * Session Bean implementation class AnvandareDAOBean
 */

@Stateless
@Named
public class AnvandareDAOBean implements AnvandareDAOBeanRemote {

	@PersistenceContext(unitName="SKV-Persistence")
	EntityManager em;
	
	@Inject
    public AnvandareDAOBean() 
    {
    }
    
    public void addAnvandare(Anvandare e)
    {
    	if(e.getId() != 0)
    	{
    		em.merge(e);
    	}
    	else
    	{
    		em.persist(e);
    	}
    }
    
    public Anvandare getAnvandare(int id)
    {
    	Query q = em.createQuery("SELECT e FROM Anvandare e WHERE e.id = :id");
    	q.setParameter("id", id);
    	
    	return (Anvandare)q.getSingleResult();
    }
    
    public Anvandare getAnvByLogin(String mail, String pass)
    {
    	Query q = em.createQuery("SELECT e FROM Anvandare e WHERE e.email = :mail AND e.pass = :pass");
    	q.setParameter("mail", mail);
    	q.setParameter("pass", pass);
    	
    	return (Anvandare)q.getSingleResult();
    }

	@Override
	public Anvandare getAnvandareByMail(String mail)
	{
		Query q = em.createQuery("SELECT e FROM Anvandare e WHERE e.email = :mail");
		q.setParameter("mail", mail);
		return (Anvandare)q.getSingleResult();
	}

}
