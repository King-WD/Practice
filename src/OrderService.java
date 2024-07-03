import java.util.List;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDAO();
    }

    public boolean changeOrderStatus(int oId, String status) {
        return orderDAO.updateReservationStatus(oId,status);
    }

    //获取单个订单
    public Reservation getOrdersByoId(int oId) {
        return orderDAO.getReservationsByoId(oId);
    }

    public List<Product> getProductsByoId(int oId) {
        return orderDAO.getProductByoId(oId);
    }
    // 获取所有订单
    public List<Reservation> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}
