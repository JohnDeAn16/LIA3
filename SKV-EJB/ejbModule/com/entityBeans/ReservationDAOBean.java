package com.entityBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Reservation;

/**
 * Session Bean implementation class ReservationDAOBean
 */
@Stateless
@LocalBean
public class ReservationDAOBean implements ReservationDAOBeanRemote 
{
	@PersistenceContext(unitName="SKV-Persistence")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public ReservationDAOBean() 
    {
    }

	@Override
	public void addReservation(Reservation e)
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
	public Reservation getReservation(int id)
	{
		Query q = em.createQuery("SELECT e FROM Reservation e WHERE id = :id");
		q.setParameter("id", id);
		return (Reservation)q.getSingleResult();
	}
	
	@Override
	public void deleteReservation(Reservation r)
	{
		Reservation res = this.getReservation(r.getId());
		em.remove(res);
	}

}
