package com.exceptions;

public enum ErrorCode
{
	LOGIN_ERROR(100, "Fel vid inloggning"),
	LOAN_ERROR(200, "Fel vid utlaning"),
	INVALID_REQUEST(300, "Placeholder"),
	INTERNAL_ERROR(400, "Internt fel");
	
	
	private final int id;
	private final String msg;
	
	private ErrorCode(int id, String msg)
	{
		this.id = id;
		this.msg = msg;
	}

	public int getId()
	{
		return id;
	}

	public String getMsg()
	{
		return msg;
	}

}
