package com.entityBeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Materiel;

/**
 * Session Bean implementation class MaterielDAOBean
 */
@Stateless
//@Named
@LocalBean
public class MaterielDAOBean implements MaterielDAOBeanRemote 
{

	@PersistenceContext(unitName="SKV-Persistence")
	EntityManager em;
    /**
     * Default constructor. 
     */
	//@Inject
    public MaterielDAOBean() 
    {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addMateriel(Materiel e)
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

	@Override
	public Materiel getMateriel(int id)
	{
		Query q = em.createQuery("SELECT e FROM Materiel e WHERE id = :id");
    	q.setParameter("id", id);
    	
		return (Materiel)q.getSingleResult();
	}

	@Override
	public Materiel getByName(String name)
	{
		Query q = em.createQuery("SELECT e FROM Materiel e WHERE e.name = :name");
		q.setParameter("name", name);
		return (Materiel)q.getSingleResult();
	}
	
	@Override
	public List<Materiel> getAllMateriel()
	{
		Query q = em.createQuery("SELECT e FROM Materiel e");
		return (List<Materiel>) q.getResultList();
		
	}
	
	

}
