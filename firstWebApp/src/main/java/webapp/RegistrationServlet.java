package webapp;

import java.io.IOException;
import java.sql.Date;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neebalgurukul.dao.LoginDao;
import com.neebalgurukul.dao.StudentDao;
import com.neebalgurukul.model.Login;
import com.neebalgurukul.service.LoginService;
import com.neebalgurukul.service.RegistrationService;

@WebServlet(urlPatterns = "/register.do")
public class RegistrationServlet extends HttpServlet{
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	    {

	System.out.println("Inside RegistrationServlet....");
	request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
    	LoginService loginService = new LoginService();
    	String username = request.getParameter("username");
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String course = request.getParameter("course");
    	int age = Integer.parseInt(request.getParameter("age"));
    	StudentDao sdao = new StudentDao();
    	LoginDao dao = new LoginDao();
    	
    	System.out.println("Registration I/P  username :" + username + " , " + password+" , "+course+", "+age);
    	
    	try {
			if(!loginService.isUserExists(username, password) && !RegistrationService.isUserExists(username, password, course, age)) {
				
				request.setAttribute("flag", true);
				
				Login loginObj=new Login();
				loginObj.setActive(true);
				loginObj.setUname(username);
				loginObj.setPswd(password);
				Date currentDate = new Date(System.currentTimeMillis());
				loginObj.setLastModified(currentDate);
				sdao.insertRecord( name, username,  password,  email,  course, age); //insert into student table
				dao.insertDetails(loginObj); //insert into login table
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
				
			}
			else {
				request.setAttribute("flag", false);
			}
			
			request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
    }
    
    
}
