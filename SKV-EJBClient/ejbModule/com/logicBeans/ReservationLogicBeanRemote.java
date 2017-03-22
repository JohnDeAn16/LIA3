package com.logicBeans;

import javax.ejb.Remote;

import entities.Anvandare;
import entities.Materiel;
import entities.Reservation;

@Remote
public interface ReservationLogicBeanRemote 
{
	public Reservation makeReservation(Anvandare a, Materiel m, String from, String to);
}
