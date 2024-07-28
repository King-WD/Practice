import java.sql.*;
import java.util.*;
import javax.sql.DataSource;

public class LoginDAO {
    private DataSource dataSource;

    public LoginDAO() {
        this.dataSource = DatabaseUtils.getDataSource();
    }

    public List<User> getAccount_Student() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM `student-account` ";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("S_num"));
                user.setPassword(rs.getString("S_password"));
                users.add(user);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return users;
    }

    public List<User> getAccount_Teacher() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM `teacher-account` ";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("T_num"));
                user.setPassword(rs.getString("T_password"));
                users.add(user);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return users;
    }

    public List<User> getAccount_Admin() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM `admin-account` ";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("Admin_num"));
                user.setPassword(rs.getString("Admin_password"));
                users.add(user);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return users;
    }
}


