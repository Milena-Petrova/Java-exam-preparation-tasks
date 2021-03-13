import java.util.Scanner;

public class TheLimitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder decryptedMessage = new StringBuilder(input);

        String command = scanner.nextLine();

        while (!command.equals("Decode")) {
            String[] token = command.split("\\|");
            switch (token[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(token[1]);
                    for (int i = 0; i < numberOfLetters ; i++) {
                        char c = decryptedMessage.charAt(0);
                        decryptedMessage.append(c);
                        decryptedMessage.deleteCharAt(0);
                    }
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(token[1]);
                    String value = token[2];
                    decryptedMessage = decryptedMessage.insert(insertIndex,value);

                    break;
                case "ChangeAll":
                    String s = token[1];
                    String replacement = token[2];
                    decryptedMessage = new StringBuilder(decryptedMessage.toString().replace(s,replacement));
                    break;
            }
        command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s",decryptedMessage);
    }
}
