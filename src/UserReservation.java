import java.util.List;

public class UserReservation {
    private User user;
    private List<Reservation> reservations;

    public UserReservation(User user, List<Reservation> reservations) {
        this.user = user;
        this.reservations = reservations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
