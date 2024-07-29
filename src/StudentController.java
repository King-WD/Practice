import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    private final StudentService studentService = new StudentService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String S_num=request.getSession().getAttribute("S_num").toString();
        if (action.equals("Info_Query")) {

            Student student = studentService .displayInfo(S_num);
            request.getSession().setAttribute("SInfo",student);
            request.getRequestDispatcher("/SInfo.jsp").forward(request, response);
        }
        if (action.equals("Grade")) {
            List<Report> reports=new ArrayList<>();
            request.getSession().setAttribute("Reports",reports);
            request.getRequestDispatcher("/SGrade.jsp").forward(request, response);
        }
        if(action.equals("Grade_Query")) {
            String Course_semester=request.getParameter("semester");
            List<Report> reports=studentService.displayReport(S_num,Course_semester);
            request.setAttribute("Course_semester", Course_semester);
            request.getSession().setAttribute("Reports",reports);
            request.getRequestDispatcher("/SGrade.jsp").forward(request, response);
        }
        if (action.equals("Class_Course")) {
            List<Class_Course> class_courses=new ArrayList<>();
            request.getSession().setAttribute("Class_Courses",class_courses);
            request.getRequestDispatcher("/SCCourse.jsp").forward(request, response);
        }
        if(action.equals("Class_Course_Query")){
            String C_name=request.getParameter("class");
            List<Class_Course> class_courses=studentService.displayClass_Course(C_name);
            request.getSession().setAttribute("C_name",C_name);
            request.getSession().setAttribute("Class_Courses",class_courses);
            request.getRequestDispatcher("/SCCourse.jsp").forward(request, response);
        }
        if(action.equals("Course_Credit_Query")){
            List<Course_Credit> course_credits=studentService.displayCourse_Credit(S_num);
            request.getSession().setAttribute("Course_Credits",course_credits);
            request.getRequestDispatcher("/SCourse.jsp").forward(request, response);
        }
        if(action.equals("Password")){
            request.getRequestDispatcher("/SChange.jsp").forward(request, response);
        }
        if(action.equals("Change_Password")){
            String Old=request.getParameter("Old");
            String New=request.getParameter("New");
            String Sure=request.getParameter("Sure");
            String result=studentService.SureChange(Old,New,Sure,S_num);
            request.getSession().setAttribute("Result",result);
            request.getRequestDispatcher("/SChangeResult.jsp").forward(request, response);
        }
        if (action.equals("Exit")) {
            request.getSession().invalidate();
            request.getRequestDispatcher("/sign in.html").forward(request, response);
        }
    }
}

