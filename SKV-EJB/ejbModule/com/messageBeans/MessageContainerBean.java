package com.messageBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Anvandare;
import entities.Lan;
import entities.Materiel;
import entities.Reservation;

/**
 * Session Bean implementation class MessageContainerBean
 */
@Stateless
@LocalBean
public class MessageContainerBean implements MessageContainerBeanRemote 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int actionType;
	private Anvandare anv;
	private Materiel mat;
	private Lan lan;
	private Reservation r;
	private String dateFrom;
	private String dateTo;

    public MessageContainerBean() 
    {
    }

	public int getActionType()
	{
		return actionType;
	}

	public void setActionType(int actionType)
	{
		this.actionType = actionType;
	}

	public Anvandare getAnv()
	{
		return anv;
	}

	public void setAnv(Anvandare anv)
	{
		this.anv = anv;
	}

	public Materiel getMat()
	{
		return mat;
	}

	public void setMat(Materiel mat)
	{
		this.mat = mat;
	}

	public String getDateFrom()
	{
		return dateFrom;
	}

	public void setDateFrom(String dateFrom)
	{
		this.dateFrom = dateFrom;
	}

	public String getDateTo()
	{
		return dateTo;
	}

	public void setDateTo(String dateTo)
	{
		this.dateTo = dateTo;
	}

	public Reservation getR()
	{
		return r;
	}

	public void setR(Reservation r)
	{
		this.r = r;
	}

	public Lan getLan()
	{
		return lan;
	}

	public void setLan(Lan lan)
	{
		this.lan = lan;
	}
	
	
	
	
    
    

}
