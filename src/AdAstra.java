import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra{
    public static class Food{
        String name;
        String date;
        int calories;

        public Food(String name, String date, int calories) {
            this.name = name;
            this.date = date;
            this.calories = calories;
        }
        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }
        public int getCalories() {
            return calories;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String regex ="([#|])(?<item>[A-Z a-z]+)\\1(?<date>[0-9]{2}[/][0-9]{2}[/][0-9]{2})\\1(?<calories>\\d{1,})\\1";
        //(\\||#)(?<item>[A-Z a-z]+)\\1(?<date>[0-9]{2}[/][0-9]{2}[/][0-9]{2})\\1(?<calories>\\d{1,})\\1

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        List<Food> foods = new ArrayList<>();
        int calorySum=0;
        while (matcher.find()){
           Food f = new Food(matcher.group("item"), matcher.group("date"),Integer.parseInt(matcher.group("calories")));
            foods.add(f);
            calorySum+=Integer.parseInt(matcher.group("calories"));
        }
        System.out.printf("You have food to last you for: %d days!%n",calorySum/2000);
        for (int i = 0; i < foods.size(); i++) {
            System.out.println("Item: "+foods.get(i).getName()+", Best before: "+foods.get(i).getDate()+", Nutrition: "+foods.get(i).getCalories());
        }
    }
}


