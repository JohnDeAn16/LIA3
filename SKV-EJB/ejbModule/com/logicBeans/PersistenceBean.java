package com.logicBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entityBeans.AnvandareDAOBeanRemote;
import com.entityBeans.LanDAOBeanRemote;
import com.entityBeans.MaterielDAOBeanRemote;
import com.entityBeans.ReservationDAOBeanRemote;

import entities.Anvandare;
import entities.Lan;
import entities.Materiel;
import entities.Reservation;

/**
 * Session Bean implementation class PersistenceBean
 */
@Stateless
@LocalBean
public class PersistenceBean implements PersistenceBeanRemote 
{

	LanDAOBeanRemote lBean;
	AnvandareDAOBeanRemote aBean;
	MaterielDAOBeanRemote  mBean;
	ReservationDAOBeanRemote rBean;
	
    public PersistenceBean() 
    {
		try
		{
			lBean = (LanDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/LanDAOBean!com.entityBeans.LanDAOBean");
			aBean = (AnvandareDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/AnvandareDAOBean!com.entityBeans.AnvandareDAOBeanRemote");
			mBean = (MaterielDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/MaterielDAOBean!com.entityBeans.MaterielDAOBeanRemote");
			rBean = (ReservationDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-Ejb/ReservationDAOBean!com.entityBeans.ReservationDAOBeanRemote");

		}
		catch (NamingException e)
		{
			e.printStackTrace();
		}
    }
    
    private Context getInitialContext()
    {
    	InitialContext ctx = null;
    	try
		{
			ctx = new InitialContext();
		}
		catch (NamingException e)
		{
			e.printStackTrace();
		}
    	return ctx;
    }

	@Override
	public void persistLoan(Lan l)
	{
		aBean.addAnvandare(l.getAnv());
		mBean.addMateriel(l.getMat());
		lBean.addLan(l);
	}

	@Override
	public void persistReservation(Reservation r)
	{
		aBean.addAnvandare(r.getAnvandare());
		mBean.addMateriel(r.getMateriel());
		rBean.addReservation(r);
	}

	@Override
	public void removeLoan(Lan l)
	{
		lBean.deleteLan(l);
	}

	@Override
	public void removeReservation(Reservation r)
	{
		//TODO
	}
	
	public void persistLoanFromRes(Reservation r, Lan l)
	{
		this.removeReservation(r);
		this.persistLoan(l);
	}

}
