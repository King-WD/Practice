import java.util.List;

public class StudentService {
    private final StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO= new StudentDAO();
    }

    public Student displayInfo(String S_num) {
        return studentDAO.getInfo(S_num);
    }

    public List<Report> displayReport(String S_num,String Course_semester) {
        return studentDAO.getReport(S_num,Course_semester);
    }

    public List<Class_Course> displayClass_Course(String C_name) {
        return studentDAO.getClass_Courses(C_name);
    }

    public List<Course_Credit> displayCourse_Credit(String S_num) {
        return studentDAO.getCourse_Credits(S_num);
    }

    public String SureChange(String Old,String New,String Sure,String S_num){
        if(!Old.equals(studentDAO.getOld(S_num))){
            return "原密码错误或为空!请重新输入";
        }
        else if(!New.equals(Sure)){
            return "两次密码不相等!请重新输入";
        }
        else{
            studentDAO.changePassword(S_num,New);
            return "密码修改成功";
        }
    }
}
