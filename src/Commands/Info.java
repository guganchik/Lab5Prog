package Commands;

import App.CollectionManager;
import java.util.Scanner;
/**
 * Команда Info
 */
public class Info implements ICommand{
    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute (Scanner input, String args[], boolean silent){
        if(collectionManager.info()){
            if(!silent){System.out.println("Operation success (Info)");}
        } else {
            if(!silent){System.out.println("Operation error (Info)");}
        }

    }

    @Override
    public String toString() {
        return "info - Print information about the collection to the standard output stream (type, initialization date, number of elements, etc.)";
    }


}
