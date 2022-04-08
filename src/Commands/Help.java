package Commands;

import App.CommandsList;
import java.util.Scanner;
/**
 * Команда Help
 */
public class Help implements ICommand{
    public void execute(Scanner input, String args[], boolean silent) {
        for (ICommand value : CommandsList.commands.values()) {
                System.out.println(value.toString());
        }
    }

    @Override
    public String toString() {
        return "help - Show this help";
    }
}

