package Domain;

public class CheckInValidator {
    /**
     * Validates a checkIn
     * @param checkIn to validate
     * @throws RuntimeException if there are validation errors.
     */
    public void validate(CheckIn checkIn){
        if (checkIn.getDaysNumber() <= 0){
            throw new RuntimeException("The number of days cannot be 0 or negative!");
        }
        if (checkIn.getPersNumber() <= 0 ){
            throw new RuntimeException("The number of person cannot be 0 or negative!");
        }
    }
}
