import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirats {
    public static class Target {
        String name;
        int population;
        int gold;

        public Target(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPopulation(int population) {
            this.population += population;
        }

        public void setGold(int gold) {
            this.gold += gold;
        }

        public void killPopulation(int population) {
            this.population -= population;
        }

        public void stoleGold(int gold) {
            this.gold -= gold;
        }

        public String getName() {
            return name;
        }

        public int getPopulation() {
            return population;
        }

        public int getGold() {
            return gold;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Map<String, Target> targets = new TreeMap<>();

        while (!command.equals("Sail")) {
            String[] targetCommand = command.split("\\|\\|");
            String targetName = targetCommand[0];
            Target t = new Target(targetName);
            targets.putIfAbsent(targetName, t);
            if (targets.get(targetName) != null) {
                targets.get(targetName).setPopulation(Integer.parseInt(targetCommand[1]));
                targets.get(targetName).setGold(Integer.parseInt(targetCommand[2]));
            }
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] token = command.split("=>");
            switch (token[0]) {
                case "Prosper":
                    String townName = token[1];
                    int moreGold = Integer.parseInt(token[2]);
                    if (moreGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        targets.get(townName).setGold(moreGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", moreGold, townName, targets.get(townName).getGold());
                    }
                    break;
                case "Plunder":
                    String town = token[1];
                    int people = Integer.parseInt(token[2]);
                    int gold = Integer.parseInt(token[3]);
                    targets.get(town).killPopulation(people);
                    targets.get(town).stoleGold(gold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    if (targets.get(town).getGold() == 0 || targets.get(town).getPopulation() == 0) {
                        targets.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        if (targets.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", targets.size());
            targets.values().stream()
                    .sorted((a, b) -> {
                        if (a.getGold() != b.getGold()) {
                            return Integer.compare(b.getGold(), a.getGold());
                        } else {
                            return a.getName().compareTo(b.getName());
                        }
                    })
                    .forEach(a -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", a.getName(), a.getPopulation(), a.getGold()));
        }
    }
}
