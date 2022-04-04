package App;

import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        CommandsList commandsList = new CommandsList(args[0]);

        while (true) {
            System.out.print("Enter command: ");
            String command = input.nextLine();
            commandsList.execute(input, command, false);
        }
    }
}
