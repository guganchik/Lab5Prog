package Commands;

import App.CollectionManager;
import java.util.Scanner;
/**
 * Команда MaxById
 */
public class MaxById implements ICommand{

    private final CollectionManager collectionManager;

    public MaxById(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(Scanner input, String args[], boolean silent) {
        if(collectionManager.max_by_id() ){
            if(!silent){System.out.println("Operation success (MaxById)");}
        } else {
            if(!silent){System.out.println("Operation error (MaxById)");}
        }
    }

    @Override
    public String toString() {
        return "max_by_id - Display any object from the collection whose id field value is the maximum";
    }

}

