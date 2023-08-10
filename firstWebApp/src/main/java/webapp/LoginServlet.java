package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neebalgurukul.service.LoginService;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	    {

	System.out.println("Inside LoginServlet....");
	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
	LoginService loginService = new LoginService();
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.println("I/P Parameter :" + username + " , " + password);


	
	try {
		System.out.println("hi im in login1");
		if (loginService.isValidUser(username, password)) {
		    
		    	System.out.println("hi im in login2");
		    	request.setAttribute("name",username);
		    	request.setAttribute("password", password);
			request.getRequestDispatcher("/WEB-INF/views/studentsearch.jsp").forward(request, response);
		    } 
		 else {
		    request.setAttribute("errorMessage", "Invalid Credentials!");
		    
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		    }
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e);	} 
	}
    }

    

