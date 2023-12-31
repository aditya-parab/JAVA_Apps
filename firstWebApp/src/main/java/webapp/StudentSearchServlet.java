package webapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neebalgurukul.dao.StudentDao;
import com.neebalgurukul.model.Student;

@WebServlet(urlPatterns = "/studentsearch.do")
public class StudentSearchServlet extends HttpServlet{
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	    {

	System.out.println("Inside StudentSearchServlet....");
	request.getRequestDispatcher("/WEB-INF/views/studentsearch.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	    {

    	System.out.println("Inside Post StudentSearchServlet....");
 
    	
    	request.getRequestDispatcher("/WEB-INF/views/studentsearch.jsp").forward(request, response);
    	
    }

}
