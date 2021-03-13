import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        BigInteger coolThreshold = calculateThreshold(line);
        //int a --> цифровата стойност на изчисления coolthreshold
        int a = coolThreshold.intValue();

        Pattern pattern = Pattern.compile("(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1");
        // Pattern pattern = Pattern.compile("(?<name>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))");

        Matcher matcher = pattern.matcher(line);

        List<String> findEmojis = new ArrayList<>();

        while (matcher.find()) {
            findEmojis.add(matcher.group());
        }
        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", findEmojis.size());
        for (String emoji : findEmojis) {
            int emojiSum = calculateEmojiAsciSum(emoji);
            if (emojiSum > a) {
                System.out.println(emoji);
            }
        }
    }

    private static int calculateEmojiAsciSum(String emoji) {
        int sum = 0;
        for (int i = 2; i < emoji.length() - 2; i++) {
            sum += emoji.charAt(i);
        }
        return sum;
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


