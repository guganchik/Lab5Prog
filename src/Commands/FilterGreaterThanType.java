package Commands;

import App.CollectionManager;
import Collections.VehicleType;
import java.util.Scanner;
/**
 * Команда FilterGreaterThanType
 */
public class FilterGreaterThanType implements ICommand{
    private final CollectionManager collectionManager;

    public FilterGreaterThanType(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(Scanner input, String[] args, boolean silent) {
        String vehicleType = args[0];

        try {
            VehicleType.valueOf(vehicleType);
            collectionManager.filter_greater_than_type(vehicleType);
        } catch (Exception e) {
            System.out.println("This type of vehicle does not exist.");
        }

    }

    @Override
    public String toString() {
        return "filter_greater_than_type type - Display elements whose type field value is greater than the given one";
    }

}
