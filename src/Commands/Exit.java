package Commands;

import java.util.Scanner;
/**
 * Команда Exit
 */
public class Exit implements ICommand{
    public void execute(Scanner input, String args[], boolean silent) {
        System.out.println("System exit");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "exit - Exit from the application";
    }

}
