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
	String name = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.println("I/P Parameter :" + name + " , " + password);


	
	if (loginService.isValidUser(name, password)) {
	    try {
	    	request.setAttribute("name",name);
	    	request.setAttribute("password", password);
		request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
	} else {
	    request.setAttribute("errorMessage", "Invalid Credentials!");
	    try {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	    } catch (ServletException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
}
