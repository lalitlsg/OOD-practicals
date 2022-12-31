import java.util.ArrayList;

public class RegisteredUser extends User {
    private ArrayList<Ticket> bookingHistory;

    public RegisteredUser( String name) {
        super(name);
        this.bookingHistory = new ArrayList<>();
    }

    public ArrayList<Ticket> getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(ArrayList<Ticket> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    public void cancelTicket(Ticket ticket) {}
}
