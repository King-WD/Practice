import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class OrderDAO {
    private DataSource dataSource;

    public OrderDAO() {
        this.dataSource = DatabaseUtils.getDataSource();
    }

    // 获取所有订单
    public List<Reservation> getAllOrders() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT oId, uId, oTime, oTotal, oStatus FROM reservation";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setoId(rs.getInt("oId"));
                reservation.setuId(rs.getInt("uId"));
                reservation.setoTime(rs.getString("oTime"));
                reservation.setoTotal(rs.getString("oTotal"));
                reservation.setoStatus(rs.getString("oStatus"));
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    public boolean updateReservationStatus(int oId, String status) {
        String sql = "UPDATE reservation SET oStatus = ? WHERE oId = ?";
        Connection conn= null;
        PreparedStatement stmt = null;
        int rs =0;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setInt(2, oId);
            if(oId%2==0) {
                rs = stmt.executeUpdate();
                System.out.println(rs);
                return rs>0;
            }
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

    public Reservation getReservationsByoId(int oId) {
        Reservation reservation = new Reservation();
        String sql = "SELECT oId, uId, oTime, oTotal, oStatus FROM reservation WHERE oId = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, oId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    reservation.setoId(rs.getInt("oId"));
                    reservation.setuId(rs.getInt("uId"));
                    reservation.setoTime(rs.getString("oTime"));
                    reservation.setoTotal(rs.getString("oTotal"));
                    reservation.setoStatus(rs.getString("oStatus"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    public List<Product> getProductByoId(int oId) {
        List<Product> products = new ArrayList<>();
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT pId FROM details WHERE oId = ?";
        String sql2="SELECT pId,pName,pPrice,pCount FROM product WHERE pId= ?";
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, oId);
            rs = stmt.executeQuery();

            while (rs.next()) {
             int pId=rs.getInt("pId");
             stmt=conn.prepareStatement(sql2);
             stmt.setInt(1, pId);
             rs = stmt.executeQuery();

             while (rs.next()) {
                 Product product = new Product();
                 product.setpId(rs.getInt("pId"));
                 product.setpName(rs.getString("pName"));
                 product.setpPrice(rs.getString("pPrice"));
                 product.setpCount(rs.getString("pCount"));
                 products.add(product);
             }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}

