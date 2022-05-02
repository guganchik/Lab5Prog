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


        try {
            String vehicleType = args[0];
            VehicleType.valueOf(vehicleType);

            if(collectionManager.filter_greater_than_type(vehicleType) && !silent){
                if(!silent){System.out.println("Operation success (FilterGreaterThanType)");}
            } else {
                if(!silent){System.out.println("Operation error (FilterGreaterThanType)");}
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            if(!silent) {
                System.out.println("Invalid input! Type not entered");
            }
        }
        catch (Exception e) {
            if(!silent) {
                System.out.println("This type of vehicle does not exist.");
            }
        }

    }

    @Override
    public String toString() {
        return "filter_greater_than_type type - Display elements whose type field value is greater than the given one";
    }

}
