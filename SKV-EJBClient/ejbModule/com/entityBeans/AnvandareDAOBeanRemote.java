package com.entityBeans;

import javax.ejb.Remote;

import entities.Anvandare;

@Remote
public interface AnvandareDAOBeanRemote 
{
	public void addAnvandare(Anvandare e);
	public Anvandare getAnvandare(int id);
	public Anvandare getAnvByLogin(String mail, String pass);
	public Anvandare getAnvandareByMail(String mail);
}
