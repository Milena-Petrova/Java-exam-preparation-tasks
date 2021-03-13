import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mirrorwords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(@|#)(?<word>[A-Za-z]{3,})\\1\\1(?<mirror>[A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> pairs = new ArrayList<>();
        int countvalid = 0;
        while (matcher.find()) {
            countvalid++;
            String word = matcher.group("word");
            String mirror = matcher.group("mirror");
            if (word.equals(reverseWord(mirror))) {
                String pair = String.format("%s <=> %s", word, mirror);
                pairs.add(pair);
            }
        }
        if (countvalid == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", countvalid);
        }
            if (!pairs.isEmpty()) {
                System.out.println("The mirror words are: ");
                for (int i = 0; i < pairs.size(); i++) {
                    System.out.print(pairs.get(i));
                    if (i < pairs.size() - 1) {
                        System.out.print(", ");
                    }
                }
            } else {
                System.out.println("No mirror words!");
            }
        }


    private static String reverseWord(String word) {
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }
        return reversed;
    }
}
