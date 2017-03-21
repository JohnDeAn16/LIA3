package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entityBeans.AnvandareDAOBeanRemote;
import com.entityBeans.LanDAOBeanRemote;
import com.entityBeans.MaterielDAOBeanRemote;

import entities.Anvandare;
import entities.Lan;
import entities.Materiel;

/**
 * Servlet implementation class DBModelTestServlet
 */
@WebServlet("/DBModelTestServlet")
public class DBModelTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DBModelTestServlet() {
        // TODO Auto-generated constructor stub
    }
    
    public Context getInitialContext()
    {
    	InitialContext ctx = null;
    	try
		{
			ctx = new InitialContext();
		}
		catch (NamingException e)
		{
			e.printStackTrace();
		}
    	return ctx;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Anvandare a = new Anvandare();
    	a.setEmail("test@testmail.com");
    	
    	Anvandare a1 = null;
    	
    	Materiel m = new Materiel();
    	m.setNamn("TestBok1");
    	
    	Materiel m2 = new Materiel();
    	m2.setNamn("TestBok2");
    	
    	Materiel m3 = new Materiel();
    	m3.setNamn("TestBok3");
    	
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	
    	try
    	{
    		

    		AnvandareDAOBeanRemote aBean = (AnvandareDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/AnvandareDAOBean!com.entityBeans.AnvandareDAOBeanRemote");
    		
    		MaterielDAOBeanRemote mBean = (MaterielDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/MaterielDAOBean!com.entityBeans.MaterielDAOBeanRemote");
    		mBean.addMateriel(m);
    		mBean.addMateriel(m2);
    		mBean.addMateriel(m3);
    		
    		Lan l = new Lan();
    		l.setAnv(a);
    		l.setMat(m);
    		
    		Lan l2 = new Lan();
    		l2.setAnv(a);
    		l2.setMat(m3);
    		
    		LanDAOBeanRemote lBean = (LanDAOBeanRemote)getInitialContext().lookup("java:global/SKVApp/SKV-EJB/LanDAOBean!com.entityBeans.LanDAOBean");
    		lBean.addLan(l);
    		lBean.addLan(l2);
    		
    		a.addLan(l);
    		a.addLan(l2);
    		aBean.addAnvandare(a);
    		
    		a1 = aBean.getAnvandare(a.getId());
    		
    		for(Lan lan: a1.getLan())
    		{
    			out.println(lan.getMat().getNamn());
    		}
    		l.setMat(m2);
    		lBean.addLan(l);
    		
    		a1 = aBean.getAnvandare(a.getId());
    		
    		for(Lan ll: a1.getLan())
    		{
    			out.println(ll.getMat().getNamn());
    		}
    	}
    	catch(Exception e)
    	{
    		out.println(e.getMessage());
    	}
    	
    	 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
