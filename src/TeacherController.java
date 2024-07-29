import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
    private final TeacherService teacherService = new TeacherService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String T_num=request.getSession().getAttribute("T_num").toString();
        if (action.equals("Info_Query")) {
            Teacher TInfo = teacherService .displayInfo(T_num);
            request.getSession().setAttribute("TInfo",TInfo);
            request.getRequestDispatcher("/TInfo.jsp").forward(request, response);
        }
        if (action.equals("Teacher_Course")) {
            List<Teacher_Course> teacher_courses=new ArrayList<>();
            request.getSession().setAttribute("Teacher_Courses",teacher_courses);
            request.getRequestDispatcher("/TCourse.jsp").forward(request, response);
        }
        if(action.equals("Teacher_Course_Query")) {
            String Course_semester=request.getParameter("semester");
            List<Teacher_Course> teacher_courses=teacherService.displayTeacher_Courses(T_num,Course_semester);
            request.getSession().setAttribute("Course_semester", Course_semester);
            request.getSession().setAttribute("Teacher_Courses",teacher_courses);
            request.getRequestDispatcher("/TCourse.jsp").forward(request, response);
        }
        if (action.equals("Average_Course")) {
            List<String> average_courses=teacherService.displayAverage_Courses(T_num);
            request.getSession().setAttribute("Average_Courses",average_courses);
            request.getRequestDispatcher("/TAverage.jsp").forward(request, response);
        }
        if(action.equals("Average_Grade_Query")){
            String Course_num=request.getParameter("course");
            Average average_grade=teacherService.displayAverage_Grade(Course_num);
            request.setAttribute("Course_num",Course_num);
            request.getSession().setAttribute("Average_Grade",average_grade);
            request.getRequestDispatcher("/TAverage.jsp").forward(request, response);
        }
        if(action.equals("Sort")){
            List<String> average_courses=teacherService.displayAverage_Courses(T_num);
            request.getSession().setAttribute("Average_Courses",average_courses);
            request.getRequestDispatcher("/TSORT.jsp").forward(request, response);
        }
        if(action.equals("Grade_Sort_Query")){
            String Course_num=request.getParameter("course");
            List<Sort> grade_sorts=teacherService.displaySorts(Course_num);
            request.getSession().setAttribute("Grade_Sorts",grade_sorts);
            request.setAttribute("Course_num",Course_num);
            request.getRequestDispatcher("/TSORT.jsp").forward(request, response);
        }
        if(action.equals("Submit")){
            List<String> average_courses=teacherService.displayAverage_Courses(T_num);
            request.getSession().setAttribute("Average_Courses",average_courses);
            request.getSession().setAttribute("Grade_Sorts",null);
            request.getRequestDispatcher("/TSubmit.jsp").forward(request, response);
        }
        if(action.equals("Submit_Query")){
            String Course_num=request.getParameter("course");
            List<Sort> grade_sorts=teacherService.displaySorts(Course_num);
            request.setAttribute("Course_num",Course_num);
            request.getSession().setAttribute("Grade_Sorts",grade_sorts);
            request.getRequestDispatcher("/TSubmit.jsp").forward(request, response);
        }
        if(action.equals("Submit_Delete")){
            String[] selects=request.getParameterValues("selects");
            for(var select:selects){
                String[] cs_num=select.split(",");
                teacherService.displayDelete(cs_num[0],cs_num[1]);
            }
            String Course_num=request.getParameter("course");
            List<Sort> grade_sorts=teacherService.displaySorts(Course_num);
            request.getSession().setAttribute("Grade_Sorts",grade_sorts);
            request.getRequestDispatcher("/TSubmit.jsp").forward(request, response);
        }
        if(action.equals("Submit_Save")){
            String[] selects=request.getParameterValues("selects");
            System.out.println(selects.length);
            for(var select:selects){
                String[] cs_num=select.split(",");
                String cs_num2=request.getParameter(cs_num[0]+'_'+cs_num[1]);
                teacherService.displaySave(cs_num[0],cs_num[1],cs_num2);
            }
            String Course_num=request.getParameter("course");
            List<Sort> grade_sorts=teacherService.displaySorts(Course_num);
            request.getSession().setAttribute("Grade_Sorts",grade_sorts);
            request.getRequestDispatcher("/TSubmit.jsp").forward(request, response);
        }
        if(action.equals("Password")){
            request.getRequestDispatcher("/TChange.jsp").forward(request, response);
        }
        if(action.equals("Change_Password")){
            String Old=request.getParameter("Old");
            String New=request.getParameter("New");
            String Sure=request.getParameter("Sure");
            String result=teacherService.SureChange(Old,New,Sure,T_num);
            request.getSession().setAttribute("Result",result);
            request.getRequestDispatcher("/TChangeResult.jsp").forward(request, response);
        }
        if (action.equals("Exit")) {
            request.getSession().invalidate();
            request.getRequestDispatcher("/sign in.html").forward(request, response);
        }
    }
}


