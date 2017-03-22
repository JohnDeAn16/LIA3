package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.JoinColumn;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reservation
 *
 */
@Entity

public class Reservation implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity=Anvandare.class, cascade=CascadeType.PERSIST)
	@JoinColumn(name="anv", referencedColumnName="id")
	private Anvandare anvandare;
	
	@ManyToOne(targetEntity=Materiel.class, cascade=CascadeType.PERSIST)
	@JoinColumn(name="mat", referencedColumnName="id")
	private Materiel materiel;
	
	@Column(nullable=true)
	private Date reserveradFran;
	
	@Column(nullable=true)
	private Date reserveradTill;
	
	private Date reservationsDatum;

	public Reservation() 
	{
		super();
	}

	public int getId()
	{
		return id;
	}

	public void setId(int Id)
	{
		this.id = Id;
	}

	public Anvandare getAnvandare()
	{
		return anvandare;
	}

	public void setAnvandare(Anvandare anvandare)
	{
		this.anvandare = anvandare;
	}

	public Materiel getMateriel()
	{
		return materiel;
	}

	public void setMateriel(Materiel materiel)
	{
		this.materiel = materiel;
	}

	public Date getReserveradFran()
	{
		return reserveradFran;
	}

	public void setReserveradFran(Date reserveradFran)
	{
		this.reserveradFran = reserveradFran;
	}

	public Date getReserveradTill()
	{
		return reserveradTill;
	}

	public void setReserveradTill(Date reserveradTill)
	{
		this.reserveradTill = reserveradTill;
	}

	public Date getReservationsDatum()
	{
		return reservationsDatum;
	}

	public void setReservationsDatum(Date reservationsDatum)
	{
		this.reservationsDatum = reservationsDatum;
	}
	
	
	
}
