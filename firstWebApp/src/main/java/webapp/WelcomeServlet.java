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
@WebServlet(urlPatterns = "/welcome.do")
public class WelcomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	    {

	System.out.println("Inside WelcomeServlet....");
	request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
    	System.out.println("inside DoPost of Welcome Servlet");
    	
    

       	StudentDao sDao = new StudentDao();
    	String searchString = request.getParameter("searchString");
    	List<Student> studList = sDao.getStudentSearchResults(searchString);
    	System.out.println("printing the students here:");
    	request.setAttribute("studentList", studList);
    	for(Student s: studList) {
    		System.out.println("name "+s.getName());
    	
    	}
    	
    	
    	
    	
    	request.getRequestDispatcher("/WEB-INF/views/studentsearch.jsp").forward(request, response);
}
    

}
