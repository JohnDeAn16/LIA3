package entities;

import java.io.Serializable;

public class LanId implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int anvandarId;
	int materielId;
	
	public LanId()
	{
		super();
	}
	public int getAnvandarId()
	{
		return anvandarId;
	}
	public void setAnvandarId(int anvandarId)
	{
		this.anvandarId = anvandarId;
	}
	public int getMaterielId()
	{
		return materielId;
	}
	public void setMaterielId(int materielId)
	{
		this.materielId = materielId;
	}
	
    public boolean equals(Object other) 
    {
        if (this == other)
            return true;
        if (!(other instanceof LanId))
            return false;
        LanId castOther = (LanId) other;
        return anvandarId == castOther.anvandarId && materielId == castOther.materielId;
    }
    
    public int hashCode() 
    {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.anvandarId;
        hash = hash * prime + this.materielId;
        return hash;
    }
	
	
}
