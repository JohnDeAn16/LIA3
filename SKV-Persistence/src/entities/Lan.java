package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Lan
 *
 */
@Entity
public class Lan implements Serializable 
{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(targetEntity=Anvandare.class, cascade=CascadeType.PERSIST)
	@JoinColumn(name="anvLan", referencedColumnName="id")
	private Anvandare anv;
	
	@OneToOne(targetEntity=Materiel.class, cascade=CascadeType.PERSIST)
	@JoinColumn(name="matLan", referencedColumnName="id")
	private Materiel mat;
	private Date utlaningsDatum;
	private Date inlamningsDatum;

	public Lan() 
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


	public Anvandare getAnv()
	{
		return anv;
	}


	public void setAnv(Anvandare anv)
	{
		this.anv = anv;
		anv.addLan(this);
	}


	public Materiel getMat()
	{
		return mat;
	}


	public void setMat(Materiel mat)
	{
		this.mat = mat;
		mat.setLan(this);
	}


	public Date getUtlaningsDatum()
	{
		return utlaningsDatum;
	}
	public void setUtlaningsDatum(Date utlaningsDatum)
	{
		this.utlaningsDatum = utlaningsDatum;
	}
	public Date getInlamningsDatum()
	{
		return inlamningsDatum;
	}
	public void setInlamningsDatum(Date inlamningsDatum)
	{
		this.inlamningsDatum = inlamningsDatum;
	}




	
	
   
}
