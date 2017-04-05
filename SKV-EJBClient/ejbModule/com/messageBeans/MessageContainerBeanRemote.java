package com.messageBeans;

import java.io.Serializable;

import javax.ejb.Remote;

import entities.Anvandare;
import entities.Lan;
import entities.Materiel;
import entities.Reservation;

@Remote
public interface MessageContainerBeanRemote extends Serializable
{
	public int getActionType();
	public void setActionType(int actionType);
	public Anvandare getAnv();
	public void setAnv(Anvandare anv);
	public Materiel getMat();
	public void setMat(Materiel mat);
	public String getDateFrom();
	public void setDateFrom(String dateFrom);
	public String getDateTo();
	public void setDateTo(String dateTo);
	public Reservation getR();
	public void setR(Reservation r);
	public Lan getLan();
	public void setLan(Lan lan);
}
