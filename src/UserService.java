import java.util.List;
import java.util.ArrayList;

public class UserService {
    public List<UserReservation> getAllUsersWithOrders() {
        UserDAO userDAO = new UserDAO();
        OrderDAO orderDAO = new OrderDAO();
        List<User> users = userDAO.getAllUsers();
        List<Reservation> reservations = orderDAO.getAllOrders();
        List<UserReservation> userReservations = new ArrayList<>();
        for (User user : users) {
            List<Reservation> userOrders = new ArrayList<>();
            for (Reservation reservation : reservations) {
                if (reservation.getuId()==user.getUserId()) {
                    userOrders.add(reservation);
                }
            }
            userReservations.add(new UserReservation(user, userOrders));
        }
        return userReservations;
    }
}