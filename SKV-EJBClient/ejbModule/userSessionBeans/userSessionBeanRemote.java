package userSessionBeans;

import javax.ejb.Remote;

import com.messageBeans.MessageContainerBeanRemote;

@Remote
public interface userSessionBeanRemote 
{
	public void sendMessage(MessageContainerBeanRemote msg);
}
