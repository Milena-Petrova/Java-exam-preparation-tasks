import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1";

     BigInteger coolthreshold = calculateThreshold(input);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> validEmojis = new ArrayList<>();

        while (matcher.find()) {
            validEmojis.add(matcher.group());
        }
        System.out.printf("Cool threshold: %d%n", coolthreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", validEmojis.size());
        for (String s : validEmojis) {
            int cool = cool(s);
            if (cool >= coolthreshold.intValue()) {
                System.out.println(s);
            }
        }
    }

    private static int cool(String emoji) {
        int coolValue = 0;
        for (int i = 2; i < emoji.length() - 2; i++) {
            coolValue += emoji.charAt(i);
        }
        return coolValue;
    }

    public static BigInteger calculateThreshold(String line) {
        BigInteger coolThreshold = new BigInteger(String.valueOf(1));
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                int digit = Character.getNumericValue(line.charAt(i));
                BigInteger a = new BigInteger(String.valueOf(digit));
                coolThreshold = coolThreshold.multiply(new BigInteger(String.valueOf(digit)));
            }
        }
        return coolThreshold;
    }
}
