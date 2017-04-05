package com.logicBeans;

import javax.ejb.Remote;

import com.exceptions.LibException;

import entities.Anvandare;

@Remote
public interface LoginBeanRemote 
{
	public Anvandare createUser(String email, String pass) throws LibException;
	public Anvandare login(String email, String pass) throws LibException;
}
