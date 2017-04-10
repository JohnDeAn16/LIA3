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

import com.exceptions.LibException;
import com.logicBeans.LoginBeanRemote;
import com.logicBeans.MessageHandlerBeanRemote;
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
	LoginBeanRemote lBean;
	MessageHandlerBeanRemote mBean;
	
    public userSessionBean() 
    {
        // TODO Auto-generated constructor stub
    	try
    	{
    		ctx = new InitialContext();
    		lBean = (LoginBeanRemote)ctx.lookup("java:global/SKVApp/SKV-EJB/LoginBean!com.logicBeans.LoginBean");
    		mBean = (MessageHandlerBeanRemote)ctx.lookup("java:global/SKVApp/SKV-EJB/MessageHandlerBean!com.logicBeans.MessagehandlerBean");
    	}
    	catch(NamingException e)
    	{
    		//TODO
    	}
    }
    
    public void login(String email, String pass)
    {
    	try
		{
			anv = lBean.login(email, pass);
		}
		catch (LibException e)
		{
			//TODO
		}
    }
    
    public void sendMessage(MessageContainerBeanRemote msg)
    {
    	try
    	{
    		anv = mBean.handleMessage(msg);
    	}
    	catch(LibException e)
    	{
    		//TODO
    	}
    }
    
    //TODO view logic?

}
