package com.logicBeans;

import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Anvandare;
import entities.Materiel;
import entities.Reservation;

/**
 * Session Bean implementation class ReservationLogicBean
 */
@Stateless
@LocalBean
public class ReservationLogicBean extends TransactionLogicBean implements ReservationLogicBeanRemote 
{
       
    /**
     * @see TransactionLogicBean#TransactionLogicBean()
     */
    public ReservationLogicBean() 
    {
        super();
    }
    
    public Reservation makeReservation(Anvandare a, Materiel m, String from, String to)
    {
    	Reservation r = new Reservation();
    	Date out = sBean.stringToDate(from);
    	Date in = this.getHandinDate(m, out, to);
    	
    	if(sBean.checkIfAvailable(m, out, in) && sBean.lengthIsValid(m, out, in))//TODO Exception
    	{
    		r.setAnvandare(a);
    		r.setMateriel(m);
    		r.setReserveradFran(out);
    		r.setReserveradTill(in);
    		r.setReservationsDatum(sBean.getDate());
    	}
    	return r;
    }

}
