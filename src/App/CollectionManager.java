package App;

import Collections.Vehicle;
import Collections.VehicleType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;

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

    public void save() {
        storage.write();
    }
    
    public TreeSet<Vehicle> getCollection() {
        return collection;
    }
    
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

    public void print_ascending() {
        Set<Vehicle> orderTreeSet = new TreeSet<Vehicle>(Comparator.comparingDouble(Vehicle::getId));
        orderTreeSet.addAll(collection);
        for (Vehicle vehicle: orderTreeSet) {
            System.out.println(vehicle.toString());
        }

    }

    public void show() {
        for (Vehicle vehicle: collection) {
            System.out.println(vehicle.toString());
        }
    }

    public void clear() {
        collection.clear();
        System.out.println("Cleared the collection");
    }

    public int getNewId() {
        return ++vehicleId;
    }

    public void add(Vehicle v) {
        collection.add(v);
    }

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

    public boolean update_by_id(Integer updateId) {
        for(Vehicle v: collection) {
            if (v.getId() == updateId) {
                collection.remove(v);
                return true;
            }
        }
        return false;
    }

    public boolean remove_by_id(Integer deleteId) {
        for(Vehicle v: collection) {
            if (v.getId() == deleteId) {
                collection.remove(v);
                return true;
            }
        }
        return false;
    }

    public void remove_greater(Vehicle element) {
        collection.removeIf(v -> v.getDistanceTravelled() > element.getDistanceTravelled() && v.getCapacity() > element.getCapacity() && v.getEnginePower() > element.getEnginePower());
    }

    public void remove_lower(Vehicle element) {
        collection.removeIf(v -> v.getDistanceTravelled() < element.getDistanceTravelled() && v.getCapacity() < element.getCapacity() && v.getEnginePower() < element.getEnginePower());
    }

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

    public void filter_greater_than_type(String vehicleType) {
        int ord = VehicleType.valueOf(vehicleType).ordinal();
        for(Vehicle v : collection) {
            if (VehicleType.valueOf(v.getType()).ordinal() > ord) {
                System.out.println(v);
            }
        }
    }

}
