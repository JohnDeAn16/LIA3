package com.logicBeans;

import javax.ejb.Remote;

import com.exceptions.LibException;
import com.messageBeans.MessageContainerBeanRemote;

import entities.Anvandare;

@Remote
public interface MessageHandlerBeanRemote 
{
	public Anvandare handleMessage(MessageContainerBeanRemote mcb) throws LibException;
}
