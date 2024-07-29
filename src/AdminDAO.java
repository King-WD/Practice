import org.apache.commons.dbcp2.DelegatingConnection;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class AdminDAO{
    private final DataSource dataSource;

    public AdminDAO() {
        this.dataSource = DatabaseUtils.getDataSource();
    }

    public Teacher Query(String T_num) {
        Teacher teacher= new Teacher();
        String sql = "SELECT * FROM teacher WHERE T_num=?";
        try ( Connection conn = dataSource.getConnection();
              PreparedStatement   stmt = conn.prepareStatement(sql)){
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

    public int Insert(String[] T_infos){
        String sql = "INSERT INTO teacher (T_num,T_name,T_gender,T_age,T_title,T_tele) VALUES (?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, T_infos[0]);
            stmt.setString(2, T_infos[1]);
            stmt.setString(3, T_infos[2]);
            stmt.setString(4, T_infos[3]);
            stmt.setString(5, T_infos[4]);
            stmt.setString(6, T_infos[5]);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int Delete(String T_num) {
        String sql = "DELETE FROM teacher WHERE T_num=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, T_num);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int Save(String[] selects) {
        String sql = "UPDATE teacher SET T_num = ?,T_name=?,T_gender=?,T_age=?,T_title=?,T_tele=?  WHERE T_num = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, selects[0]);
            stmt.setString(2, selects[1]);
            stmt.setString(3, selects[2]);
            stmt.setString(4, selects[3]);
            stmt.setString(5, selects[4]);
            stmt.setString(6, selects[5]);
            stmt.setString(7, selects[0]);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Student QueryS(String S_num) {
        Student student= new Student();
        String sql = "SELECT * FROM student WHERE S_num=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
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

    public int InsertS(String[] S_infos){
        String sql = "INSERT INTO student (S_num,S_name,S_gender,S_age,S_addr,S_credits,S_C_num) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, S_infos[0]);
            stmt.setString(2, S_infos[1]);
            stmt.setString(3, S_infos[2]);
            stmt.setString(4, S_infos[3]);
            stmt.setString(5, S_infos[4]);
            stmt.setString(6, S_infos[5]);
            stmt.setString(7, S_infos[6]);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int DeleteS(String S_num) {
        String sql = "DELETE FROM student WHERE S_num=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, S_num);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int SaveS(String[] selects) {
        String sql = "UPDATE student SET S_num = ?,S_name=?,S_gender=?,S_age=?,S_addr=?,S_credits=?,S_C_num=?  WHERE S_num = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, selects[0]);
            stmt.setString(2, selects[1]);
            stmt.setString(3, selects[2]);
            stmt.setString(4, selects[3]);
            stmt.setString(5, selects[4]);
            stmt.setString(6, selects[5]);
            stmt.setString(7, selects[6]);
            stmt.setString(8, selects[0]);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<String> Total(String S_addr) {
        String sql = "SELECT ? AS S_addr,count(S_num) AS S_total FROM student WHERE S_addr LIKE ?";
        List<String> total = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement   stmt = conn.prepareStatement(sql)){
            stmt.setString(1, S_addr);
            stmt.setString(2, '%'+S_addr+'%');
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    total.add(rs.getString("S_addr"));
                    total.add(rs.getString("S_total"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public String getOld(String Admin_num){
        String sql="SELECT Admin_password FROM `admin-account` WHERE Admin_num=?";
        String Old="";
        try (Connection  conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,Admin_num);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Old = rs.getString("Admin_password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Old;
    }

    public void changePassword(String Admin_num,String Change_Password) {
        String sql = "UPDATE `admin-account` SET Admin_password=? WHERE Admin_num=?";
        try (Connection  conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, Change_Password);
            stmt.setString(2,Admin_num);
            int  rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean changePasswordS(String S_num,String Change_Password) {
        String sql ="SELECT S_num FROM student WHERE S_num=?";
        String sql1 = "UPDATE `student-account` set S_password=? where S_num=?";
        List<String> nums = new ArrayList<>();
        try (Connection  conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             PreparedStatement stmt1 = conn.prepareStatement(sql1)){
            stmt.setString(1, S_num);
            stmt1.setString(1, Change_Password);
            stmt1.setString(2,S_num);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String num = rs.getString("S_num");
                    nums.add(num);
                }
            }
            if(nums.contains(S_num)){stmt1.executeUpdate(); return true;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changePasswordT(String T_num,String Change_Password) {
        String sql = "SELECT T_num FROM teacher WHERE T_num=?";
        String sql1 = "UPDATE `teacher-account` SET T_password=? WHERE T_num=?";
        List<String> nums = new ArrayList<>();
        try (Connection  conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        PreparedStatement stmt1 = conn.prepareStatement(sql1)){
            stmt.setString(1, T_num);
            stmt1.setString(1, Change_Password);
            stmt1.setString(2,T_num);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String num = rs.getString("T_num");
                    nums.add(num);
                }
            }
            if(nums.contains(T_num)){stmt1.executeUpdate();return true;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

