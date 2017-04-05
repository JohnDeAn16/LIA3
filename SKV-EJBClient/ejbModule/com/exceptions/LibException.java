package com.exceptions;

public class LibException extends Exception
{

	public LibException()
	{
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;
	private String description;
	private ErrorCode ec;
	
	public LibException(ErrorCode c, String desc)
	{
		this.description = desc;
		this.ec = c;
	}
	
	public String getMessage()
	{
		return ec.toString() + ": " + ec.getMsg() + "\n" + this.description;
	}

}
