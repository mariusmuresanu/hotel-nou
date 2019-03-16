package Service;

import Domain.CheckIn;
import Domain.RoomAverageRatingViewModel;
import Repository.CheckInRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckInService {

    private CheckInRepository repository;

    /**
     *
     * @param repository
     */
    public CheckInService(CheckInRepository repository){
        this.repository = repository;
    }

    /**
     *
     * @param id
     * @param persNumber
     * @param roomNumber
     * @param daysNumber
     */
    public void enterRoom(int id, int persNumber, int roomNumber, int daysNumber){
        CheckIn checkIn = new CheckIn(id, persNumber, roomNumber, daysNumber);
        List<CheckIn> checkIns = repository.getAll();
        for (CheckIn c : checkIns){
            if (c.getRoomNumber() == roomNumber && !c.isCheckOut()){
                throw new RuntimeException("That room is allready taken!");
            }
        }
        repository.add(checkIn);
    }

    /**
     *
     * @param roomNumber
     * @param feedback
     * @param rating
     */
    public void exitRoom(int roomNumber, String feedback, int rating){
        CheckIn checkInOnRoom = null;
        List<CheckIn>checkIns = repository.getAll();
        for (CheckIn c : checkIns){
            if (c.getRoomNumber() == roomNumber && !c.isCheckOut()){
                checkInOnRoom = c;
            }
        }
        if (checkInOnRoom != null){
            checkInOnRoom.setFeedback(feedback);
            checkInOnRoom.setRating(rating);
            checkInOnRoom.setCheckOut(true);
            repository.update(checkInOnRoom);
        }else {
            throw new RuntimeException("There is no checkIn on the given room number");
        }
    }
    public List<RoomAverageRatingViewModel> getRoomRatingAverage() {
        List<RoomAverageRatingViewModel> results = new ArrayList<>();
        Map<Integer, List<Double>> ratingForRooms = new HashMap<>();

        for (CheckIn c : repository.getAll()) {
            if (c.isCheckOut()) {
                int roomNumber = c.getRoomNumber();
                double rating = c.getRating();
                if (!ratingForRooms.containsKey(roomNumber)) {
                    ratingForRooms.put(roomNumber, new ArrayList<>());
                }
                ratingForRooms.get(roomNumber).add(rating);
            }
        }
        for (int roomNumber : ratingForRooms.keySet()) {
            List<Double> ratings = ratingForRooms.get(roomNumber);
            double average = 0;
            for (double r : ratings) {
                average += r;
            }
            average /= ratings.size();
            results.add(new RoomAverageRatingViewModel(roomNumber, average));
        }
            //        results.sort((r1, r2) -> r1.getAveragePrice() > r2.getAveragePrice() ? -1 : 1);

            results.sort((p1, p2) -> {
                if (p1.getAverageRating() > p2.getAverageRating())
                    return -1;
                else if (p1.getAverageRating() == p2.getAverageRating())
                    return 0;
                else return 1;
            });
            return results;
        }

        public List<CheckIn> getAll() {
        return repository.getAll();
        }

    }
