package com.logicBeans;

import java.util.Calendar;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Materiel;
import entities.Reservation;

/**
 * Session Bean implementation class ScheduleBean
 */
@Stateless
@LocalBean
public class ScheduleBean implements ScheduleBeanRemote 
{

    /**
     * Default constructor. 
     */
    public ScheduleBean() 
    {
        // TODO Auto-generated constructor stub
    }
    
    public Date getDate()
    {
    	java.util.Date utilDate = new java.util.Date();
    	Date d = new Date(utilDate.getTime());
    	return d;
    }
    
    public Date makeHandinDate(Materiel m, Date from)
    {
    	Date to = null;
    	
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, m.getTyp().getStandardLanetid());
		java.util.Date utilDate = c.getTime();
		to = new Date(utilDate.getTime());
		return to;
    }
    
    public boolean checkIfAvailable(Materiel m, Date from, Date to)
    {
    	boolean isAvailable = true;
    	
    	for(Reservation r: m.getReservationer())
    	{
    		if(!(from.before(r.getReserveradFran()) && to.after(r.getReserveradTill())))
    		{
    			isAvailable = false;
    		}
    	}
    	return isAvailable;
    }
    
    public boolean lengthIsValid(Materiel m, Date from, Date to)
    {
    	long diff = (to.getTime() - from.getTime()) / (1000 * 60 * 60 * 24);
    	return (int)diff <= m.getTyp().getMaxLaneTid();
    }
    
    public Date stringToDate(String s)
    {	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    	java.util.Date utilDate = null;
		try
		{
			utilDate = sdf.parse(s);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
    	Date date = new Date(utilDate.getTime());
    	return date;
    }

    
    
    //TODO getAvailabilitySchedule()

}
