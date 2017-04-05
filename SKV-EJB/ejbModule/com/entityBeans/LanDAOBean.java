package com.entityBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Lan;

/**
 * Session Bean implementation class LanDAOBean
 */
@Stateless
@LocalBean
public class LanDAOBean implements LanDAOBeanRemote 
{
	@PersistenceContext(unitName="SKV-Persistence")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public LanDAOBean() 
    {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addLan(Lan e)
	{
		//TODO fixa persist/merge
		em.merge(e);
	}

	@Override
	public Lan getLan(int id)
	{
		Query q = em.createQuery("SELECT e FROM Lan e WHERE e.id = :id");
		q.setParameter("id", id);
		return (Lan)q.getSingleResult();
	}
	
	public void deleteLan(Lan l)
	{
		Lan lan = this.getLan(l.getId());
		em.remove(lan);
	}

}
