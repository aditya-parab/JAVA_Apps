package com.neebalgurukal.exceptions;

public class UserAlreadyExistsException extends Exception{
	public UserAlreadyExistsException(){};
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User already exists...";
	}
}
