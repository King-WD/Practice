import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
    private final AdminService adminService= new AdminService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String Admin_num = request.getSession().getAttribute("Admin_num").toString();
        if (action.equals("Teacher")) {
            request.getSession().setAttribute("Teacher", null);
            request.getRequestDispatcher("/AdminTeacher.jsp").forward(request, response);
        }
        if (action.equals("Teacher_Query")) {
            String T_num = request.getParameter("num");
            Teacher teacher = adminService.displayQuery(T_num);
            request.setAttribute("T_num", T_num);
            request.getSession().setAttribute("Teacher", teacher);
            request.getRequestDispatcher("/AdminTeacher.jsp").forward(request, response);
        }
        if (action.equals("Teacher_Insert")) {
            request.getSession().setAttribute("Tip", null);
            request.getRequestDispatcher("/AdminTInsert.jsp").forward(request, response);
        }
        if (action.equals("Teacher_Add")) {
            String[] T_infos = request.getParameterValues("selects");
            adminService.displayInsert(T_infos);
            request.getSession().setAttribute("Teacher", null);
            request.getRequestDispatcher("/AdminTeacher.jsp").forward(request, response);
        }
        if (action.equals("Teacher_Delete")) {
            String[] selects = request.getParameterValues("selects");
            adminService.displayDelete(selects[0]);
            request.getSession().setAttribute("Teacher", null);
            request.getRequestDispatcher("/AdminTeacher.jsp").forward(request, response);
        }
        if (action.equals("Teacher_Save")) {
            String[] selects = request.getParameterValues("selects");
            adminService.displaySave(selects);
            request.getSession().setAttribute("Teacher", null);
            request.getRequestDispatcher("/AdminTeacher.jsp").forward(request, response);
        }
        if (action.equals("Student")) {
            request.getSession().setAttribute("Student", null);
            request.getRequestDispatcher("/AdminStudent.jsp").forward(request, response);
        }
        if (action.equals("Student_Query")) {
            String S_num = request.getParameter("num");
            Student student = adminService.displayQueryS(S_num);
            request.setAttribute("S_num", S_num);
            request.getSession().setAttribute("Student", student);
            request.getRequestDispatcher("/AdminStudent.jsp").forward(request, response);
        }
        if (action.equals("Student_Insert")) {
            request.getSession().setAttribute("Tip", null);
            request.getRequestDispatcher("/AdminSInsert.jsp").forward(request, response);
        }
        if (action.equals("Student_Add")) {
            String[] S_infos = request.getParameterValues("selects");
            adminService.displayInsertS(S_infos);
            request.getSession().setAttribute("Student", null);
            request.getRequestDispatcher("/AdminStudent.jsp").forward(request, response);
        }
        if (action.equals("Student_Delete")) {
            String[] selects = request.getParameterValues("selects");
            adminService.displayDeleteS(selects[0]);
            request.getSession().setAttribute("Student", null);
            request.getRequestDispatcher("/AdminStudent.jsp").forward(request, response);
        }
        if (action.equals("Student_Save")) {
            String[] selects = request.getParameterValues("selects");
            adminService.displaySaveS(selects);
            request.getSession().setAttribute("Student", null);
            request.getRequestDispatcher("/AdminStudent.jsp").forward(request, response);
        }
        if (action.equals("Addr")) {
            request.getSession().setAttribute("Students", null);
            request.getRequestDispatcher("/AdminAddr.jsp").forward(request, response);
        }
        if (action.equals("Addr_Query")) {
            String S_addr = request.getParameter("addr");
            List<String> total = adminService.displayTotal(S_addr);
            request.setAttribute("S_addr", S_addr);
            request.getSession().setAttribute("Total", total);
            request.getRequestDispatcher("/AdminAddr.jsp").forward(request, response);
        }
        if (action.equals("Password")) {
            request.getRequestDispatcher("/AdminChange.jsp").forward(request, response);
        }
        if (action.equals("Change_Password")) {
            String Old = request.getParameter("Old");
            String New = request.getParameter("New");
            String Sure = request.getParameter("Sure");
            String result = adminService.SureChange(Old, New, Sure, Admin_num);
            request.getSession().setAttribute("Result", result);
            request.getRequestDispatcher("/AdminChangeResult.jsp").forward(request, response);
        }
        if (action.equals("Reset")) {
            request.getRequestDispatcher("/AdminReset.jsp").forward(request, response);
        }
        if (action.equals("Sure_Reset")) {
            String identity = request.getParameter("identity");
            String account = request.getParameter("account");
            String password = request.getParameter("reset");
            if (adminService.SureChangeST(identity, account, password)) {
                request.getSession().setAttribute("Result", "重置成功");
                request.getRequestDispatcher("/AdminResetResult.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("Result", "不存在此人");
                request.getRequestDispatcher("/AdminResetResult.jsp").forward(request, response);
            }
        }
        if (action.equals("Exit")) {
            request.getSession().invalidate();
            request.getRequestDispatcher("/sign in.html").forward(request, response);
        }
    }
}



