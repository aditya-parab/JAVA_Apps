package com.neebalgurukul;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.neebalgurukal.exceptions.UserAlreadyExistsException;
import com.neebalgurukal.exceptions.UserNotFoundException;
import com.neebalgurukul.dao.LoginDao;
import com.neebalgurukul.model.Login;


public class LoginTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		LoginDao dao = new LoginDao();
		List<Login> userList = new ArrayList<Login>();
		
		
		try {
			userList = dao.getLoginDetails();
			for(Login obj : userList) {
				System.out.println(obj.getUname()+" , "+obj.getPswd());
			}
			Login obj2 = dao.getLoginPassword("Adi");
			System.out.println( obj2.getUname()+ ", " + obj2.getPswd());
			
			Date currentDate = new Date(System.currentTimeMillis());
//			System.out.println(dao.insertRecord("ADP", "abcdef",currentDate, true));
			System.out.println(dao.deleteRecordHard("BBB"));
		} 
		
		catch (UserAlreadyExistsException e) {
			System.out.println(e);
		}
		
		catch (UserNotFoundException e) {
			System.out.println(e);
		}
		
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

	}

}
