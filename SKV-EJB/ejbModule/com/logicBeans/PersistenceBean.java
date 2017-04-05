package com.logicBeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entityBeans.AnvandareDAOBeanRemote;
import com.entityBeans.LanDAOBeanRemote;
import com.entityBeans.MaterielDAOBeanRemote;
import com.entityBeans.MaterielTypDAOBeanRemote;
import com.entityBeans.ReservationDAOBeanRemote;

import entities.Anvandare;
import entities.Lan;
import entities.Materiel;
import entities.MaterielTyp;
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
	MaterielTypDAOBeanRemote tBean;
	
    public PersistenceBean() 
    {
		try
		{
			lBean = (LanDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/LanDAOBean!com.entityBeans.LanDAOBean");
			aBean = (AnvandareDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/AnvandareDAOBean!com.entityBeans.AnvandareDAOBeanRemote");
			mBean = (MaterielDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/MaterielDAOBean!com.entityBeans.MaterielDAOBean");
			rBean = (ReservationDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/ReservationDAOBean!com.entityBeans.ReservationDAOBean");
			tBean = (MaterielTypDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/MaterielTypDAOBean!com.entityBeans.MaterielTypDAOBeanRemote");

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
		lBean.addLan(l);
		aBean.addAnvandare(l.getAnv());
		mBean.addMateriel(l.getMat());
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
		aBean.addAnvandare(l.getAnv());
		mBean.addMateriel(l.getMat());
	}

	@Override
	public void removeReservation(Reservation r)
	{
		rBean.deleteReservation(r);
		aBean.addAnvandare(r.getAnvandare());
		mBean.addMateriel(r.getMateriel());
	}
	
	public void persistLoanFromRes(Reservation r, Lan l)
	{
		this.removeReservation(r);
		this.persistLoan(l);
	}

	@Override
	public void persistAnvandare(Anvandare a)
	{
		aBean.addAnvandare(a);
	}

	@Override
	public void persistMateriel(Materiel m)
	{
		mBean.addMateriel(m);
	}

	@Override
	public void persistMaterielTyp(MaterielTyp t)
	{
		tBean.addMaterielTyp(t);
	}

	@Override
	public Anvandare getAnvandare(int id)
	{
		return aBean.getAnvandare(id);
	}

	@Override
	public List<Materiel> getMateriel()
	{
		return mBean.getAllMateriel();
	}

	@Override
	public Anvandare getAnvandareByLogin(String mail, String pass)
	{
		return aBean.getAnvByLogin(mail, pass);
	}

	@Override
	public Anvandare getAnvandareByMail(String mail)
	{
		return aBean.getAnvandareByMail(mail);
	}

}
