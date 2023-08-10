package com.neebalgurukul.service;

//import com.neebalgurukul.dao.LoginDao;
import com.neebalgurukul.dao.StudentDao;
import com.neebalgurukul.exceptions.UserAlreadyExistsException;
import com.neebalgurukul.model.Student;

public class RegistrationService {
	 public static boolean isValidUser(String username, String password,String course,int age) throws Exception {
			boolean flag = false;
			Student student = new Student();
			StudentDao sdao = new StudentDao();
			Student check = sdao.getStudent(username); 
			if(check.getName()!=null)	{// will check if student already exists
				System.out.println("Registration Student already exist ");
				return false;
			}
			else {
				System.out.println("Registration Student is valid");
				return true;
			}
	

	

	 }}
