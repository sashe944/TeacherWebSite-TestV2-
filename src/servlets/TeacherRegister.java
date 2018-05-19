package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import objects.Teacher;
import services.RegisterTeacherService;

/**
 * Servlet implementation class TeacherRegister
 */
@WebServlet("/TeacherRegister")
public class TeacherRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RegisterTeacherService registerTeacherService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherRegister() {
        super();
        registerTeacherService = new RegisterTeacherService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Teacher teacher = new Teacher();
		
		final String name = request.getParameter("name");
		final String password = request.getParameter("password");
		final String repassword = request.getParameter("repassword");
		final String email = request.getParameter("email");
		final String gender = request.getParameter("gender");
		final Long userTypeId = Long.parseLong(request.getParameter("Преподавател"));
		
		teacher = registerTeacherService.register(name, password, email, gender, userTypeId);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
     /*  Teacher teacher = new Teacher();
		
		final String name = request.getParameter("name");
		final String password = request.getParameter("password");
		final String repassword = request.getParameter("repassword");
		final String email = request.getParameter("email");
		final String gender = request.getParameter("gender");
		final Long userTypeId = Long.parseLong(request.getParameter("Преподавател"));
		
		teacher = registerTeacherService.register(name, password, email, gender, userTypeId);*/
	}

}
