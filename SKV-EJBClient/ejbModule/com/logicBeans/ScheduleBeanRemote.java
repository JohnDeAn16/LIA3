package com.logicBeans;

import java.sql.Date;

import javax.ejb.Remote;

import entities.Materiel;

@Remote
public interface ScheduleBeanRemote 
{
	public boolean checkIfAvailable(Materiel m, Date from, Date to);
	public Date getDate();
	public Date makeHandinDate(Materiel m, Date from);
	public boolean lengthIsValid(Materiel m, Date from, Date to);
	public Date stringToDate(String s);
	
}
