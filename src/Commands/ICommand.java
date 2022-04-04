package Commands;

import java.util.Scanner;

public interface ICommand {
    void execute(Scanner input, String args[], boolean silent);
}
