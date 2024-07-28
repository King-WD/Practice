import java.util.List;
import java.util.ArrayList;

public class LoginService {
    public Boolean checkStudent(String S_num,String S_password) {
        LoginDAO studentDAO = new LoginDAO();
        List<User> users = studentDAO.getAccount_Student();
        for (User user : users) {
           if(user.getUserName().equals(S_num)&&user.getPassword().equals(S_password)) {
               return true;
           }
        }
        return false;
    }
    public Boolean checkTeacher(String T_num,String T_password) {
        LoginDAO teacherDAO = new LoginDAO();
        List<User> users = teacherDAO.getAccount_Teacher();
        for (User user : users) {
            if(user.getUserName().equals(T_num)&&user.getPassword().equals(T_password)) {
                return true;
            }
        }
        return false;
    }
    public Boolean checkAdmin(String Admin_num,String Admin_password) {
        LoginDAO adminDAO = new LoginDAO();
        List<User> users = adminDAO.getAccount_Admin();
        for (User user : users) {
            if(user.getUserName().equals(Admin_num)&&user.getPassword().equals(Admin_password)) {
                return true;
            }
        }
        return false;
    }
}