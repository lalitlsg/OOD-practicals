import java.util.Date;

public class Show {
    private static int idCounter = 0;
    private int id;
    private Date showTime;
    private int availableSeats;
    private Movie movie;
    private Theatre theatre;

    public Show(Date showTime, Movie movie, Theatre theatre) {
        idCounter += 1;
        this.id = idCounter;
        this.showTime = showTime;
        this.movie = movie;
        this.theatre = theatre;
        this.availableSeats = theatre.getCapacity();
        theatre.getShows().add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public void updateShow() {}

    public synchronized Ticket bookTicket(RegisteredUser user, int seats) {
        if (availableSeats >= seats && seats > 0) {
            Ticket ticket = new Ticket();
            availableSeats -= seats;
            ticket.setOwnerName(user.getName());
            ticket.setBookedShow(this);
            ticket.setBookingTime(new Date());
            ticket.setNoOfSeats(seats);
            System.out.println("Successfully Booked");
            user.getBookingHistory().add(ticket);
            return ticket;
        } else {
            System.out.println("Seats not available");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", showTime=" + showTime +
                ", availableSeats=" + availableSeats +
                ", movie=" + movie +
                ", theatre=" + theatre +
                '}';
    }
}
