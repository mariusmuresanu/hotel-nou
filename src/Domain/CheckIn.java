package Domain;

public class CheckIn {
    private int id, persNumber, roomNumber, daysNumber;
    private boolean checkOut;
    private String feedback;
    private int rating;

    @Override
    public String toString() {
        return "CheckIn{" +
                "id=" + id +
                ", persNumber=" + persNumber +
                ", roomNumber=" + roomNumber +
                ", daysNumber=" + daysNumber +
                ", checkOut=" + checkOut +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }

    public CheckIn(int id, int persNumber, int roomNumber, int daysNumber) {
        this.id = id;
        this.persNumber = persNumber;
        this.roomNumber = roomNumber;
        this.daysNumber = daysNumber;
        checkOut = false;
    }

    public CheckIn(int id, int persNumber, int roomNumber, int daysNumber, boolean checkOut, String feedback, int rating) {
        this.id = id;
        this.persNumber = persNumber;
        this.roomNumber = roomNumber;
        this.daysNumber = daysNumber;
        this.checkOut = checkOut;
        this.feedback = feedback;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersNumber() {
        return persNumber;
    }

    public void setPersNumber(int persNumber) {
        this.persNumber = persNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getDaysNumber() {
        return daysNumber;
    }

    public void setDaysNumber(int daysNumber) {
        this.daysNumber = daysNumber;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
