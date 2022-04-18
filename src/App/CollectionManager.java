package App;

import Collections.Vehicle;
import Collections.VehicleType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;

/**
 * Класс управления коллекцией. Здесь происходят все изменения коллекции.
 */
public class CollectionManager {

    private TreeSet<Vehicle> collection;
    static Date collectionDate = new Date();
    private Integer vehicleId = 0;
    private Storage storage;
    private CommandsList commandsList;
    
    String filename;

    public CollectionManager(String filename) {
        collection = new TreeSet();
        this.filename = filename;
        storage = new Storage(collection, filename);
        vehicleId = read();
    }

    public int read() {
        return storage.read();
    }

    /**
     * Запись в файл
     */
    public void save() {
        storage.write();
    }

    /**
     *
     * @return Коллекция
     */
    public TreeSet<Vehicle> getCollection() {
        return collection;
    }

    /**
     * Информация о коллекции
     */
    public void info() {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(Const.timeFormat.parse(String.valueOf(collectionDate)));
        } catch (Exception e) {
        }

        System.out.println("Type -" + collection.getClass() + "\n" +
                "Creation date - " +  calendar.getTime() + "\n"+
                        "Amount of elements - " + collection.size());
    }

    /**
     * Вывести элементы коллекции в порядке возрастания
     */
    public void print_ascending() {
        Set<Vehicle> orderTreeSet = new TreeSet<Vehicle>(Comparator.comparingDouble(Vehicle::getId));
        orderTreeSet.addAll(collection);
        for (Vehicle vehicle: orderTreeSet) {
            System.out.println(vehicle.toString());
        }

    }
    /**
     * Вывести элементы коллекции
     */
    public void show() {
        for (Vehicle vehicle: collection) {
            System.out.println(vehicle.toString());
        }
    }

    /**
     * Очистить коллекцию
     */
    public void clear() {
        collection.clear();
    }

    /**
     * Новое Id для следующего эл-та
     * @return новый Id
     */
    public int getNewId() {
        return ++vehicleId;
    }

    /**
     * Добавить элемент в коллекцию
     */
    public void add(Vehicle v) {
        collection.add(v);
    }

    /**
     * Добавить элемент в коллекцию если  его EnginePower и Capacity больше максимального значения данных полей в этой коллекции
     */
    public void add_if_max(Vehicle element) {Iterator<Vehicle> itr = collection.iterator();
        while (itr.hasNext()) {
            Vehicle v = itr.next();
            if (v.getEnginePower() > element.getEnginePower() || v.getCapacity() > element.getCapacity()) {
                break;
            }
            else if(v.getEnginePower() < element.getEnginePower() && v.getCapacity() < element.getCapacity() && !itr.hasNext()) {
                collection.add(element);
            }

        }
    }

    /**
     * Обновить элемент по его id
     */
    public boolean update_by_id(Integer updateId) {
        for(Vehicle v: collection) {
            if (v.getId() == updateId) {
                collection.remove(v);
                return true;
            }
        }
        return false;
    }

    /**
     * Удалить элемент по его id
     */
    public boolean remove_by_id(Integer deleteId) {
        for(Vehicle v: collection) {
            if (v.getId() == deleteId) {
                collection.remove(v);
                return true;
            }
        }
        return false;
    }

    /**
     * Удалить элементы больше заданного
     */
    public void remove_greater(Vehicle element) {
        collection.removeIf(v -> v.getDistanceTravelled() > element.getDistanceTravelled() && v.getCapacity() > element.getCapacity() && v.getEnginePower() > element.getEnginePower());
    }

    /**
     * Удалить элементы меньше заданного
     */
    public void remove_lower(Vehicle element) {
        collection.removeIf(v -> v.getDistanceTravelled() < element.getDistanceTravelled() && v.getCapacity() < element.getCapacity() && v.getEnginePower() < element.getEnginePower());
    }

    /**
     * Вывести элемент с максимальным Id
     */
    public void max_by_id() {
        Set<Vehicle> orderTreeSet = new TreeSet<Vehicle>(Comparator.comparingDouble(Vehicle::getId));
        orderTreeSet.addAll(collection);
        Iterator<Vehicle> itr = orderTreeSet.iterator();
        while (itr.hasNext()) {
            Vehicle v = itr.next();
            if (!itr.hasNext()) {
                System.out.println(v);
                break;
            }
        }
    }

    /**
     * Вывести элементы индекс поля Type которого больше чем индекс введеного Type
     */
    public void filter_greater_than_type(String vehicleType) {
        int ord = VehicleType.valueOf(vehicleType).ordinal();
        for(Vehicle v : collection) {
            if (VehicleType.valueOf(v.getType()).ordinal() > ord) {
                System.out.println(v);
            }
        }
    }

}
