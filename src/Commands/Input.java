package Commands;

import Collections.*;

import java.util.Scanner;

/**
 * Класс в котором обрабатывается входящий поток для Команд работающих с полями аргумента
 * (Создание элемента коллекции)
 */
public class Input {
    
    private String name;
    private VehicleType vehicleType;
    private Float x;
    private Float y;
    private Float enginePower;
    private Long capacity;
    private Double distanceTravelled;

    private Scanner input;
    private boolean silent;
    
    public Input(Scanner input, boolean silent) {
        this.input = input;
        this.silent = silent;
    }

    public void nameInput() {
        while (true) {
            if (!silent) 
                System.out.print("Enter name: ");
            name = input.nextLine();
            if (name.trim().length() > 0) break;
            if (!silent) 
                System.out.println("Invalid input. The string must not be empty!");
            else {
                System.out.println("Wrong script file!!!");
                System.exit(1);
            }
        }
    }

    public void xInput() {
        boolean stop = false;
        while (!stop) {
            if (!silent) 
                System.out.print("Enter x coordinate: ");
            String line = input.nextLine();
            try {
                x = Float.parseFloat(line);
                stop = true;
            } catch (Exception e) {
                if (!silent) {
                    System.out.println("Please enter a Float number!");
                } else {
                    System.out.println("Wrong script file!!!");
                    System.exit(1);
                }
            }
        }
    }

    public void yInput() {
        boolean stop = false;
        while (!stop) {
            if (!silent) 
                System.out.print("Enter y coordinate: ");
            String line = input.nextLine();
            try {
                y = Float.parseFloat(line);
                stop = true;
            } catch (Exception e) {
                if (!silent) {
                    System.out.println("Please enter a Float number!");
                } else {
                    System.out.println("Wrong script file!!!");
                    System.exit(1);
                }
            }
        }
    }
    

    public void enginePowerInput() {
        boolean stop = false;
        while (!stop) {
            if (!silent) 
                System.out.print("Enter engine power: ");
            String line = input.nextLine();
            try {
                enginePower = Float.parseFloat(line);
                if (enginePower <= 0) throw new Exception();
                stop = true;
            } catch (Exception e) {
                if (!silent) {
                    System.out.println("Please enter a positive Float number!");
                } else {
                    System.out.println("Wrong script file!!!");
                    System.exit(1);
                }
            }
        }
    }

    public void capacityInput() {
        boolean stop = false;
        while (!stop) {
            if (!silent) 
                System.out.print("Enter capacity: ");
            String line = input.nextLine();
            try {
                capacity = Long.parseLong(line);
                if (capacity <= 0) throw new Exception();
                stop = true;
            } catch (Exception e) {
                if (!silent) {
                    System.out.println("Please enter a positive Long number!");
                } else {
                    System.out.println("Wrong script file!!!");
                    System.exit(1);
                }
            }
        }
    }

    public void distanceTravelledInput() {
        boolean stop = false;
        while (!stop) {
            if (!silent) 
                System.out.print("Enter distance travelled: ");
            String line = input.nextLine();
            try {
                distanceTravelled = Double.parseDouble(line);
                if (distanceTravelled <= 0) throw new Exception();
                stop = true;
            } catch (Exception e) {
                if (!silent) {
                    System.out.println("Please enter a positive Double number!");
                } else {
                    System.out.println("Wrong script file!!!");
                    System.exit(1);
                }
            }
        }
    }
    
    public void vehicleTypeInput() {
        boolean stop = false;
        while (!stop) {
            if (!silent) 
                System.out.print("Enter type (HELICOPTER, SHIP, CHOPPER): ");
            String line = input.nextLine();
            try {
                vehicleType = VehicleType.valueOf(line);
                stop = true;
            } catch (Exception e) {
                if (!silent) {
                    System.out.println("Enter a word from the suggested list!");
                } else {
                    System.out.println("Wrong script file!!!");
                    System.exit(1);
                }
            }
        }
    }

    public Vehicle createElement(Integer id) {
        return new Vehicle(id, name, new Coordinates(x, y), enginePower, capacity, distanceTravelled, vehicleType);
    }

    public Vehicle resultElement(Integer id) {
        nameInput();
        xInput();
        yInput();
        enginePowerInput();
        capacityInput();
        distanceTravelledInput();
        vehicleTypeInput();
        return createElement(id);
    }
}
