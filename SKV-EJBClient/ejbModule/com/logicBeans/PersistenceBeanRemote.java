package com.logicBeans;

import javax.ejb.Remote;
import entities.Lan;
import entities.Reservation;

@Remote
public interface PersistenceBeanRemote 
{
	public void persistLoan(Lan l);
	public void persistReservation(Reservation r);
	public void removeLoan(Lan l);
	public void removeReservation(Reservation r);

}
