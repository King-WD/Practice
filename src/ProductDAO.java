import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DataSource dataSource;

    public ProductDAO() {
        this.dataSource = DatabaseUtils.getDataSource();
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT pId, pName, pPrice, pCount FROM product";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setpId(rs.getInt("pId"));
                product.setpName(rs.getString("pName"));
                product.setpPrice(rs.getString("pPrice"));
                product.setpCount(rs.getString("pCount"));
                products.add(product);
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
        return products;
    }

    public boolean updateProductCount(int pId, String pCount) {
        String sql = "UPDATE product SET pCount = ? WHERE pId = ?";
        Connection conn= null;
        PreparedStatement stmt = null;
        int rs =0;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pCount);
            stmt.setInt(2, pId);
            rs = stmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}