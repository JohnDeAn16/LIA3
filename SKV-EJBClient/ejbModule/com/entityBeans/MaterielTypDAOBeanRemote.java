package com.entityBeans;

import javax.ejb.Remote;

import entities.MaterielTyp;

@Remote
public interface MaterielTypDAOBeanRemote 
{
	public void addMaterielTyp(MaterielTyp e);
	public MaterielTyp getMaterielTyp(int id);
}
