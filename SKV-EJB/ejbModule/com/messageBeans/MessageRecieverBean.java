package com.messageBeans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.exceptions.LibException;
import com.logicBeans.LogicHandlerBean;

import entities.Anvandare;

/**
 * Message-Driven Bean implementation class for: MessageBean
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "messageQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "messageQueue")
public class MessageRecieverBean implements MessageListener 
{
	@JMSConnectionFactory("jms/messageQueueConnectionFactory")
	private JMSContext context;
	LogicHandlerBean lBean;
    public MessageRecieverBean() 
    {
    	InitialContext ctx = null;
    	try
		{
			ctx = new InitialContext();
			lBean = (LogicHandlerBean)ctx.lookup("java:global/SKVApp/SKV-EJB/LogicHandlerBean!com.logicBeans.LogicHandlerBean");
		}
		catch (NamingException e)
		{
			e.printStackTrace();
		}
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) 
    {
        ObjectMessage m = (ObjectMessage)message;
        MessageContainerBean mcb = null;
        Destination d = null;
        try
		{
			mcb = (MessageContainerBean)m.getObject();
			d = message.getJMSReplyTo();
		}
		catch (JMSException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Anvandare a = mcb.getAnv();
       try
       {
    	   
	        switch(mcb.getActionType())
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
       }
       catch(LibException e)
       {
    	   TextMessage eReply = context.createTextMessage();
    	   try
    	   {
    		   eReply.setText(e.getMessage());
    	   }
    	   catch (JMSException e1)
    	   {
    		   // TODO Auto-generated catch block
    		   e1.printStackTrace();
    	   }
    	   context.createProducer().send(d, eReply);
       }
       
       try
       {
    	   ObjectMessage reply = context.createObjectMessage();
    	   reply.setObject(a);
    	   context.createProducer().send(d, reply);
       }
       catch (JMSException e)
       {
    	   // TODO Auto-generated catch block
    	   e.printStackTrace();
       }
    }

}
