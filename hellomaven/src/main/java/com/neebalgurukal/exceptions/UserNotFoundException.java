package com.neebalgurukal.exceptions;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException(){};
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "User was not found...";
}
}
