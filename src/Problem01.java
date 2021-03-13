import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Done")){
            String[]token = command.split("\\s+");
            switch (token[0]){
                case "Change":
                    String symbol = token[1];
                   String replacement = token[2];
                  String replaced = line.replaceAll(symbol,replacement);
                   System.out.println(replaced);
                   line = replaced;
                    break;
                case "Includes":
                    String include = token[1];
                    if(line.contains(include)){
                        System.out.println("True");
                    }else{
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String end = token[1];
                    if(line.endsWith(end)){
                        System.out.println("True");
                    }else{
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    String upper = line.toUpperCase();
                    System.out.println(upper);
                    line = upper;
                    break;
                case "FindIndex":
                    String finded = token[1];
                    System.out.println(line.indexOf(finded));
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(token[1]);
                    int lenght = Integer.parseInt(token[2]);
                    String substring = line.substring(startIndex,startIndex+lenght);
                    System.out.println(substring);
                    line = substring;
                    break;

            }
            command = scanner.nextLine();

        }

    }
}
