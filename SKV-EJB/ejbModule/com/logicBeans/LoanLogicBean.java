package com.logicBeans;

import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Anvandare;
import entities.Lan;
import entities.Materiel;
import entities.Reservation;

/**
 * Session Bean implementation class LoanLogicBean
 */
@Stateless
@LocalBean
public class LoanLogicBean extends TransactionLogicBean implements LoanLogicBeanRemote 
{
       
    /**
     * @see TransactionLogicBean#TransactionLogicBean()
     */
    public LoanLogicBean() 
    {
        super();
    }
    
    public Lan makeLoan(Anvandare a, Materiel m, String to)
    {
    	if(m.isArTillganglig())//TODO Exception
    	{
        	Lan l = new Lan();
        	Date out = sBean.getDate();	
    		Date in = this.getHandinDate(m, out, to);
    	
	    	if(sBean.checkIfAvailable(m, out, in) && sBean.lengthIsValid(m, out, in))//TODO Exception
	    	{
	        	l.setAnv(a);
	        	l.setMat(m);
	        	l.setUtlaningsDatum(out);
	        	l.setInlamningsDatum(in);	    		
	    		return l;
	    	}
    	}
    	return null;
    }
    
    public Lan makeLoanFromReservation(Reservation r)
    {
    	Lan l = new Lan();
    	l.setAnv(r.getAnvandare());
    	l.setMat(r.getMateriel());
    	l.setUtlaningsDatum(sBean.getDate());
    	l.setInlamningsDatum(r.getReserveradTill());
    	
    	return l;
    }

}
