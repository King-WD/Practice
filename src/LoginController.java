import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num= request.getParameter("num");
        String password = request.getParameter("password");
        String canvas_auto= request.getParameter("canvas_auto");
        String canvas_input=request.getParameter("canvas_input");
        String identity = request.getParameter("t1");

        LoginService userService = new LoginService();
        if(identity.equals("学生")){
          if(userService.checkStudent(num,password)) {
              if(canvas_auto.equals(canvas_input)){
                  request.getSession().setAttribute("S_num",num);
                  request.getRequestDispatcher("/Student.jsp").forward(request, response);
              }else{
                  request.getSession().setAttribute("excuse","验证码错误");
                  request.getRequestDispatcher("/login fail.jsp").forward(request, response);
              }
          }else{
              request.getSession().setAttribute("excuse","用户名或密码错误");
              request.getRequestDispatcher("/login fail.jsp").forward(request, response);
          }
        }
        if(identity.equals("教师")){
            if(userService.checkTeacher(num,password)) {
                if(canvas_auto.equals(canvas_input)){
                    request.getSession().setAttribute("T_num",num);
                    request.getRequestDispatcher("/Teacher.jsp").forward(request, response);
                }else{
                    request.getSession().setAttribute("excuse","验证码错误");
                    request.getRequestDispatcher("/login fail.jsp").forward(request, response);
                }
            }else{
                request.getSession().setAttribute("excuse","用户名或密码错误");
                request.getRequestDispatcher("/login fail.jsp").forward(request, response);
            }
        }
        if(identity.equals("管理员")){
            if(userService.checkAdmin(num,password)) {
                if(canvas_auto.equals(canvas_input)){
                    request.getSession().setAttribute("Admin_num",num);
                    request.getRequestDispatcher("/Admin.jsp").forward(request, response);
                }else{
                    request.getSession().setAttribute("excuse","验证码错误");
                    request.getRequestDispatcher("/login fail.jsp").forward(request, response);
                }
            }else{
                request.getSession().setAttribute("excuse","用户名或密码错误");
                request.getRequestDispatcher("/login fail.jsp").forward(request, response);
            }
        }
    }
}

