package com.neebalgurukul.service;

import java.sql.SQLException;

import com.neebalgurukul.dao.LoginDao;
import com.neebalgurukul.model.Login;

public class LoginService {
    public boolean isValidUser(String username, String password) {
	boolean flag = true;
	Login login = new Login();
	LoginDao dao = new LoginDao();

	try {
	    login = dao.getLoginPassword(username);
	    if (login.getPswd()!=null) { //user already exists
		flag = false;
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return flag;
    }
}
