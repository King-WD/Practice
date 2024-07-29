import org.apache.commons.dbcp2.DelegatingConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class StudentDAO {
    private final DataSource dataSource;

    public StudentDAO() {
        this.dataSource = DatabaseUtils.getDataSource();
    }

    //获取学生个人信息
    public Student getInfo(String S_num) {
        Student student= new Student();
        String sql = "SELECT * FROM student WHERE S_num=?";
        try (Connection  conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
             stmt.setString(1, S_num);
             try(ResultSet rs = stmt.executeQuery()) {
                 while (rs.next()) {
                     student.setS_num(rs.getString("S_num"));
                     student.setS_name(rs.getString("S_name"));
                     student.setS_gender(rs.getString("S_gender"));
                     student.setS_age(rs.getInt("S_age"));
                     student.setS_addr(rs.getString("S_addr"));
                     student.setS_credits(rs.getString("S_credits"));
                     student.setS_C_num(rs.getString("S_C_num"));
                 }
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Report> getReport(String S_num, String Course_semester) {
        List<Report> reports = new ArrayList<>();
        String sql = "SELECT * FROM report WHERE S_num = ? AND Course_semester = ?";
        try (Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, S_num);
            stmt.setString(2, Course_semester);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Report report = new Report();
                    report.setS_num(rs.getString("S_num"));
                    report.setCourse_num(rs.getString("Course_num"));
                    report.setGrade(rs.getInt("Grade"));
                    report.setCourse_semester(rs.getString("Course_semester"));
                    report.setT_name(rs.getString("T_name"));
                    reports.add(report);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public List<Class_Course> getClass_Courses(String C_name) {
        List<Class_Course> class_courses = new ArrayList<>();
        String sql = "SELECT class.C_num,C_name,course.Course_num,Course_name," +
                "Course_semester,Course_credit,Course_time FROM class,course,`class-course` " +
                "WHERE C_name=? and class.C_num=`class-course`.Class_num and `class-course`.Course_num=course.Course_num";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, C_name);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Class_Course class_course=new Class_Course();
                    class_course.setC_num(rs.getString("C_num"));
                    class_course.setC_name(rs.getString("C_name"));
                    class_course.setCourse_num(rs.getString("Course_num"));
                    class_course.setCourse_name(rs.getString("Course_name"));
                    class_course.setCourse_semester(rs.getString("Course_semester"));
                    class_course.setCourse_credit(rs.getString("Course_credit"));
                    class_course.setCourse_time(rs.getString("Course_time"));
                    class_courses.add(class_course);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return class_courses;
    }

    public List<Course_Credit> getCourse_Credits(String S_num) {
        List<Course_Credit> course_credits= new ArrayList<>();
        String sql = "SELECT student.S_num,course.Course_name,course.Course_credit " +
                "FROM report,student,course,class WHERE student.S_num=? and student.S_num=report.S_num " +
                "and report.Course_num=course.Course_num and class.C_num=student.S_C_num";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, S_num);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Course_Credit course_credit = new Course_Credit();
                    course_credit.setS_num(rs.getString("S_num"));
                    course_credit.setCourse_name(rs.getString("Course_name"));
                    course_credit.setCourse_credit(rs.getString("Course_credit"));
                    course_credits.add(course_credit);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course_credits;
    }

    public String getOld(String S_num){
        String sql="SELECT S_password FROM `student-account` WHERE S_num=?";
        String Old="";
        try(Connection  conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,S_num);
            try(ResultSet  rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Old = rs.getString("S_password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Old;
    }

    public void changePassword(String S_num,String Change_Password) {
        String sql = "UPDATE `student-account` set S_password=? where S_num=?";
        try (Connection  conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, Change_Password);
            stmt.setString(2,S_num);
            int  rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

