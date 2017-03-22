package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: MaterielTyp
 *
 */
@Entity

public class MaterielTyp implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String typ;
	
	@Column(nullable=true)
	private int standardLanetid;
	
	@Column(nullable=true)
	private int maxLaneTid;
	
	@OneToMany(mappedBy="typ")
	private List<Materiel> materiel;

	public MaterielTyp() 
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
	

	public int getStandardLanetid()
	{
		return standardLanetid;
	}

	public void setStandardLanetid(int standardLanetid)
	{
		this.standardLanetid = standardLanetid;
	}
	
	
	public int getMaxLaneTid()
	{
		return maxLaneTid;
	}

	public void setMaxLaneTid(int maxLaneTid)
	{
		this.maxLaneTid = maxLaneTid;
	}

	public String getTyp()
	{
		return typ;
	}

	public void setTyp(String typ)
	{
		this.typ = typ;
	}

	public List<Materiel> getMateriel()
	{
		return materiel;
	}

	public void setMateriel(List<Materiel> materiel)
	{
		this.materiel = materiel;
	}
   
}
