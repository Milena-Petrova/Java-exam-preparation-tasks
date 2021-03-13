import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String regex = "([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        List<String> destinations = new ArrayList<>();

        while (matcher.find()) {
            destinations.add(matcher.group("destination"));
        }
        int travelPoints = 0;
        System.out.print("Destinations: ");
        for (int i = 0; i < destinations.size(); i++) {
            System.out.print(destinations.get(i));
            if (i < destinations.size() - 1) {
                System.out.print(", ");
            }
            int lenght = destinations.get(i).length();
            travelPoints += lenght;
        }
        System.out.println();
        System.out.println("Travel Points: "+travelPoints);

    }
}
