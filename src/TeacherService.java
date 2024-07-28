import java.util.List;

public class TeacherService {
    private final TeacherDAO teacherDAO;

    public TeacherService() {
        this.teacherDAO= new TeacherDAO();
    }

    public Teacher displayInfo(String T_num) {
        return teacherDAO.getInfo(T_num);
    }

    public List<Teacher_Course> displayTeacher_Courses(String T_num,String Course_semester) {
        return teacherDAO.getTeacher_Courses(T_num,Course_semester);
    }

    public List<String> displayAverage_Courses(String T_num) {
        return teacherDAO.getAverage_Courses(T_num);
    }

    public Average displayAverage_Grade(String Course_num) {
        return teacherDAO.getAverage_Grade(Course_num);
    }

    public List<Sort> displaySorts(String Course_num) {
        return teacherDAO.getGrade_Sort(Course_num);
    }

    public boolean displayDelete(String Course_num,String S_num) {
        return teacherDAO.Delete(Course_num, S_num) > 0;
    }

    public boolean displaySave(String Course_num,String S_num,String Grade) {
        return teacherDAO.Save(Course_num, S_num, Grade) > 0;
    }

    public String SureChange(String Old,String New,String Sure,String T_num){
        if(!Old.equals(teacherDAO.getOld(T_num))){
            return "原密码错误或为空!请重新输入";
        }
        else if(!New.equals(Sure)){
            return "两次密码不相等!请重新输入";
        }
        else{
            teacherDAO.changePassword(T_num,New);
            return "密码修改成功";
        }
    }
}
