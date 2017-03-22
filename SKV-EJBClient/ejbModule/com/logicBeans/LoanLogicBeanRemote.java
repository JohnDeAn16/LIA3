package com.logicBeans;

import javax.ejb.Remote;

import entities.Anvandare;
import entities.Lan;
import entities.Materiel;

@Remote
public interface LoanLogicBeanRemote 
{
	 public Lan makeLoan(Anvandare a, Materiel m, String to);
}
