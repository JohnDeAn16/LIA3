package com.logicBeans;

import javax.ejb.Remote;

import com.exceptions.LibException;

import entities.Anvandare;
import entities.Lan;
import entities.Materiel;
import entities.Reservation;

@Remote
public interface LogicHandlerBeanRemote 
{
	public Anvandare makeLoan(Anvandare a, Materiel m, String to) throws LibException;
	public Anvandare makeReservation(Anvandare a, Materiel m, String from, String to) throws LibException;
	public Anvandare makeLoanFromRes(Reservation r);
	public void returnLoan(Lan l);
}
