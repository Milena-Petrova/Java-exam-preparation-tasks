import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        String regex = "^([$%])[A-Z][a-z]{2,}\\1: (\\[)\\d+(\\]\\|)\\2\\d+\\3\\2\\d+\\3$";

        for (int i = 0; i < input ; i++) {
            String command = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(command);

            if(matcher.find()){
                String[]match = matcher.group().split("\\s+");
                String message = match[0];
                String digit = match[1];
                String digitExp = "\\d{2,}\\d?";
                Pattern p = Pattern.compile(digitExp);
                Matcher m1= p.matcher(digit);
                String result1="";
                while (m1.find()){
                   int aa =Integer.parseInt(m1.group());
                   char c = (char)aa;
                   result1 +=c;//concatinate chars
                }
                System.out.println(message+" "+result1);
         }else{
                System.out.println("Valid message not found!");
            }
        }
    }
}

