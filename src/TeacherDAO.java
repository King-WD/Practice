import org.apache.commons.dbcp2.DelegatingConnection;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class TeacherDAO{
    private final DataSource dataSource;

    public TeacherDAO() {
        this.dataSource = DatabaseUtils.getDataSource();
    }

    //获取教师个人信息
    public Teacher getInfo(String T_num) {
        Teacher teacher= new Teacher();
        String sql = "SELECT * FROM teacher WHERE T_num=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, T_num);
           try(ResultSet rs = stmt.executeQuery()) {
               while (rs.next()) {
                   teacher.setT_num(rs.getString("T_num"));
                   teacher.setT_name(rs.getString("T_name"));
                   teacher.setT_gender(rs.getString("T_gender"));
                   teacher.setT_age(rs.getString("T_age"));
                   teacher.setT_title(rs.getString("T_title"));
                   teacher.setT_tele(rs.getString("T_tele"));
               }
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    public List<Teacher_Course> getTeacher_Courses(String T_num, String Course_semester) {
        List<Teacher_Course> teacher_courses = new ArrayList<>();
        String sql = "SELECT T_num,teacher.T_name,Course_num,Course_name,Course_credit,Course_time" +
                " FROM teacher,course WHERE teacher.T_name=course.T_name AND Course_semester = ?  ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, Course_semester);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Teacher_Course teacher_course = new Teacher_Course();
                    teacher_course.setT_num(rs.getString("T_num"));
                    teacher_course.setT_name(rs.getString("T_name"));
                    teacher_course.setCourse_num(rs.getString("Course_num"));
                    teacher_course.setCourse_name(rs.getString("Course_name"));
                    teacher_course.setCourse_credit(rs.getString("Course_credit"));
                    teacher_course.setCourse_time(rs.getString("Course_time"));
                    teacher_courses.add(teacher_course);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher_courses;
    }

    public List<String> getAverage_Courses(String T_num) {
        List<String> average_courses = new ArrayList<>();
        String sql = "SELECT Course_num FROM course,teacher " +
                "WHERE T_num=? AND teacher.T_name=course.T_name";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, T_num);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    average_courses.add(rs.getString("Course_num"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return average_courses;
    }

    public Average getAverage_Grade(String Course_num) {
        Average average_grade= new Average();
        String sql = "SELECT Course_num,avg(Grade) AS average_grade FROM report WHERE Course_num=? GROUP BY Course_num ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, Course_num);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    average_grade.setCourse_num(rs.getString("Course_num"));
                    average_grade.setAverage(rs.getInt("average_grade"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return average_grade;
    }

    public List<Sort> getGrade_Sort(String Course_num) {
        List<Sort> grade_sorts= new ArrayList<>();
        String sql = "SELECT Course_num,S_num,Grade FROM report WHERE Course_num=? ORDER BY Grade DESC";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, Course_num);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Sort sort = new Sort();
                    sort.setCourse_num(rs.getString("Course_num"));
                    sort.setS_num(rs.getString("S_num"));
                    sort.setGrade(rs.getString("Grade"));
                    grade_sorts.add(sort);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade_sorts;
    }

    public int Delete(String Course_num,String S_num) {
        String sql = "DELETE FROM report WHERE Course_num=? AND S_num=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement   stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, Course_num);
            stmt.setString(2, S_num);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int Save(String Course_num,String S_num,String Grade) {
        String sql = "UPDATE report SET Grade=? WHERE Course_num=? AND S_num=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, Grade);
            stmt.setString(2, Course_num);
            stmt.setString(3, S_num);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getOld(String T_num){
        String sql="SELECT T_password FROM `teacher-account` WHERE T_num=?";
        String Old="";
        try(Connection  conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,T_num);
            try(ResultSet  rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Old = rs.getString("T_password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Old;
    }

    public void changePassword(String T_num,String Change_Password) {
        String sql = "UPDATE `teacher-account` SET T_password=? WHERE T_num=?";
        try(Connection  conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, Change_Password);
            stmt.setString(2,T_num);
            int  rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

