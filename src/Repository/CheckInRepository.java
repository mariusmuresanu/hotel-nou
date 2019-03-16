package Repository;

import Domain.CheckIn;
import Domain.CheckInValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CheckInRepository {
    private Map<Integer, CheckIn> storage = new HashMap<>();
    private CheckInValidator validator;


    /**
     * instantiates a repository for rooms
     * @param validator the validator used.
     */
    public CheckInRepository(CheckInValidator validator){
        this.validator = validator;
    }
    // metode CRUD: Create, Read, Update, Delete


    /**
     *
     * @param checkIn
     */
    public void add(CheckIn checkIn) {
        if (storage.containsKey(checkIn.getId())){
            throw new RuntimeException("Un checkIn cu Id-ul acesta deja exista");
        }

        validator.validate(checkIn);
        storage.put(checkIn.getId(), checkIn);
    }

    /***
     *
     * @param checkIn
     */
    public void update (CheckIn checkIn){
        if (!storage.containsKey(checkIn.getId())){
            throw new RuntimeException("There is no cheCkIn with this Id to update!");
        }

        validator.validate(checkIn);
        storage.put(checkIn.getId(), checkIn);
    }

    /**
     *
     * @return a list of all CheckIns.
     */
    public List<CheckIn>getAll(){
        return new ArrayList<>(storage.values());
        //return (List<Car>)storage.values();
        //return storage.values().toArray();
    }
}
