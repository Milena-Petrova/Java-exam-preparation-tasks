import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder message = new StringBuilder(input);

        String command = scanner.nextLine();
        while (!command.equals("Reveal")) {
            String[] token = command.split(":\\|:");
            switch (token[0]) {
                case "InsertSpace":
                    int insertIndex = Integer.parseInt(token[1]);
                    message = message.insert(insertIndex, " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substringReverse = token[1];
                    if (message.toString().contains(substringReverse)) {
                        message = new StringBuilder(message.toString().replaceFirst(substringReverse, ""));
                        for (int i = substringReverse.length()-1; i >= 0; i--) {
                            message = message.append(substringReverse.charAt(i));
                        }
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substr = token[1];
                    String replacement = token[2];
                    message = new StringBuilder(message.toString().replaceAll(substr, replacement));
                    System.out.println(message);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
