package com.entityBeans;

import javax.ejb.Remote;

import entities.Lan;

@Remote
public interface LanDAOBeanRemote 
{
	public void addLan(Lan e);
	public Lan getLan(int id);
	public void deleteLan(Lan l);
}
