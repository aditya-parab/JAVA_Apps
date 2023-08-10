package com.neebalgurukul.service;

import java.sql.SQLException;

import com.neebalgurukul.dao.LoginDao;
import com.neebalgurukul.model.Login;

public class LoginService {
    public boolean isUserExists(String username, String password) throws Exception {
//	boolean flag = true;
	Login login = new Login();
	LoginDao dao = new LoginDao();


	    try {
			login = dao.getLoginPassword(username);
			if (login.getPswd()!=null) { 
			return true;
			}
			else {
				return false;//user does not exist as getPwsd==null
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} 
	
    }
}
