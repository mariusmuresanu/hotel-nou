import Domain.CheckInValidator;
import Repository.CheckInRepository;
import Service.CheckInService;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        CheckInValidator validator = new CheckInValidator();
        CheckInRepository repository = new CheckInRepository(validator);
        CheckInService service = new CheckInService(repository);

        service.enterRoom(1, 3, 101, 4);

        Console console = new Console(service);
        console.run();

    }
}
