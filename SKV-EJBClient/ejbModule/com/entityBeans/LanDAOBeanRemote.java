package com.entityBeans;

import javax.ejb.Remote;

import entities.Lan;

@Remote
public interface LanDAOBeanRemote 
{
	public void addLan(Lan e);
	public Lan getLan(int anvId, int matId);
	public void deleteLan(Lan l);
}
