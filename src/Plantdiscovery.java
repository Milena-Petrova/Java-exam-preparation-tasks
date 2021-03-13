import java.util.*;

public class Plantdiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Plant> plants = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] commandLine = scanner.nextLine().split("<->");
            String plant = commandLine[0];
            int rarety = Integer.parseInt(commandLine[1]);
            Plant p = new Plant(plant, rarety);
            plants.put(plant, p);
        }

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {
            String[] token = command.split(": ");
            switch (token[0]) {
                case "Rate":
                    String[]line=token[1].split(" - ");
                    String rateName = line[0];
                    int rating = Integer.parseInt(line[1]);
                    Plant ratePlant = plants.get(rateName);
                    if (ratePlant != null) {
                        plants.get(rateName).addRating(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    String[]lineUpdate = token[1].split(" - ");
                    String updateName = lineUpdate[0];
                    int newRarity = Integer.parseInt(lineUpdate[1]);
                    Plant updateRarety = plants.get(updateName);
                    if (updateRarety != null) {
                        updateRarety.setRarety(newRarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    String resetName = token[1];
                    Plant resetPlant = plants.get(resetName);
                    if (resetPlant != null) {
                        resetPlant.resetRatings();
                    }else{
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
            }

            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.values().stream()
                .sorted((a, b) -> {
                    if (a.getRarety() != b.getRarety()) {
                        return Integer.compare(b.getRarety(), a.getRarety()); //сравнява интове
                    } else {
                        return Double.compare(b.getAverageRate(), a.getAverageRate());
                    }
                })
                .map(p -> "- " + p.getName() + "; Rarity: " + p.getRarety() + "; Rating: " + String.format("%.2f", p.getAverageRate()))
                .forEach(s -> System.out.println(s));
//        plants.values().stream()
//                .sorted((a, b) -> {
//                    if (b.getRarety() != a.getRarety()) {
//                        return Integer.compare(b.getRarety(), a.getRarety());
//                    } else {
//                        return Double.compare(b.getAverageRate(), a.getAverageRate());
//                    }
//                }).forEach(a -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", a.getName(), a.getRarety(), a.getAverageRate()));
    }

    public static class Plant {
        String name;
        int rarety;
        List<Double> ratings = new ArrayList<>();

        public Plant(String name, int rarety) {
            this.name = name;
            this.rarety = rarety;
        }

        public String getName() {
            return name;
        }

        public void setRarety(int rarety) {
            this.rarety = rarety;
        }

        public int getRarety() {
            return rarety;
        }

        public void resetRatings() {
            this.ratings.clear();
        }

        public Double getAverageRate() {
            if (this.ratings.isEmpty()) {
                return 0.0;
            }
            double average = 0.0;
            for (Double a : this.ratings) {
                average += a;
            }
            average = average / this.ratings.size();
            return average;
        }

        public void addRating(double rating) {
            this.ratings.add(rating);
        }
    }
}

