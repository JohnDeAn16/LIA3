package com.logicBeans;

import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Materiel;



/**
 * Session Bean implementation class TransactionLogicBean
 */
@Stateless
@LocalBean
public class TransactionLogicBean implements TransactionLogicBeanRemote 
{
	
	ScheduleBeanRemote sBean;
    /**
     * Default constructor. 
     */
    public TransactionLogicBean() 
    {
    	try
		{
			sBean = (ScheduleBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/ScheduleBean!com.logicBeans.ScheduleBean");
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
    
    protected Date getHandinDate(Materiel m, Date from, String to)
    {
    	Date in;
    	if(!to.equals(""))
    	{
    		in = sBean.stringToDate(to);
    	}
    	else
    	{
    		in = sBean.makeHandinDate(m, from);
    	}
    	return in;
    }
}
