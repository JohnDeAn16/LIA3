package com.logicBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.exceptions.LibException;
import com.messageBeans.MessageContainerBean;
import com.messageBeans.MessageContainerBeanRemote;

import entities.Anvandare;

/**
 * Session Bean implementation class MessageHandlerBean
 */
@Stateless
@LocalBean
public class MessageHandlerBean implements MessageHandlerBeanRemote {

	LogicHandlerBeanRemote lBean;
	
    public MessageHandlerBean() 
    {
        try
        {
        	Context ctx = new InitialContext();
        	lBean = (LogicHandlerBeanRemote)ctx.lookup("java:global/SKVApp/SKV-EJB/LogicHandlerBean!com.logicBeans.LogicHandlerBean");
        }
        catch(NamingException e)
        {
        	
        }
    }
    
	public Anvandare handleMessage(MessageContainerBeanRemote mcb) throws LibException
	{
		Anvandare a = null;

		switch (mcb.getActionType())
		{
			case 1:
				a = lBean.makeLoan(mcb.getAnv(), mcb.getMat(), mcb.getDateTo());
				break;
			case 2:
				a = lBean.makeReservation(mcb.getAnv(), mcb.getMat(), mcb.getDateFrom(), mcb.getDateTo());
				break;
			case 3:
				a = lBean.makeLoanFromRes(mcb.getR());
				break;
			case 4:
				lBean.returnLoan(mcb.getLan());
				break;
		}

		return a;
	}
    

}
