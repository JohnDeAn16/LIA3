package com.entityBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.MaterielTyp;

/**
 * Session Bean implementation class MaterielTypDAOBean
 */
@Stateless
@Named
//@LocalBean
public class MaterielTypDAOBean implements MaterielTypDAOBeanRemote 
{

	@PersistenceContext(unitName="SKV-Persistence")
	EntityManager em;
	
	@Inject
    public MaterielTypDAOBean() 
    {
    }

	@Override
	public void addMaterielTyp(MaterielTyp e)
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
	public MaterielTyp getMaterielTyp(int id)
	{
		Query q = em.createQuery("SELECT e FROM MaterielTyp e WHERE e.id = :id");
		q.setParameter("id", id);
		return (MaterielTyp)q.getSingleResult();
	}

}
