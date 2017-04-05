package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Anvandare
 *
 */
@Entity
public class Anvandare implements Serializable 
{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String pass;
	
	@OneToMany(mappedBy="anv", targetEntity=Lan.class, cascade=CascadeType.PERSIST)
	private List<Lan> lan;
	
	@OneToMany(mappedBy="anvandare", targetEntity=Reservation.class, cascade=CascadeType.PERSIST)
	private List<Reservation> reservationer;

	public Anvandare() 
	{
		super();
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public List<Lan> getLan()
	{
		return lan;
	}

	public void setLan(List<Lan> list)
	{
		this.lan = list;
	}
	
	public void addLan(Lan l)
	{
		this.lan.add(l);
	}

	public List<Reservation> getReservationer()
	{
		return reservationer;
	}

	public void setReservationer(List<Reservation> reservationer)
	{
		this.reservationer = reservationer;
	}
	
	

   
}
