package com.logicBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.exceptions.LibException;

import entities.Anvandare;
import entities.Lan;
import entities.Materiel;
import entities.Reservation;

/**
 * Session Bean implementation class LogicHandlerBean
 */
@Stateless
@LocalBean
public class LogicHandlerBean implements LogicHandlerBeanRemote 
{
	PersistenceBeanRemote pBean;
	LoanLogicBeanRemote lBean;
	ReservationLogicBeanRemote rBean;
	
    public LogicHandlerBean() 
    {
        try
		{
			pBean = (PersistenceBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/PersistenceBean!com.logicBeans.PersistenceBean");
			lBean = (LoanLogicBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/LoanLogicBean!com.logicBeans.LoanLogicBean");
			rBean = (ReservationLogicBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/ReservationLogicBean!com.logicBeans.ReservationLogicBean");
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
    
    public Anvandare makeLoan(Anvandare a, Materiel m, String to) throws LibException
    {
    	Lan l = lBean.makeLoan(a, m, to);
    	if(l == null)
    	{
    		return null;
    	}
    	else
    	{
    		pBean.persistLoan(l);
    		return pBean.getAnvandare(a.getId());
    	}
    }
    
    public Anvandare makeReservation(Anvandare a, Materiel m, String from, String to) throws LibException
    {
    	Reservation r = rBean.makeReservation(a, m, from, to);
    	if(r == null)
    	{
    		return null;
    	}
    	else
    	{
    		pBean.persistReservation(r);
    		return pBean.getAnvandare(a.getId());
    	}
    }
    
    public Anvandare makeLoanFromRes(Reservation r)
    {
    	Lan l = lBean.makeLoanFromReservation(r);
    	pBean.persistLoanFromRes(r, l);
    	return pBean.getAnvandare(r.getAnvandare().getId());
    }
    
    public void returnLoan(Lan l)
    {
    	l = lBean.returnLoan(l);
    	pBean.removeLoan(l);
    }
}
