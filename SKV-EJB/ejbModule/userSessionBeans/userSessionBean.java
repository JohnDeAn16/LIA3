package userSessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.messageBeans.MessageContainerBean;
import com.messageBeans.MessageContainerBeanRemote;

import entities.Anvandare;

/**
 * Session Bean implementation class userSessionBean
 */
@Stateful
@LocalBean
public class userSessionBean implements userSessionBeanRemote 
{

	Anvandare anv;
	InitialContext ctx;
	
    public userSessionBean() 
    {
        // TODO Auto-generated constructor stub
    	try
    	{
    		ctx = new InitialContext();
    	}
    	catch(NamingException e)
    	{
    		//TODO
    	}
    }
    
    public void sendMessage(MessageContainerBeanRemote msg)
    {
    	try
		{
			Queue queue = (Queue)ctx.lookup("queue/messageQueue");
			QueueConnectionFactory factory = (QueueConnectionFactory)ctx.lookup("ConnectionFactory");
			QueueConnection connection = factory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false,  QueueSession.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);
			ObjectMessage objMsg = session.createObjectMessage(msg);
			sender.send(objMsg);
			
		}
		catch (Exception e)
		{

			
		}
    }

}
