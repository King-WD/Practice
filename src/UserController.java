import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;

@WebServlet("/allUsers")
public class UserController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        List<UserReservation> userReservations = userService.getAllUsersWithOrders();
        request.getSession().setAttribute("userReservations", userReservations);
        request.getRequestDispatcher("/allUsers.jsp").forward(request, response);
    }
}

