import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class NeedForSpeed {
    public static class Car {
        String name;
        int mileage;
        int fuel;

        public Car(String name, int mileage, int fuel) {
            this.name = name;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getName() {
            return name;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public void increaseMileage(int mileage) {
            this.mileage += mileage;
        }

        public void decreaseMilege(int mileage) {
            this.mileage -= mileage;
        }

        public void setFuel(int fuel) {
            this.fuel -= fuel;
        }

        public void setRefuel(int fuel) {
            this.fuel += fuel;
        }

        public int getFuel() {
            return fuel;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\|");
            String name = line[0];
            int distance = Integer.parseInt(line[1]);
            int fuel = Integer.parseInt(line[2]);
            Car c = new Car(name, distance, fuel);
            cars.put(c.getName(), c);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] token = command.split(" : ");
            switch (token[0]) {
                case "Drive":
                    String driveName = token[1];
                    int driveDistance = Integer.parseInt(token[2]);
                    int driveFuel = Integer.parseInt(token[3]);
                    Car c = cars.get(driveName);
                    if (driveFuel >= c.getFuel()) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        cars.get(driveName).increaseMileage(driveDistance);
                        cars.get(driveName).setFuel(driveFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", driveName, driveDistance, driveFuel);
                    }
                    //  if(cars.get(driveName).getMileage()>=100000)
                    if (c.getMileage() >= 100000) {
                        cars.remove(driveName);
                        System.out.printf("Time to sell the %s!%n", driveName);
                    }
                    break;
                case "Refuel":
                    String refuelName = token[1];
                    int refuel = Integer.parseInt(token[2]);
                    Car c1 = cars.get(refuelName);
                    if (c1.getFuel() + refuel > 75) {
                        refuel = 75 - c1.getFuel();
                    }
                    c1.setRefuel(refuel);
                    System.out.printf("%s refueled with %d liters%n", refuelName, refuel);
                    break;
                case "Revert":
                    String revertName = token[1];
                    int revertMileage = Integer.parseInt(token[2]);
                    Car c2 = cars.get(revertName);
                    cars.get(revertName).decreaseMilege(revertMileage);
                    if (c2.getMileage() < 10000) {
                        c2.setMileage(10000);
                    }else{
                        System.out.printf("%s mileage decreased by %d kilometers%n",revertName,revertMileage);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        cars.values().stream()
                .sorted((a, b) -> {
                    if (a.getMileage() != b.getMileage()) {
                        return Integer.compare(b.getMileage(), a.getMileage());
                    }
                    return a.getName().compareTo(b.getName());
                })
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getName(), e.getMileage(), e.getFuel()));
    }
}
