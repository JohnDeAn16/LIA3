package com.entityBeans;

import javax.ejb.Remote;

import entities.Reservation;

@Remote
public interface ReservationDAOBeanRemote 
{
	public void addReservation(Reservation e);
	public Reservation getReservation(int id);
	public void deleteReservation(Reservation r);
}
