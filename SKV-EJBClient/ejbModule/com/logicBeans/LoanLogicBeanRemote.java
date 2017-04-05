package com.logicBeans;

import javax.ejb.Remote;

import com.exceptions.LibException;

import entities.Anvandare;
import entities.Lan;
import entities.Materiel;
import entities.Reservation;

@Remote
public interface LoanLogicBeanRemote 
{
	 public Lan makeLoan(Anvandare a, Materiel m, String to) throws LibException;
	 public Lan makeLoanFromReservation(Reservation r);
	 public Lan returnLoan(Lan l);
}
