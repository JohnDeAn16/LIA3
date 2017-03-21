package com.entityBeans;

import javax.ejb.Remote;

import entities.Materiel;

@Remote
public interface MaterielDAOBeanRemote 
{
	public void addMateriel(Materiel e);
	public Materiel getMateriel(int id);
	public Materiel getByName(String name);
}
