import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
    private OrderService orderService = new OrderService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String oId = request.getParameter("oId");
        if (action.equals("show")) {
            Reservation reservation = orderService.getOrdersByoId(Integer.parseInt(oId));
            List<Product> products = orderService.getProductsByoId(Integer.parseInt(oId));
            request.getSession().setAttribute("reservation", reservation);
            request.getSession().setAttribute("products", products);
            request.getRequestDispatcher("/showOrderDetails.jsp").forward(request, response);
        }
        if(action.equals("prechange")) {
            Reservation reservation = orderService.getOrdersByoId(Integer.parseInt(oId));
            List<Product> products = orderService.getProductsByoId(Integer.parseInt(oId));
            request.getSession().setAttribute("reservation", reservation);
            request.getSession().setAttribute("products", products);
            request.getRequestDispatcher("/modifyOrderDetails.jsp").forward(request, response);
        }
        if(action.equals("change")) {
            String status = request.getParameter("status");
            boolean updateSuccess = orderService.changeOrderStatus(Integer.parseInt(oId), status);
            if (updateSuccess) {
                response.sendRedirect("changeSuccess.jsp");
            }else {
                // 更新失败，重定向到错误页面或其他操作
                response.sendRedirect("changeError.jsp"); // 修改为实际的错误页面
            }
        }
    }
}

