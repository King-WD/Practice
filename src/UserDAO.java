import java.sql.*;
import java.util.*;
import javax.sql.DataSource;

public class UserDAO {
    private DataSource dataSource;

    public UserDAO() {
        this.dataSource = DatabaseUtils.getDataSource();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT uId, uName, uPw FROM user";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("uId"));
                user.setUserName(rs.getString("uName"));
                user.setPassword(rs.getString("uPw"));
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


