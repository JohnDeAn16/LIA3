package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Materiel
 *
 */
@Entity
public class Materiel implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String namn;
	
	@OneToOne(mappedBy="mat", targetEntity=Lan.class)
	private Lan lan;
	
	@OneToMany(mappedBy="materiel", cascade=CascadeType.PERSIST)
	private List<Reservation> reservationer;
	
	@ManyToOne(targetEntity=MaterielTyp.class)
	@JoinColumn(name="matTyp", referencedColumnName="id")
	private MaterielTyp typ;
	
	private boolean arTillganglig;
	
	public Materiel() 
	{
		super();
	}

	public boolean isArTillganglig()
	{
		return arTillganglig;
	}


	public void setArTillganglig(boolean arTillganglig)
	{
		this.arTillganglig = arTillganglig;
	}

	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getNamn()
	{
		return namn;
	}


	public void setNamn(String namn)
	{
		this.namn = namn;
	}


	public Lan getLan()
	{
		return lan;
	}


	public void setLan(Lan lan)
	{
		this.lan = lan;
	}


	public List<Reservation> getReservationer()
	{
		return reservationer;
	}


	public void setReservationer(List<Reservation> reservationer)
	{
		this.reservationer = reservationer;
	}


	public MaterielTyp getTyp()
	{
		return typ;
	}


	public void setTyp(MaterielTyp typ)
	{
		this.typ = typ;
	}
	
	
   

}
